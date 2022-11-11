package view;

import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

/**
 * A classe <b> PesquisasView </b> mostra as informações e colhe as entradas referentes as opções de pesquisa no programa
 * @author Mailson
 *
 */
public class PesquisasView {
	/**
	 * O método MenuOpcoes mostra as informações e colhe as entradas do usuário no menu principal das pesquisas
	 * @return int
	 */
	public int menuOpcoes()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		System.out.println("Opcoes de Pesquisa: \n "); 
		System.out.println("[1]Por Partida\n[2]Por Jogador\n[3]Voltar");
		int escolha = tratamento.validaInt(1,3);
		return escolha;
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
	/**
	 * O método inputData colhe as entradas de data e devolve formatada em String
	 * @return String
	 */
	public String inputData()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite o dia:"); 
		String dia = tratamento.entradaDateDay();
		System.out.println("Digite o mes:");
		String mes = tratamento.entradaDateMes();
		System.out.println("Digite o ano:");
		int entradaAno = tratamento.validaInt();
		String ano = String.valueOf(entradaAno);
		
		String dataPesquisa = dia+"/"+mes+"/"+ano;
		return dataPesquisa;
	}
}
