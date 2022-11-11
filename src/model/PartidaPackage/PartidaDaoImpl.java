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
import view.PartidaView;

public class PartidaDaoImpl implements PartidaDAO{
	PartidaView partidaView = new PartidaView();
	private SelecaoDaoImpl selecao = new SelecaoDaoImpl();
	TratamentosExcecoes tratamento = new TratamentosExcecoes();
	
	private Map<String,List<Partida>> partidas = new HashMap<String,List<Partida>>();
	
	private String[] estadios = {"Al Bayt", "Khalifa International", "Al Thumama", "Ahmad Bin Ali",
			"Lusail", "Ras Abu Aboud (974)", "Education City", "Al Janoub"};
	
	public String[] getEstadios() {
		return estadios;
	}
	public Map<String,List<Partida>> getPartidas() {
		return partidas; 
	}
	public PartidaDaoImpl(ArrayList<Selecao> selecoes){
		selecao.setListaSelecoes(selecoes);  
	}
	private JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());

	public boolean inputGolsSelecao1(Partida partida, String gols, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		if(jogadores.verificaExistencia(codigo)) {
			List<String> gols1 = new ArrayList<String>();
			gols1.add(codigo);
			gols1.add(gols);
			jogadores.atualizarGolsMarcados(codigo, partida.getSelecao1(), gols);
			partida.setGolsSelecao1(gols1);
			return true;
		}else {
			System.err.println("Jogador nao Cadastrado");
			return false;
		}
	}
	public boolean inputGolsSelecao2(Partida partida, String gols, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		if(jogadores.verificaExistencia(codigo)) {
			List<String> gols2 = new ArrayList<String>();
			gols2.add(codigo);
			gols2.add(gols);
			jogadores.atualizarGolsMarcados(codigo, partida.getSelecao2(), gols);
			partida.setGolsSelecao2(gols2);
			return true;

		}else {
			System.err.println("Jogador nao Cadastrado");
			return false;
		}
	}
	
	public boolean inputCartosAmarelosSelecao1(Partida partida, String cartaoAmarelo, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		List<String> cartoesAmarelos = new ArrayList<String>();
		cartoesAmarelos.add(codigo);
		cartoesAmarelos.add(cartaoAmarelo);
		if(jogadores.verificaExistencia(codigo)) {
			jogadores.atulizarCartoesAmarelos(codigo, partida.getSelecao1(), cartaoAmarelo);
			partida.setCartoesAmarelosSelecao1(cartoesAmarelos);
			return true;
		}
		else {
			return false;
		}

	}
	public boolean inputCartosVermelhoSelecao1(Partida partida, String cartaoVermelho, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		List<String> cartoesVermelhos = new ArrayList<String>();
		cartoesVermelhos.add(codigo);
		cartoesVermelhos.add(cartaoVermelho);
		if(jogadores.verificaExistencia(codigo)) {
			jogadores.atualizarCartoesVermelhos(codigo, partida.getSelecao1(), cartaoVermelho);
			partida.setCartoesVermelhosSelecao1(cartoesVermelhos);
			return true;
		}
		else {
			return false;
		}

	}
	
	public boolean inputCartosAmarelosSelecao2(Partida partida, String cartaoAmarelo, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		List<String> cartoesAmarelos = new ArrayList<String>();
		cartoesAmarelos.add(codigo);
		cartoesAmarelos.add(cartaoAmarelo);
		if(jogadores.verificaExistencia(codigo)) {
			jogadores.atulizarCartoesAmarelos(codigo, partida.getSelecao2(), cartaoAmarelo);
			partida.setCartoesAmarelosSelecao2(cartoesAmarelos);
			mostrarPartida(codigo);
			return true;
		}
		else {
			return false;
		}

	}

	public boolean inputCartosVermelhoSelecao2(Partida partida, String cartaoVermelho, String codigo) {
		JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
		List<String> cartoesVermelhos = new ArrayList<String>();
		cartoesVermelhos.add(codigo);
		cartoesVermelhos.add(cartaoVermelho);
		if(jogadores.verificaExistencia(codigo)) {
			jogadores.atualizarCartoesVermelhos(codigo, partida.getSelecao2(), cartaoVermelho);
			partida.setCartoesVermelhosSelecao2(cartoesVermelhos);
			mostrarPartida(codigo);
			return true;
		}
		else {
			return false;
		}

	}

	public void listarLocal() {
		System.out.println("[Digite o local da partida]");
		for (int i = 0; i < estadios.length; i++) {
			System.out.printf("[%d]%s\n",i,estadios[i]);
		}
	}
	
	@Override
	public boolean inserir(String dia, String mes, String ano, String hora, String minuto, String local, Partida partida) {
		if(verificaCadastroCompleto(partida.getSelecao1()) && verificaCadastroCompleto(partida.getSelecao2()))
		{	
			String data = dia + "/" + mes + "/" + ano;
			String horap = hora + ":" + minuto;
			partida.setData(data);
			partida.setHorario(horap);
			partida.setLocal(local);
			partida.setSituacao(true);
			return true;
		}
		else {
			return false;
			}
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
	public boolean deletar(String codigo) {
		final Partida partida = findPartida(codigo);
		if(partida != null) {
			partida.setData("");
			partida.setData("");
			partida.setHorario("");
			partida.setLocal("");
			partida.setSituacao(false);
			resetaListasPartida(partida.getCartoesAmarelosSelecao1());
			resetaListasPartida(partida.getCartoesAmarelosSelecao2());
			resetaListasPartida(partida.getCartoesVermelhosSelecao1());
			resetaListasPartida(partida.getCartoesVermelhosSelecao2());
			resetaListasPartida(partida.getGolsSelecao1());
			resetaListasPartida(partida.getGolsSelecao2());
			mostrarPartida(codigo);
			return true;
		}
		return false;
	}
	
	public String geraid() throws InterruptedException {
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
			if(grupoSelecao.isEmpty() || grupoSelecao.size()<=4) {
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

	public boolean imprimeGrupos(){

		System.out.println("[Lista de Grupos]");
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		if(!selecao.getListaSelecoes().isEmpty()) {
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
			return true;
		}
		return false;
	}
	public void listarPartida(String grupo) {
		List<Partida> jogo = partidas.get(grupo);
		for (int i = 0; i < jogo.size(); i++) {
			if(!jogo.get(i).isSituacao())
				System.out.printf("[%d] %s X %s\n",i,jogo.get(i).getSelecao1(),jogo.get(i).getSelecao2());
		}
		System.out.println("");

	}
	
	public boolean listarTodasPartidas() {
		System.out.println("[Lista de Partidas]");
		String[] grupos = {"A","B","C","D","E","F","G","H"};
		if(!partidas.isEmpty()) {
		for (int i = 0; i < grupos.length; i++) {
			System.out.printf("Grupo [%s]\n",grupos[i]);
			listarPartida(grupos[i]);
			System.out.println("");

		}
		System.out.println("");
		return true;
		}
		return false;
	}
	
	public int somaGols(List<List<String>> listaGols) {
		int gols = 0;
		if(!listaGols.isEmpty()) {
			for(List<String> jogador: listaGols) {
				gols += Integer.parseInt(jogador.get(1));
			}
			return gols;
		}
		return 0;
	}
	public boolean mostrarPartida(String codigo) {
		final Partida partida = findPartida(codigo);
		if(partida != null) {
			System.out.printf("Codigo da Partida: %s\n",partida.getCodigo());
			System.out.printf("|%s X %s|\n",partida.getSelecao1(),partida.getSelecao2());
			System.out.printf("Placar: [%d X %d]\n",somaGols(partida.getGolsSelecao1()),somaGols(partida.getGolsSelecao2()));
			System.out.printf("Local: %s\n", partida.getLocal());
			System.out.printf("Data: %s\n", partida.getData());
			System.out.printf("Horaio: %s\n", partida.getHorario());
			System.out.println("\n");


			if(partida.getGolsSelecao1().size()>0)
				System.out.printf("Gols [%s] \n",partida.getSelecao1());
			for(List<String> jogador: partida.getGolsSelecao1()) {
				if(jogador.size()> 0 && Integer.parseInt(jogador.get(1))>0) {
					System.out.printf("%s - [%s] Gols\n",jogadores.retornaJogadorNome(jogador.get(0),selecao.getListaSelecoes()),jogador.get(1));
				}	
			}

			if(partida.getGolsSelecao2().size()>0)
				System.out.printf("Gols [%s] \n",partida.getSelecao2());
			for(List<String> jogador: partida.getGolsSelecao2()) {
				if(jogador.size()> 0 && Integer.parseInt(jogador.get(1))>0) {
					System.out.printf("%s - [%s] Gols\n",jogadores.retornaJogadorNome(jogador.get(0),selecao.getListaSelecoes()),jogador.get(1));
				}	
			}

			System.out.printf("Cartoes Amarelos [%s]:\n", partida.getSelecao1());
			if(partida.getCartoesAmarelosSelecao1().size()>0) {
				for(List<String> jogador: partida.getCartoesAmarelosSelecao1()) {
					if(jogador.size()> 0 && Integer.parseInt(jogador.get(1))>0) {
						System.out.printf("%s - [%s] Cartao amarelo\n",jogadores.retornaJogadorNome(jogador.get(0),selecao.getListaSelecoes()),jogador.get(1));
					}	
				}
			}else {
				System.out.printf("0\n");
			}

			System.out.printf("Cartoes Amarelos [%s]:\n", partida.getSelecao2());
			if(partida.getCartoesAmarelosSelecao2().size()>0) {
				for(List<String> jogador: partida.getCartoesAmarelosSelecao2()) {
					if(jogador.size()> 0 && Integer.parseInt(jogador.get(1))>0) {
						System.out.printf("%s - [%s] Cartao Amarelo\n",jogadores.retornaJogadorNome(jogador.get(0),selecao.getListaSelecoes()),jogador.get(1));
					}
				}
			}else {
				System.out.printf("0\n");
			}

			System.out.printf("Cartoes Vermelhos [%s]:\n", partida.getSelecao1());
			if(partida.getCartoesVermelhosSelecao1().size()>0) {
				for(List<String> jogador: partida.getCartoesVermelhosSelecao1()) {
					if(jogador.size()> 0 && Integer.parseInt(jogador.get(1))>0) {
						System.out.printf("%s - [%s] Cartao Vermelho\n",jogadores.retornaJogadorNome(jogador.get(0),selecao.getListaSelecoes()),jogador.get(1));
					}
				}
			}else {
				System.out.printf("0\n");
			}


			System.out.printf("Cartoes Vermelhos [%s]:\n", partida.getSelecao2());
			if(partida.getCartoesVermelhosSelecao2().size()>0) {
				for(List<String> jogador: partida.getCartoesVermelhosSelecao2()) {
					if(jogador.size()> 0) {
						System.out.printf("%s - [%s] Cartao Vermelho\n",jogadores.retornaJogadorNome(jogador.get(0),selecao.getListaSelecoes()),jogador.get(1));
					}
				}
			}else{
				System.out.printf("0\n");
				return true;
			}

			System.out.println("---------------------------------------\n");
		}
		return false;
	}

	public boolean listarPartidaCodigoJogados(String grupo) {
		List<Partida> jogo = partidas.get(grupo);
		String selecao1 = "";
		String selecao2 = "";
		int controle = 0;
		for (int i = 0; i < jogo.size(); i++) {
			if(jogo.get(i).isSituacao()) {
				selecao1 = jogo.get(i).getSelecao1();
				selecao2 = jogo.get(i).getSelecao2();
				System.out.printf("[%s] %s X %s\n",jogo.get(i).getCodigo(),jogo.get(i).getSelecao1(),jogo.get(i).getSelecao2());
				controle = 1;
			}
		}
		if(controle == 0) {
			System.out.println("Nenhuma partida foi realizada!");
			return false;
		}
		System.out.println("\n");
		return true;
	}
	

	public boolean listarPartidaCodigoNaoJogadas(String grupo) {
		List<Partida> jogo = partidas.get(grupo);
		String selecao1 = "";
		String selecao2 = "";
		int controle = 0;
		for (int i = 0; i < jogo.size(); i++) {
			if(jogo.get(i).isSituacao() == false) {
				selecao1 = jogo.get(i).getSelecao1();
				selecao2 = jogo.get(i).getSelecao2();
				System.out.printf("[%s] %s X %s\n",jogo.get(i).getCodigo(),jogo.get(i).getSelecao1(),jogo.get(i).getSelecao2());
				controle = 1;
			}
		}
		if(controle == 0) {
			System.out.println("Todas partidas ja forma realizadas");
			return false;
		}
		System.out.println("\n");
		return true;

	}
	
	private void resetaListasPartida(List<List<String>> lista) {
		for(List<String> jogador: lista) {
			jogador.set(1, "0");
		}
	}

	public Partida findPartida(String codigo) {
		Partida dPartida = null;
		for (Map.Entry<String, List<Partida>> partida : partidas.entrySet()) {
			for (int i = 0; i < partida.getValue().size(); i++) {
				if(partida.getValue().get(i).getCodigo().equals(codigo)) {
					dPartida = partida.getValue().get(i);
					;
				}
			}
		}
		return dPartida;
	}
	
	public void atualizarData(Partida partida, String dia, String mes, String ano) {
		partida.setData(dia + "/" + mes + "/" + ano);
		//mostrarPartida(codigo);
	}

	public void atualizarHora(Partida partida, String hora, String minuto) {
		partida.setHorario(hora + ":" + minuto);
		//mostrarPartida(codigo);
	}

	public void atualizarLocal(Partida partida, int local) {
		partida.setLocal(estadios[local]);
		//mostrarPartida(codigo);
	}

	public boolean listarJogadoresCartoes(List<List<String>> jogadoresList) {
		if(jogadoresList.size() > 0) {
			for (int j = 0; j < jogadoresList.size(); j++) {
				List<String> jogador = jogadoresList.get(j);
				System.out.printf("[%d] %s - %s\n",j,jogadores.retornaJogadorNome(jogador.get(0),selecao.getListaSelecoes()),jogador.get(1));

			}
		}
		else {
			partidaView.mostrar("Nao foi cadastrado!");
			return false;
		}
		return true;
	}

	public boolean adicionarCartaoAmarelo(int cartao, List<String> jogador) {
		int valorCartao = Integer.parseInt(jogador.get(1));
		if(valorCartao < 2 && (cartao <= 2 && cartao >0)) {
			int soma = cartao + valorCartao;
			String conversao = Integer.toString(soma);
			jogador.set(1, conversao);
			return true;
			//mostrarPartida(codigo);
		}else {
			System.err.println("Nao e possivel adicionar mais cartao, limite por partida atingido");
			return false;
		}
	}

	public boolean retirarCartaoAmarelo(int cartao, List<String> jogador) {
		int valorCartao = Integer.parseInt(jogador.get(1));
		if(valorCartao > 0 && (cartao <= valorCartao) && valorCartao >= cartao) {
			int soma = valorCartao - cartao;
			String conversao = Integer.toString(soma);
			jogador.set(1, conversao);
			return true;
			//mostrarPartida(codigo);
		}else {
			System.err.println("Nao e possivel adicionar mais cartao, limite por partida atingido");
			return false;
		}
	}

	public boolean adicionarCartaoVemelho( List<String> jogador) {
		int valorCartao = Integer.parseInt(jogador.get(1));
		if(valorCartao == 0) {
			jogador.set(1, "1");
			return true;
		}else {
			System.err.println("Nao e possivel adicionar mais carteo, limite por partida atingido");
			return false;
		}
	}

	public boolean retirarCartaoVemelho( List<String> jogador) {
		int valorCartao = Integer.parseInt(jogador.get(1));
		if(valorCartao == 1) {
			jogador.set(1, "0");
			return true;

		}else {
			System.err.println("Nao e possivel retirar cartao!");
			return false;
		}

	}
	
	public boolean adicionarGols(int gol,List<String> jogador) {
		int valorGol = Integer.parseInt(jogador.get(1));
		int soma = gol + valorGol;
		String conversao = Integer.toString(soma);
		jogador.set(1, conversao);
		return true;
		//mostrarPartida(codigo);
	}
	
	public boolean retirarGols(int gol,List<String> jogador) {
		int valorGol = Integer.parseInt(jogador.get(1));
		if(valorGol > 0 && (gol <= valorGol)) {
			int soma = valorGol - gol;
			String conversao = Integer.toString(soma);
			jogador.set(1, conversao);
			return true;
			//mostrarPartida(codigo);
			}else {
				System.err.println("Nao e possivel retirar gols");
				return false;
			}
	}
	
}


