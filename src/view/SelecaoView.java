package view;

import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class SelecaoView {
 
	public int menuOpcoes()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Opcoes para Selecao:");
		System.out.println("[1]Completar cadastro de Selecao\n[2]Listar Selecoes\n[3]Editar Selecao\n[4]Voltar");
		int opcao = tratamento.validaInt(1, 4);
		return opcao;
	}

	public String cadastrarSelecao() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite o nome da Selecao que deseja completar o cadastro:");
		
		String nome = tratamento.EntradaString(); 
		return nome;
	}
	public void mostrar(String str)
	{
		System.out.println(str); 
	}
	public int inputInt()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		int entrada = tratamento.validaInt(1,2);
		return entrada; 
	}
	public String inputStr()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		String entrada = tratamento.EntradaString();
		return entrada; 	
	}
}
