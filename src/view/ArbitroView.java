package view;

import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class ArbitroView {

	public int menuOpcoes()
	{
		
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Opcoes para Arbitro:");/*Lista de opções para esse menu*/
		System.out.println("[1]Cadastrar Arbitro\n[2]Editar\n[3]Excluir\n[4]Listar\n[5]Voltar\n");
		int opcao = tratamento.validaInt(1,5); /*Váriavel para guardar a escolha da entrada*/
		return opcao;
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
}
