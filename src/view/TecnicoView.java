package view;

import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class TecnicoView {

	public int menuOpcoes()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Opcoes para Tecnico:"); /*Lista de opções para esse menu*/
		System.out.println(" [1]Cadastrar Tecnico\n [2]Editar\n [3]Excluir\n [4]Listar\n [5]Voltar\n");
		int opcao = tratamento.validaInt(1,5);/*Váriavel para guardar a escolha da entrada*/
		return opcao;
		
	}
}