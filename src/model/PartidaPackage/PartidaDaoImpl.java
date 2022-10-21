package model.PartidaPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.JogadorPackage.JogadorDaoImpl;
import model.SelecaoPackage.Selecao;
import model.SelecaoPackage.SelecaoDaoImpl;




public class PartidaDaoImpl implements PartidaDAO{
	private SelecaoDaoImpl selecao = new SelecaoDaoImpl();
	private JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
	private Map<String,List<Partida>> partidas = new HashMap<String,List<Partida>>();
	private String[] estadios = {"Al Bayt", "Khalifa International", "Al Thumama", "Ahmad Bin Ali",
			"Lusail", "Ras Abu Aboud (974)", "Education City", "Al Janoub"};
	
	public PartidaDaoImpl(ArrayList<Selecao> selecoes){
		selecao.setListaSelecoes(selecoes);
	}
	@Override
	public void inserir() {
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		Scanner entrada = new Scanner(System.in);
		imprimeGrupos();
		System.out.println("Digite o indice grupo que deseja inserir a partida");
		int numPartida = entrada.nextInt();
		int opcao = 1;
		do {
		listarPartida(grupos[numPartida]);
		System.out.println("Digite o indice da partida que deseja inserir");
		int indicePartida = entrada.nextInt();
		//Partida
		//Falta inserir os dados
		
		System.out.printf("|Partida: %s X %s|",partidas.get(grupos[numPartida]).get(indicePartida).getSelecao1(),
				partidas.get(grupos[numPartida]).get(indicePartida).getSelecao2());
		System.out.println("\n[Digite a data da partida]");
		String[] dataformat = {"Dia","Mes","Ano"};
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < dataformat.length; i++) {
			System.out.printf("Digite o %s: ",dataformat[i]);
			String entradaData = entrada.next();
			data.add(entradaData);
			
		}
		System.out.println("");
		
		List<String> hora = new ArrayList<String>();
		String[] horaformat = {"Hora","Minuto"};
		System.out.println("[Digite o horario da partida]");
		for (int i = 0; i < horaformat.length; i++) {
			System.out.printf("Digite o(a) %s: ",horaformat[i]);
			String entradaData = entrada.next();
			hora.add(entradaData);
		}
		System.out.println("");
		System.out.println("[Digite o local da partida]");
		for (int i = 0; i < estadios.length; i++) {
			System.out.printf("[%d]%s\n",i,estadios[i]);
		}
		System.out.println("");
		
		int local = entrada.nextInt();
		System.out.printf("A selecao %s fez gol?\n[0]Nao\n[1]Sim",partidas.get(grupos[numPartida]).get(indicePartida).getSelecao1());
		int respGols = entrada.nextInt();
		if(respGols == 1) {
			System.out.printf("Quantos jogadores marcaram pelo %s?", partidas.get(grupos[numPartida]).get(indicePartida).getSelecao1());
			int quantidadeGolsJogadores = entrada.nextInt();
			for (int i = 0; i < quantidadeGolsJogadores; i++) {
				final String nomeDaSelecao = partidas.get(grupos[numPartida]).get(indicePartida).getSelecao1();
				jogadores.listarJogadores(nomeDaSelecao);
				System.out.println("Digite o codigo do jogador:");
				String codigo = entrada.next();
				System.out.println("Digite a quantidade de Gols que ele marcou: ");
				String gols = entrada.next();
				jogadores.atualizarDadosJogador(codigo, 5, gols, nomeDaSelecao);
				partidas.get(grupos[numPartida]).get(indicePartida).setGolsSelecao1(Integer.parseInt(gols));
			}
			
		}
		System.out.printf("A selecao %s fez gol?\n[0]Nao\n[1]Sim",partidas.get(grupos[numPartida]).get(indicePartida).getSelecao2());
		int respGols2 = entrada.nextInt();
		if(respGols2 == 1) {
			System.out.printf("Quantos jogadores Marcaram pelo %s?", partidas.get(grupos[numPartida]).get(indicePartida).getSelecao2());
			int quantidadeGolsJogadores = entrada.nextInt();
			for (int i = 0; i < quantidadeGolsJogadores; i++) {
				final String nomeDaSelecao = partidas.get(grupos[numPartida]).get(indicePartida).getSelecao2();
				jogadores.listarJogadores(nomeDaSelecao);
				System.out.println("Digite o codigo do jogador que marcou:");
				String codigo = entrada.next();
				System.out.println("Digite a quantidade de Gols que ele marcou: ");
				String gols = entrada.next();
				jogadores.atualizarDadosJogador(codigo, 5, gols, nomeDaSelecao);
				partidas.get(grupos[numPartida]).get(indicePartida).setGolsSelecao2(Integer.parseInt(gols));
			}
			
		}
		
		System.out.printf("Os jogadores da(o) selecao %s receberam cartoes?\n[0]Nao\n[1]Sim",partidas.get(grupos[numPartida]).get(indicePartida).getSelecao1());
		int respCartoaAmarelo1 = entrada.nextInt();
		if(respCartoaAmarelo1 == 1) {
			System.out.printf("Quantos jogadores receberam cartoes? ");
			int quantidadeDeCartoes= entrada.nextInt();
			for (int i = 0; i < quantidadeDeCartoes; i++) {
				final String nomeDaSelecao = partidas.get(grupos[numPartida]).get(indicePartida).getSelecao1();
				jogadores.listarJogadores(nomeDaSelecao);
				System.out.println("Digite o código do jogador que recebeu o cartao:");
				String codigo = entrada.next();
				System.out.println("[1]Cartao Amarelo\n[2]Cartao Vermelho");
				int cartao = entrada.nextInt();
				if(cartao == 1) {
					System.out.println("Digite a quantidade de cartoes");
					String cartaoAmarelo = entrada.next();
					jogadores.atualizarDadosJogador(codigo, 3, cartaoAmarelo, nomeDaSelecao);
					partidas.get(grupos[numPartida]).get(indicePartida).setGolsSelecao1(Integer.parseInt(cartaoAmarelo));
				}
				else if(cartao == 2) {
					jogadores.atualizarDadosJogador(codigo, 3, "1", codigo);
					partidas.get(grupos[numPartida]).get(indicePartida).setGolsSelecao1(1);
				}
				
			}
			
		}
		System.out.printf("Os jogadores da(o) selecao %s receberam cartoes?\n[0]Nao\n[1]Sim",partidas.get(grupos[numPartida]).get(indicePartida).getSelecao2());
		int respCartoaAmarelo2 = entrada.nextInt();
		if(respCartoaAmarelo2 == 1) {
			System.out.printf("Quantos jogadores receberam cartoes? ");
			int quantidadeDeCartoes= entrada.nextInt();
			for (int i = 0; i < quantidadeDeCartoes; i++) {
				final String nomeDaSelecao = partidas.get(grupos[numPartida]).get(indicePartida).getSelecao2();
				jogadores.listarJogadores(nomeDaSelecao);
				System.out.println("Digite o codigo do jogador que recebeu o cartao:");
				String codigo = entrada.next();
				System.out.println("[1]Cartao Amarelo\n[2]Cartao Vermelho");
				int cartao = entrada.nextInt();
				if(cartao == 1) {
					System.out.println("Digite a quantidade de cartoes");
					String cartaoAmarelo = entrada.next();
					jogadores.atualizarDadosJogador(codigo, 3, cartaoAmarelo, nomeDaSelecao);
					partidas.get(grupos[numPartida]).get(indicePartida).setGolsSelecao2(Integer.parseInt(cartaoAmarelo));
				}
				else if(cartao == 2) {
					jogadores.atualizarDadosJogador(codigo, 3, "1", codigo);
					partidas.get(grupos[numPartida]).get(indicePartida).setGolsSelecao2(1);
				}
				
			}
			
		}
		partidas.get(grupos[numPartida]).get(indicePartida).setCodigo(geraid());
		partidas.get(grupos[numPartida]).get(indicePartida).setData(data.get(0)+ "/" + data.get(1) + "/" + data.get(2));
		partidas.get(grupos[numPartida]).get(indicePartida).setHorario(data.get(0) + ":" + data.get(1));
		partidas.get(grupos[numPartida]).get(indicePartida).setLocal(estadios[local]);
		partidas.get(grupos[numPartida]).get(indicePartida).setSituacao(true);
		System.out.println("");
		System.out.println("-----------------Partida Gerada-----------------");
		mostrarPartida(grupos[numPartida], indicePartida);
		System.out.println("\nDeseja cadastar outra partida?\n[0]Nao\n[1]Sim");
		opcao = entrada.nextInt();
		} while (opcao != 0);
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
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
					dPartida.setCartoesAmarelosSelecao1(-1*dPartida.getCartoesAmarelosSelecao1());
					dPartida.setCartoesAmarelosSelecao2(-1*dPartida.getCartoesAmarelosSelecao2());
					dPartida.setCartoesVermelhosSelecao1(-1*dPartida.getCartoesVermelhosSelecao1());
					dPartida.setCartoesVermelhosSelecao2(-1*dPartida.getCartoesVermelhosSelecao2());
					dPartida.setGolsSelecao1(-1*dPartida.getGolsSelecao1());
					dPartida.setGolsSelecao2(-1*dPartida.getGolsSelecao2());
					
					
				}
			}
		}
		
	}
	
	private String geraid() {
		LocalDateTime dataagr = LocalDateTime.now();
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
	    String coddate = dataagr.format(formato);
		return coddate;
	}
	

	public void geraPartidas() {
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		for (int i = 0; i < grupos.length; i++) {
			List<String> grupoSelecao = organizaGrupo(grupos[i]);
			List<Partida> partidaGrupo= new ArrayList<Partida>();
			for(int c = 0; c < grupoSelecao.size(); c++) {
				for(int j = c+1; j < (grupoSelecao.size()); j++) {
					String selecao1 = grupoSelecao.get(c);
					String selecao2 = grupoSelecao.get(j);
					Partida jogo = new Partida(selecao1,selecao2);
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
		String[] grupos = {"A","B","C","D","E","F","G"};
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
		String[] grupos = {"A","B","C","D","E","F","G"};

		//String[] grupos = {"A","B"};

		for (int i = 0; i < grupos.length; i++) {
			System.out.printf("Grupo [%s]\n",grupos[i]);
			listarPartida(grupos[i]);
			System.out.println("");
			
		}
		System.out.println("");
	}
	
	
	private void mostrarPartida(String grupo, int indice) {
		final Partida partida = this.partidas.get(grupo).get(indice);
		System.out.printf("|%s X %s|\n",partida.getSelecao1(),partida.getSelecao2());
		System.out.printf("Codigo da Partida: %s\n",partida.getCodigo());
		System.out.printf("Local: %s\n", partida.getLocal());
		System.out.printf("Data: %s\n", partida.getData());
		System.out.printf("Hoaraio: %s\n", partida.getHorario());
		
	}
	
	
	public void listarTodasPartidasCodigo() {
		System.out.println("[Lista de Partidas]");
		String[] grupos = {"A","B","C","D","E","F","G"};
		for (int i = 0; i < grupos.length; i++) {
			System.out.printf("Grupo [%s]\n",grupos[i]);
			listarPartidaCodigo(grupos[i]);
			System.out.println("");
			
		}
		System.out.println("");
	}
	
	
	public void listarPartidaCodigo(String grupo) {
		List<Partida> jogo = partidas.get(grupo);
		for (int i = 0; i < jogo.size(); i++) {
			if(jogo.get(i).isSituacao())
			System.out.printf("[%s] %s X %s\n",jogo.get(i).getCodigo(),jogo.get(i).getSelecao1(),jogo.get(i).getSelecao2());
		}
		System.out.println("");
		
	}
	@Override
	public void deletar() {
		// TODO Auto-generated method stub
		
	}
	
}


