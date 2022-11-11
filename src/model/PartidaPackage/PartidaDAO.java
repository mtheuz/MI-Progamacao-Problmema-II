package model.PartidaPackage;

public interface PartidaDAO {
	public boolean deletar(String codigo);
	public boolean inserir(String dia, String mes, String ano, String hora, String minuto, String local, Partida partida);
	public void listarPartida(String grupo);
	public void atualizarData(Partida partida, String dia, String mes, String ano);
	public void atualizarHora(Partida partida, String hora, String minuto);
	public void atualizarLocal(Partida partida, int local);


}
