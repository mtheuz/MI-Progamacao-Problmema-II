package model.PartidaPackage;

public interface PartidaDAO {
	
	public void listar();
	public boolean deletar(String codigo);
	boolean inserir(String dia, String mes, String ano, String hora, String minuto, String local, Partida partida);


}
