package model.JogadorPackage;

import java.util.List;
/**
 * Interface com os metodos a serem implementados pela classe <b>JogadorDaoImpl</b> 
 * @author Mailson
 * @sice 2022
 */
public interface JogadorDAO {
	public void cadastrar(String nome, String nomeDaSelecao);
	public boolean deletarJogador(String codigo,String selecaoBusca);
	public boolean inserirJogador(Jogador jogador, String indexnomeSelecao);
	public void listarJogadoresDados(int nomeSelecao);
	public void listarJogadores(String nomeSelecao);
	public void listarPosicoes();
	void imprimirJogador(String codigo);
	void cadastrarUmJogador();
	void editarJogador();

}
