package model;

import java.util.List;

/**
 * Interface com os metodos a serem implementados pela classe <b>TecnicoDaoImpl</b> 
 * @author Mailson
 * @since 2022
 */
public interface TecnicoDAO {

	public Tecnico cadastrarTecnico();
	public void listarTecnico();
	public void apagarTecnico();
	public void editarTecnico();
	public void cadastrarTecnicoSemSelecao();
 
	
}
  