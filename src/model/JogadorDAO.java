package model;

import java.util.List;
/**
 * Interface com os metodos a serem implementados pela classe <b>JogadorDaoImpl</b> 
 * @author Mailson
 * @sice 2022
 */
public interface JogadorDAO {
	public void cadastrar();
	public boolean deletarJogador(String codigo,String selecaoBusca);
	public boolean atualizarDadosJogador(String codigo, int opcaco,String alteração,String nomeSelecao);
	public boolean inserirJogador(Jogador jogador, String indexnomeSelecao);
	public void listarJogadoresDados(String nomeSelecao);
	public void listarJogadores(String nomeSelecao);
	public void listarPosicoes();
	void imprimirJogador(String codigo);

}
