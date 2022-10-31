package model.SelecaoPackage;

import java.util.List;
import java.util.Map;

import model.PartidaPackage.Partida;
import model.PartidaPackage.PartidaDaoImpl;

import java.util.ArrayList;

/**
 * Interface com os métodos a serem implementados pela classe <b>TecnicoDaoImpl</b> 
 * @author Mailson
 * @since 2022  
 */
public interface SelecaoDAO 
{
	void cadastrarSelecao();
	void editarSelecao(PartidaDaoImpl partidas);
	public void apagarSelecao();
	public void listarSelecao();
	/**
	 * O método cadastrarSeleção é responsável por cadastrar uma nova Seleção no sistema <br></br>
	 * O limite de cadastros é de 32 seleções na copa do mundo
	 * @param map 
	 */
	/**
	 * O método cadastrarSeleção é responsável por cadastrar uma nova Seleção no sistema <br></br>
	 * O limite de cadastros é de 32 seleções na copa do mundo
	 * @param Partida 
	 * @param map 
	 */
	/**
	 * O método editarSeleção é responsável por editar uma Seleção no sistema 
	 * @param partidas 
	 */
	
	
	
	

}
