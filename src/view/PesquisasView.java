package view;

import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class PesquisasView {

	public int menuOpcoes()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		System.out.println("Opcoes de Pesquisa: \n "); 
		System.out.println("[1]Por Partida\n[2]Por Jogador\n[3]Voltar");
		int escolha = tratamento.validaInt(1,3);
		return escolha;
	}
	public void mostrar(String str)
	{
		System.out.println(str); 
	}
	public int inputInt(int min, int max)
	{ 
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		int entrada = tratamento.validaInt(min,max);
		return entrada; 
	}
	public String inputStr()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		String entrada = tratamento.EntradaString();
		return entrada; 	
	}
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
