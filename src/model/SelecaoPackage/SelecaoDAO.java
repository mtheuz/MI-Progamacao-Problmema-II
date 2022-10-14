package model.SelecaoPackage;

import java.util.List;
import java.util.ArrayList;

/**
 * Interface com os métodos a serem implementados pela classe <b>TecnicoDaoImpl</b> 
 * @author Mailson
 * @since 2022  
 */
public interface SelecaoDAO 
{
	public void cadastrarSelecao(ArrayList<Selecao> lista);
	public void editarSelecao();
	public void apagarSelecao();
	public void listarSelecao();
	

}
