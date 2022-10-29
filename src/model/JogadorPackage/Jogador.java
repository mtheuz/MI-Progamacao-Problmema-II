package model.JogadorPackage;

/**
 * A classe <b> Jogador</b> serve para criar um objeto que será um cadastro de um Jogador da copa do mundo no sistema.
 * @author Mailson
 * @since 2022
 */
public class Jogador {
	/**
	 * Atributo nome do jogador
	 */
	private String nome;
	/**
	 * Atributo codigo do jogador, é um numero inteiro que cada cadatro de jogador possui
	 */
	private String codigo;
	/**
	 * Atributo posição em que joga o jogador na Seleção
	 */
	private String posicao;
	/**
	 * Atributo numero da camisa do jogador
	 */
	private int numeroCamisa;
	/**
	 * Atributo quantidade de gols marcados
	 */
	private int golsMarcados;
	/**
	 * Atributo quantidade de Cartões amarelos que recebeu
	 */
	private int cartoesAmarelos;
	/**
	 * Atributo quantidade de Cartões vermelhos que recebeu
	 */
	private int cartoesVermelhos;

	/**
	 * Construtor padrão da classe <b> Jogador</b>
	 * @param nome
	 * @param posicao
	 */
	public Jogador(String nome) {
		this.nome = nome;
		this.golsMarcados = 0;
		this.cartoesAmarelos = 0;
		this.cartoesVermelhos = 0;
	}
	
	/**
	 * Consulta o nome do Jogador
	 * @return String
	 */
	public String getNome() { 
		return nome;
	}
	/**
	 * Setar o nome do Jogador
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * Consulta o nome do Jogador
	 * @return
	 */
	public String getCode() {
		return codigo;
	}
	/**
	 * Setar codigo do jogador
	 * @param code
	 */
	public void setCode(String code) {
		this.codigo = code;
	}
	/**
	 * Consultar posição do jogador
	 * @return String
	 */
	public String getPosicao() {
		return posicao;
	}
	/**
	 * Setar posição do jogador 
	 * @param posicao
	 */
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	/**
	 * Consultar gols marcados pelo jogador
	 * @return int
	 */
	public int getGolsMarcados() {
		return golsMarcados;
	}
	/**
	 * Setar gols marcados pelo jogador
	 * @param golsMarcados
	 */
	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados += (golsMarcados);
	}
	/**
	 * Consultar cartões Amarelos de um jogador
	 * @return int
	 */
	public int getCartoesAmarelos() {
		return cartoesAmarelos;
	}
	/**
	 * Setar cartões Amarelos para um jogador
	 * @param cartoesAmarelos
	 */
	public void setCartoesAmarelos(int cartoesAmarelos) {
		this.cartoesAmarelos += (cartoesAmarelos);
	}
	/**
	 * Consultar Cartões Vermelhos de um jogador
	 * @return
	 */
	public int getCartoesVermelhos() {
		return cartoesVermelhos;
	}
	/**
	 * Setar cartões vermelhos de um jogador
	 * @param cartoesVermelhos
	 */
	public void setCartoesVermelhos(int cartoesVermelhos) {
		this.cartoesVermelhos += (cartoesVermelhos);
	}
	
	
}

