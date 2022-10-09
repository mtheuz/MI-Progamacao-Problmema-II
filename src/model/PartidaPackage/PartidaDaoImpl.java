package model.PartidaPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class PartidaDaoImpl implements PartidaDAO{
	public List<Partida> partidas;
	
	PartidaDaoImpl(){
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

}
