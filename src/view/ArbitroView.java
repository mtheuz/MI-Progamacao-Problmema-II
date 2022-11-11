package view;

import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

/**
 * A classe <b> ArbitroView </b> mostra as informações e colhe as entradas referentes as opções de arbitro no programa
 * @author Mailson
 *
 */
public class ArbitroView {

	/**
	 * O método MenuOpcoes mostra as informações e colhe as entradas do usuário no menu principal das pesquisas
	 * @return int
	 */
	public int menuOpcoes()
	{
		
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Opcoes para Arbitro:");/*Lista de opções para esse menu*/
		System.out.println("[1]Cadastrar Arbitro\n[2]Editar\n[3]Excluir\n[4]Listar\n[5]Voltar\n");
		int opcao = tratamento.validaInt(1,5); /*Váriavel para guardar a escolha da entrada*/ 
		return opcao;
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
	public int inputInt(int min, int max)
	{ 
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		int entrada = tratamento.validaInt(min,max);
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
