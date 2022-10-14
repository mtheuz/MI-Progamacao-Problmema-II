package model.PartidaPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.SelecaoPackage.Selecao;
import java.util.Scanner;
import model.JogadorPackage.JogadorDaoImpl;
import model.SelecaoPackage.SelecaoDaoImpl;




public class PartidaDaoImpl implements PartidaDAO{
	SelecaoDaoImpl selecao = new SelecaoDaoImpl();
	JogadorDaoImpl jogadores = new JogadorDaoImpl(selecao.getListaSelecoes());
	Map<String,List<Partida>> partidas = new HashMap<String,List<Partida>>();
	String[] estadios = {"Al Bayt", "Khalifa International", "Al Thumama", "Ahmad Bin Ali",
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
		listarPartida(grupos[numPartida]);
		System.out.println("Digite o indice da partida que deseja inserir");
		int indicePartida = entrada.nextInt();
		//Partida
		//Falta inserir os dados
		
		String[] dataformat = {"Dia","Mês","Ano"};
		List<String> data = new ArrayList<String>();
		for (int i = 0; i < dataformat.length; i++) {
			System.out.printf("Digite o %s",dataformat[i]);
			String entradaData = entrada.next();
			data.add(entradaData);
			
		}
		List<String> hora = new ArrayList<String>();
		String[] horaformat = {"Hora","Minuto"};
		for (int i = 0; i < horaformat.length; i++) {
			System.out.printf("Digite o(a) %s",horaformat[i]);
			String entradaData = entrada.next();
			hora.add(entradaData);
			
		}
		
		System.out.println("Digite o local da partida.");
		for (int i = 0; i < estadios.length; i++) {
			System.out.printf("[%d]%s",i,estadios[i]);
		}
		int local = entrada.nextInt();
		
		System.out.printf("A seleção %s fez gol?\n[0]Não\n[1]Sim",partidas.get(grupos[numPartida]).get(indicePartida).getSelecao1());
		int respGols = entrada.nextInt();
		if(respGols == 1) {
			
		}
		
		partidas.get(grupos[numPartida]).get(indicePartida).setCodigo(geraid());
		partidas.get(grupos[numPartida]).get(indicePartida).setData(data.get(1)+ "/" + data.get(2) + "/" + data.get(3));
		partidas.get(grupos[numPartida]).get(indicePartida).setHorario(data.get(1) + ":" + data.get(2));
		partidas.get(grupos[numPartida]).get(indicePartida).setLocal(estadios[local]);
		
		
		
		
		
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar() {
		// TODO Auto-generated method stub
		
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
			for(i = 0; i < grupoSelecao.size(); i++) {
				for(int j = i+1; j < (grupoSelecao.size()); j++) {
					String selecao1 = grupoSelecao.get(i);
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
	
	private void imprimeGrupos(){
		String[] grupos = {"A","B","C","D","E","F","G"};
		for (int i = 0; i < grupos.length; i++) {
			System.out.printf("[%d]Grupo %s",i,grupos[i]);
			for(Selecao selecao: selecao.getListaSelecoes()) {
				if(selecao.getGrupo().equals(grupos[i])) {
					System.out.printf("%s",selecao.getNome());
				}
			
			}
		}
	}
	
	public void listarPartida(String grupo) {
		List<Partida> jogo = partidas.get(grupo);
		for (int i = 0; i < jogo.size(); i++) {
			System.out.printf("[%d] %s X %s\n",i,jogo.get(i).getSelecao1(),jogo.get(i).getSelecao2());
		}
		
	}
	
	public void listarTodasPartidas(Map<String,List<Partida>> patidas) {
		String[] grupos = {"A","B","C","D","E","F","G"};
		for (int i = 0; i < grupos.length; i++) {
			System.out.printf("Grupo [%s]\n",grupos[i]);
			listarPartida(grupos[i]);
			System.out.println("");
			
		}
	}
}


