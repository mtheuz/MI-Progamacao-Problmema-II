package model.PartidaPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.JogadorPackage.Jogador;
import model.JogadorPackage.JogadorDaoImpl;
import model.SelecaoPackage.Selecao;
import model.SelecaoPackage.SelecaoDaoImpl;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class PartidaDaoImpl implements PartidaDAO{
	private SelecaoDaoImpl selecao = new SelecaoDaoImpl();
	TratamentosExcecoes tratamento = new TratamentosExcecoes();
	
	private Map<String,List<Partida>> partidas = new HashMap<String,List<Partida>>();
	
	private String[] estadios = {"Al Bayt", "Khalifa International", "Al Thumama", "Ahmad Bin Ali",
			"Lusail", "Ras Abu Aboud (974)", "Education City", "Al Janoub"};
	
	public Map<String,List<Partida>> getPartidas() {
		return partidas; 
	}
	public PartidaDaoImpl(ArrayList<Selecao> selecoes){
		selecao.setListaSelecoes(selecoes); 
	}
	private JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
	private List<String> inputData() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("\n[Digite a data da partida]");
		String[] dataformat = {"Dia","Mes","Ano"};
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < dataformat.length; i++) {
			System.out.printf("Digite o %s: ",dataformat[i]);
			String entradaData = entrada.next();
			data.add(entradaData);
			
		}
		return data;
	}
	
	private List<String> inputHora(){
		Scanner entrada = new Scanner(System.in);
		List<String> hora = new ArrayList<String>();
		String[] horaformat = {"Hora","Minuto"};
		System.out.println("[Digite o horario da partida]");
		int controle = 0;
		
		for (int i = 0; i < horaformat.length; i++) {
			System.out.printf("Digite o(a) %s: ",horaformat[i]);
			String entradaData = entrada.next();
		do {
			if(entradaData.length() == 2 || !tratamento.validaNome(entradaData)) {
				hora.add(entradaData);
				controle = 1;
			}
			else {
				System.err.println("Entrada inválida");
			}
		}while(controle!=1);
		}
		
		return hora;
	}
	
	
	private boolean inputGols(Partida partida) {
		
		Scanner entrada = new Scanner(System.in);
		System.out.printf("A selecao %s fez gol?\n[0]Nao\n[1]Sim\n",partida.getSelecao1());
		int respGols = tratamento.validaInt(0,1);
		if(respGols == 1) {
			System.out.printf("Quantos jogadores marcaram pelo %s?", partida.getSelecao1());
			int quantidadeGolsJogadores = entrada.nextInt();
			for (int i = 0; i < quantidadeGolsJogadores; i++) {
				final String nomeDaSelecao = partida.getSelecao1();
				jogadores.listarJogadores(nomeDaSelecao);
				
				String codigo = entrada.next();
				if(jogadores.verificaExistencia(codigo)) {
				System.out.println("Digite a quantidade de Gols que ele marcou: ");
				String gols = entrada.next();
				List<String> gols1 = new ArrayList<String>();
				gols1.add(codigo);
				gols1.add(gols);
				jogadores.atualizarGolsMarcados(codigo, nomeDaSelecao, gols);
				partida.setGolsSelecao1(gols1);
				return true;
				}
				System.out.println("Jogador não Cadastrado");
				quantidadeGolsJogadores++;
				}
				return false;
			}
		
		
		System.out.printf("A selecao %s fez gol?\n[0]Nao\n[1]Sim",partida.getSelecao2());
		int respGols2 = tratamento.validaInt(0,1);
		if(respGols2 == 1) {
			System.out.printf("Quantos jogadores Marcaram pelo %s?", partida.getSelecao2());
			int quantidadeGolsJogadores = entrada.nextInt();
			for (int i = 0; i < quantidadeGolsJogadores; i++) {
				final String nomeDaSelecao = partida.getSelecao2();
				jogadores.listarJogadores(nomeDaSelecao);
				System.out.println("Digite o codigo do jogador que marcou:");
				String codigo = entrada.next();
				if(jogadores.verificaExistencia(codigo)) {
					System.out.println("Digite a quantidade de Gols que ele marcou: ");
					String gols = entrada.next();
					List<String> gols2 = new ArrayList<String>();
					gols2.add(codigo);
					gols2.add(gols);
					jogadores.atualizarGolsMarcados(codigo, nomeDaSelecao, gols);
					partida.setGolsSelecao2(gols2);
					
					return true;
					}
					System.out.println("Jogador não Cadastrado");
					quantidadeGolsJogadores++;
					}
					return false;			
					}
		return false;
	}
	
	private void inputCartoes(Partida partida) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		Scanner entrada = new Scanner(System.in);
		System.out.printf("Os jogadores da(o) selecao %s receberam cartoes?\n[0]Nao\n[1]Sim\n",partida.getSelecao1());
		int respCartoaAmarelo1 = tratamento.validaInt(0,1);
		if(respCartoaAmarelo1 == 1) {
			System.out.printf("Quantos jogadores receberam cartoes? ");
			int quantidadeDeCartoes= entrada.nextInt();
			for (int i = 0; i < quantidadeDeCartoes; i++) {
				final String nomeDaSelecao = partida.getSelecao1();
				jogadores.listarJogadores(nomeDaSelecao);
				System.out.println("Digite o codigo do jogador que recebeu o cartao:");
				String codigo = entrada.next();
				System.out.println("[1]Cartao Amarelo\n[2]Cartao Vermelho\n");
				int cartao = tratamento.validaInt(0,1);
				
				if(cartao == 1) {
					System.out.println("Digite a quantidade de cartoes");
					String cartaoAmarelo = entrada.next();
					List<String> cartoesAmarelos = new ArrayList<String>();
					cartoesAmarelos.add(codigo);
					cartoesAmarelos.add(cartaoAmarelo);
					jogadores.atulizarCartoesAmarelos(codigo, nomeDaSelecao, cartaoAmarelo);
					partida.setCartoesAmarelosSelecao1(cartoesAmarelos);
					mostrarPartida(partida.getSelecao1(), codigo);
				}
				else if(cartao == 2) {
					List<String> cartoesVermelhos = new ArrayList<String>();
					cartoesVermelhos.add(codigo);
					cartoesVermelhos.add("1");
					jogadores.atualizarCartoesVermelhos(codigo, nomeDaSelecao, "1");
					partida.setCartoesVermelhosSelecao1(cartoesVermelhos);
				}
				
			}
			
			
		}
		System.out.printf("Os jogadores da(o) selecao %s receberam cartoes?\n[0]Nao\n[1]Sim",partida.getSelecao2());
		int respCartoaAmarelo2 = tratamento.validaInt(0,1);
		if(respCartoaAmarelo2 == 1) {
			System.out.printf("Quantos jogadores receberam cartoes? ");
			int quantidadeDeCartoes= entrada.nextInt();
			for (int i = 0; i < quantidadeDeCartoes; i++) {
				final String nomeDaSelecao = partida.getSelecao2();
				jogadores.listarJogadores(nomeDaSelecao);
				System.out.println("Digite o codigo do jogador que recebeu o cartao:");
				String codigo = entrada.next();
				System.out.println("[1]Cartao Amarelo\n[2]Cartao Vermelho\n");
				int cartao = entrada.nextInt();
				
				if(cartao == 1) {
					System.out.println("Digite a quantidade de cartoes");
					String cartaoAmarelo = entrada.next();
					List<String> cartoesAmarelos = new ArrayList<String>();
					cartoesAmarelos.add(codigo);
					cartoesAmarelos.add(cartaoAmarelo);
					jogadores.atulizarCartoesAmarelos(codigo, nomeDaSelecao, cartaoAmarelo);
					partida.setCartoesAmarelosSelecao2(cartoesAmarelos);
					mostrarPartida(partida.getSelecao2(), codigo);
				}
				else if(cartao == 2) {
					List<String> cartoesVermelhos = new ArrayList<String>();
					cartoesVermelhos.add(codigo);
					cartoesVermelhos.add("1");
					jogadores.atualizarCartoesVermelhos(codigo, nomeDaSelecao, "1");
					partida.setCartoesVermelhosSelecao2(cartoesVermelhos);
				}
				
			}
			
		}
	}
	private int inputLocal() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("[Digite o local da partida]");
		for (int i = 0; i < estadios.length; i++) {
			System.out.printf("[%d]%s\n",i,estadios[i]);
		}
		System.out.println("");
		int local = tratamento.validaInt(0,estadios.length);
		return local;
	}
	@Override
	public void inserir() {
		
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		Scanner entrada = new Scanner(System.in);
		imprimeGrupos();
		System.out.println("Digite o indice grupo que deseja inserir a partida");
		int numPartida = tratamento.validaInt(0,grupos.length);
		int opcao = 1;
		//
		do {
		listarPartida(grupos[numPartida]);
		System.out.println("Digite o indice da partida que deseja inserir");
		int indicePartida = tratamento.validaInt(0,6);
		//
		
		
		
				
		final Partida partida = this.partidas.get(grupos[numPartida]).get(indicePartida);
		if(verificaCadastroCompleto(partida.getSelecao1()) && verificaCadastroCompleto(partida.getSelecao2()))
			
		{
			System.out.printf("|Partida: %s X %s|",partida.getSelecao1(),partida.getSelecao2());
			List<String> data = inputData();
			System.out.println("");
			//
			List<String> hora = inputHora();
			System.out.println("");
			//
			System.out.println("");
			int local = inputLocal();
			inputGols(partida);
			System.out.println("");
			inputCartoes(partida);
			//
			
			partida.setData(data.get(0)+ "/" + data.get(1) + "/" + data.get(2));
			partida.setHorario(hora.get(0) + ":" + hora.get(1));
			partida.setLocal(estadios[local]);
			partida.setSituacao(true);
			//
			System.out.println("");
			System.out.println("-----------------Partida Gerada-----------------");
			mostrarPartida(grupos[numPartida], partida.getCodigo());
		}
		else {
			System.out.println("Uma das selecoes da partida ou ambas nao foram cadastradas por completo no sistema");
			System.out.println("Cadastre as selecoes antes de cadastrar a partida\n");
		}
		System.out.println("\nDeseja cadastar outra partida?\n[0]Nao\n[1]Sim\n");
		opcao = tratamento.validaInt(0, 1);
		} while (opcao != 0);
	}


	private boolean verificaCadastroCompleto(String nome) {
		ArrayList<Selecao> listaSelecoes = selecao.getListaSelecoes();
		for(Selecao selecao : listaSelecoes)
		{
			if(selecao.getNome().equals(nome))
			{
				if(selecao.getListaJogadores().size()>0)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	@Override
	public void deletar(String codigo) {
		for (Map.Entry<String, List<Partida>> partida : partidas.entrySet()) {
			for (int i = 0; i < partida.getValue().size(); i++) {
				if(partida.getValue().get(i).getCodigo().equals(codigo)) {
					final Partida dPartida = partida.getValue().get(i);
					dPartida.setData("");
					dPartida.setData("");
					dPartida.setHorario("");
					dPartida.setLocal("");
					dPartida.setSituacao(false);
					//dPartida.setCartoesAmarelosSelecao1(-1*dPartida.getCartoesAmarelosSelecao1());
					//dPartida.setCartoesAmarelosSelecao2(-1*dPartida.getCartoesAmarelosSelecao2());
					//dPartida.setCartoesVermelhosSelecao1(-1*dPartida.getCartoesVermelhosSelecao1());
					//dPartida.setCartoesVermelhosSelecao2(-1*dPartida.getCartoesVermelhosSelecao2());
					//dPartida.setGolsSelecao1(-1*dPartida.getGolsSelecao1());
					//dPartida.setGolsSelecao2(-1*dPartida.getGolsSelecao2());
					mostrarPartida(partida.getKey(), codigo);
					
				}
			}
		}
		
	}
	
	private String geraid() throws InterruptedException {
		LocalDateTime dataagr = LocalDateTime.now();
		Thread.sleep(10);
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmnn");
	    String coddate = dataagr.format(formato);
		return coddate;
	}
	

	public void geraPartidas() throws InterruptedException {
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		for (int i = 0; i < grupos.length; i++) {
			List<String> grupoSelecao = organizaGrupo(grupos[i]);
			List<Partida> partidaGrupo= new ArrayList<Partida>();
			for(int c = 0; c < grupoSelecao.size(); c++) {
				for(int j = c+1; j < (grupoSelecao.size()); j++) {
					String selecao1 = grupoSelecao.get(c);
					String selecao2 = grupoSelecao.get(j);
					Partida jogo = new Partida(selecao1,selecao2);
					jogo.setCodigo(geraid());
					partidaGrupo.add(jogo);
					this.partidas.put(grupos[i], partidaGrupo);
					
				}
			}
		}
	}
	private List<String> organizaGrupo(String grupo) {
		List<String> grupoSelecao = new ArrayList<>();
				for(Selecao selecao: selecao.getListaSelecoes()) {
					if(selecao.getGrupo().equals(grupo)) {
						grupoSelecao.add(selecao.getNome());
				}
		}
		return grupoSelecao;
	}
	public void imprimeGrupos(){

		System.out.println("[Lista de Grupos]");
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		//String[] grupos = {"A","B"};

		for (int i = 0; i < grupos.length; i++) {
			System.out.printf("[%d] Grupo %s\n",i,grupos[i]);
			for(Selecao selecao: selecao.getListaSelecoes()) {
				if(selecao.getGrupo().equals(grupos[i])) {
					System.out.printf("-%s\n",selecao.getNome());
				}
			
			}
			System.out.println("-------------");
		}
		System.out.println("");
	}
	public void listarPartida(String grupo) {
		List<Partida> jogo = partidas.get(grupo);
		for (int i = 0; i < jogo.size(); i++) {
			if(!jogo.get(i).isSituacao())
			System.out.printf("[%d] %s X %s\n",i,jogo.get(i).getSelecao1(),jogo.get(i).getSelecao2());
		}
		System.out.println("");
		
	}
	
	public void listarTodasPartidas() {
		System.out.println("[Lista de Partidas]");
		String[] grupos = {"A","B","C","D","E","F","G","H"};

		//String[] grupos = {"A","B"};

		for (int i = 0; i < grupos.length; i++) {
			System.out.printf("Grupo [%s]\n",grupos[i]);
			listarPartida(grupos[i]);
			System.out.println("");
			
		}
		System.out.println("");
	}
	
	
	public void mostrarPartida(String grupo, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		for (Map.Entry<String, List<Partida>> mpartida : partidas.entrySet()) {
			for (int i = 0; i < mpartida.getValue().size(); i++) {
				if(mpartida.getValue().get(i).getCodigo().equals(codigo)) {
					final Partida partida = this.partidas.get(grupo).get(i);
					System.out.printf("Codigo da Partida: %s\n",partida.getCodigo());
					System.out.printf("|%s X %s|\n",partida.getSelecao1(),partida.getSelecao2());
					System.out.printf("Placar: [%d X %d]\n",partida.getGolsSelecao1(),partida.getGolsSelecao2());
					System.out.printf("Local: %s\n", partida.getLocal());
					System.out.printf("Data: %s\n", partida.getData());
					System.out.printf("Horaio: %s\n", partida.getHorario());
					System.out.printf("Cartoes Amarelos [%s]:\n", partida.getSelecao1());
					for(List<String> jogador: partida.getCartoesAmarelosSelecao1()) {
						if(jogador.size()> 0) {
							System.out.printf("%s - [%s] Cartao amarelo\n",jogadores.retornaJogadorNome(jogador.get(0)),jogador.get(1));
						}
						else {
							System.out.printf("Nenhum jogador da [%s] recebeu cartão amarelo!\n",partida.getSelecao1());
						}
						
					}
					
					System.out.printf("Cartoes Amarelos [%s]:\n", partida.getSelecao2());
					for(List<String> jogador: partida.getCartoesAmarelosSelecao2()) {
						if(jogador.size()> 0 ) {
							System.out.printf("%s - [%s] Cartao Amarelo\n",jogadores.retornaJogadorNome(jogador.get(0)),jogador.get(1));
						}
						else {
							System.out.printf("Nenhum jogador da [%s] recebeu cartão amarelo!\n",partida.getSelecao2());
						}
						
					}
					
					System.out.printf("Cartoes Vermelhos [%s]:\n", partida.getSelecao1());
					for(List<String> jogador: partida.getCartoesVermelhosSelecao1()) {
						if(jogador.size()> 0) {
							System.out.printf("%s - [%s] Cartao Vermelho\n",jogadores.retornaJogadorNome(jogador.get(0)),jogador.get(1));
						}
						else {
							System.out.printf("Nenhum jogador da [%s] recebeu cartão vermelho",partida.getSelecao1());
						}
						
					}
					
					System.out.printf("Cartoes Vermelhos [%s]:\n", partida.getSelecao2());
					for(List<String> jogador: partida.getCartoesVermelhosSelecao2()) {
						if(jogador.size()> 0) {
							System.out.printf("%s - [%s] Cartao Vermelho\n",jogadores.retornaJogadorNome(jogador.get(0)),jogador.get(1));
						}
						else {
							System.out.printf("Nenhum jogador da [%s] recebeu cartão vermelho",partida.getSelecao2());
						}
						
					}
					System.out.println("---------------------------------------\n");
				
				}
				}
			}
		
	}
	
	
	
	private void listarTodasPartidasCodigo() {
		System.out.println("[Lista de Partidas]");
		String[] grupos = {"A","B","C","D","E","F","G"};
		for (int i = 0; i < grupos.length; i++) {
			System.out.printf("Grupo [%s]\n",grupos[i]);
			listarPartidaCodigo(grupos[i]);
			System.out.println("");
			
		}
		System.out.println("\n");
	}
	
	
	public void listarPartidaCodigo(String grupo) {
		List<Partida> jogo = partidas.get(grupo);
		for (int i = 0; i < jogo.size(); i++) {
			if(!jogo.get(i).isSituacao())
			System.out.printf("[%s] %s X %s\n",jogo.get(i).getCodigo(),jogo.get(i).getSelecao1(),jogo.get(i).getSelecao2());
		}
		System.out.println("\n");
		
	}
	
	public void atualizar(String codigo) {
		listarTodasPartidasCodigo();
		Scanner entrada = new Scanner(System.in);
		for (Map.Entry<String, List<Partida>> partida : partidas.entrySet()) {
			for (int i = 0; i < partida.getValue().size(); i++) {
				if(partida.getValue().get(i).getCodigo().equals(codigo)) {
					final Partida dPartida = partida.getValue().get(i);
					System.out.printf("Digite por indice o que deseja atualizar:\n"
							+ "[1] Data\n"
							+ "[2] Horario\n "
							+ "[3] Local\n"
							+ "[4] Cartoes Amarelos para a selecao do(a) %s\n"
							+ "[5] Cartoes Amarelos para a selecao do(a) %s\\n"
							+ "[6] Cartoes Vermelhos para a selecao do(a) %s\n"
							+ "[7] Cartoes Amarelos para a selecao do(a) %s\n"
							+ "[8] Quantidade de Gols para a selexao do(a) %s\n"
							+ "[9] Quantidade de Gols para a selexao do(a) %s\n",
							dPartida.getSelecao1(),
							dPartida.getSelecao2(),
							dPartida.getSelecao1(),
							dPartida.getSelecao2(),
							dPartida.getSelecao1(),
							dPartida.getSelecao2()
							);
					int opcaoUpdate = tratamento.validaInt(1,9);
					
				switch (opcaoUpdate) {
				case 1:
					List<String> data = inputData();
					dPartida.setData(data.get(0)+ "/" + data.get(1) + "/" + data.get(2));
					break;
				case 2:
					List<String> hora = inputHora();
					dPartida.setHorario(hora.get(0) + ":" + hora.get(1));
					break;
				case 3:
					int local = inputLocal();
					dPartida.setLocal(estadios[local]);
					break;
				case 4:
					
					break;
				case 5:
					
					break;	
				case 6:
					
					break;
				case 7:
					
					break;
				case 8:
					
					break;
				case 9:
					
					break;
				default:
					break;
				}
			
							
					
				}
			}
			
		}
		
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}


