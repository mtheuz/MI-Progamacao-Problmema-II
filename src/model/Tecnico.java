package model;

/**
 * A classe <b> Tecnico </b> serve para criar um objeto que será um cadastro de um Técnico de uma Seleção da copa do mundo no sistema.
 * @author Mailson
 *
 */
public class Tecnico {
	/**
	 * Atributo nome do Técnico
	 */
	private String nome;
	/**
	 *  Atributo nacionalidade do Técnico
	 */
	private String nacionalidade;
	/**
	 * Construtor padrão da classe <b> Arbitro </b>
	 */
	
	public Tecnico() {
		this.nome ="Sem Tecnico";
	}

	/**
	 * Consultar o nome do Técnico
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Setar o nome do Técnico
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Consultar nacionalidade
	 * @param nacionalidade
	 * @return
	 */
	public String getNacionalidade(String nacionalidade) {
		return nacionalidade;
	}
	/**
	 * Setar nacionalidade
	 * @param nacionalidade
	 */
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
}
