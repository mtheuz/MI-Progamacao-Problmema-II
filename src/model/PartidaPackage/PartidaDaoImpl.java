package model.PartidaPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.SelecaoPackage.Selecao;
import model.SelecaoPackage.SelecaoDaoImpl;



public class PartidaDaoImpl implements PartidaDAO{
	SelecaoDaoImpl selecao = new SelecaoDaoImpl();
	public PartidaDaoImpl(ArrayList<Selecao> selecoes){
		selecao.setListaSelecoes(selecoes);
	}
	@Override
	public void inserir() {
		// TODO Auto-generated method stub
		
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
	
	public void adicionarPartida(String grupo) {
		List<String> grupoSelecao = new ArrayList<>();
		List<String> partidas = new ArrayList<>();
		Scanner entrada = new Scanner(System.in);
		grupoSelecao.add("Brasil");
		grupoSelecao.add("Argentina");
		grupoSelecao.add("Colombia");
		grupoSelecao.add("Franca");
		/*for(Selecao selecao: selecao.getListaSelecoes()) {
			if(selecao.getGrupo().equals(grupo)) {
				grupoSelecao.add(selecao.getNome());
			}
		}*/
		int cont = 0;
		for(int i = 0; i < grupoSelecao.size(); i++) {
			for(int j = i+1; j < (grupoSelecao.size()); j++) {
				String selecao1 = grupoSelecao.get(i);
				String selecao2 = grupoSelecao.get(j);
				System.out.printf("[%d] %s X %s\n",cont,selecao1,selecao2);
				cont++;
				partidas.add(grupoSelecao.get(i)+"X"+grupoSelecao.get(j) );
				
			}
		}
		
		int index = entrada.nextInt();
		System.out.println("Digite a partida que deseja inserir");
		String[] valores = partidas.get(index).split("X");
		System.out.println(valores[0]);
		
	}

}
