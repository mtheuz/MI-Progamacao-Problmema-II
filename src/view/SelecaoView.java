package view;

import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

/**
 * A classe <b> SelecaoView </b> mostra as informações e colhe as entradas referentes as opções de Seleção no programa
 * @author Mailson
 *
 */
public class SelecaoView { 
 
	/**
	 * O método MenuOpcoes mostra as informações e colhe as entradas do usuário no menu principal de Seleções
	 * @return int
	 */
	public int menuOpcoes()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Opcoes para Selecao:");
		System.out.println("[1]Completar cadastro de Selecao\n[2]Listar Selecoes\n[3]Editar Selecao\n[4]Voltar");
		int opcao = tratamento.validaInt(1, 4);
		return opcao;
	}
	/**
	 * o método cadastrarSelecao colhe o nome da Seleção a ser cadastrada na view
	 * @return String
	 */
	public String cadastrarSelecao() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite o nome da Selecao que deseja completar o cadastro:");
		
		String nome = tratamento.EntradaString(); 
		return nome;
	}
	/**
	 * O método mostrar mostra alguma String que é passada para view
	 * @param str
	 */
	public void mostrar(String str)
	{
		System.out.println(str); 
	}
	/**
	 * O método inputInt colhe a entrada de um inteiro e o devolve para o model ou controller
	 * @param min
	 * @param max
	 * @return int
	 */
	public int inputInt()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		int entrada = tratamento.validaInt(1,2);
		return entrada; 
	}
	/**
	 * O método inputString colhe a entrada de uma String e a devolve para o model ou controller
	 * @return String
	 */
	public String inputStr()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		String entrada = tratamento.EntradaString();
		return entrada; 	
	}
}
