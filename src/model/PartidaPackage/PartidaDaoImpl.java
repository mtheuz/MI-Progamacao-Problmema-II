package model.PartidaPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.SelecaoPackage.Selecao;



public class PartidaDaoImpl implements PartidaDAO{
	public List<Partida> partidas;
	
	public PartidaDaoImpl(){
		this.partidas = new ArrayList<Partida>(); 
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
	
	public Map<String, ArrayList<Partida>> gerarPartidas(Map<String, ArrayList<Selecao>> grupos) {
		
		
		Map< String,ArrayList <Partida> > partidas = new HashMap<String, ArrayList <Partida>>();
	
		partidas.put("A", new ArrayList<Partida>());
		partidas.put("B", new ArrayList<Partida>());
		partidas.put("C", new ArrayList<Partida>());
		partidas.put("D", new ArrayList<Partida>());
		partidas.put("E", new ArrayList<Partida>());
		partidas.put("F", new ArrayList<Partida>());
		partidas.put("G", new ArrayList<Partida>());
		partidas.put("H", new ArrayList<Partida>());
		
		for(String grupo: grupos.keySet())
		{
			ArrayList<Selecao> lista = grupos.get(grupo);
			for(Selecao selecao: lista)
			{
				String selecao1 = selecao.getNome();
				for(Selecao selecaoo: lista)
				{
					String selecao2 = selecaoo.getNome();
					if(existeJogo(selecao1, selecao2, partidas.get(grupo))== false)
					{
						Partida novaPartida = new Partida();
						novaPartida.setSelecao1(selecao1);
						novaPartida.setSelecao1(selecao2);
						partidas.get(grupo).add(novaPartida);
					}
				}
			}
		}
		
		
		return partidas;
	}
	private boolean existeJogo(String selecao1, String selecao2, ArrayList<Partida> listaDePartidas) {
		if(listaDePartidas.size()>0)
		{
			for(Partida partida : listaDePartidas)
			{
				if(!(partida.getSelecao1() == selecao1 || partida.getSelecao1() == selecao2 && partida.getSelecao2() == selecao1 || partida.getSelecao2() == selecao2 ))
				{
					return true;
					
				}
				return false;
			}
		}
		return false;
	}
	
	}


