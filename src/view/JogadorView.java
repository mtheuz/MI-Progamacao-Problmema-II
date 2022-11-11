package view;

import java.util.Scanner;

import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class JogadorView {

	public int menuOpcoes()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Opcoes para Jogador:");
		System.out.println("[1]Cadastrar \n[2]Editar \n[3]Excluir \n[4]Listar \n[5]Voltar");
		
	
		int opcao = tratamento.validaInt(1, 5);
		return opcao;
	}
	public void mostrar(String str)
	{
		System.out.println(str);
	}
	public int deletarJogadorEscolheIndice(int tam)
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite o indice da selecao que deseja excluir um jogador");
		int indiceSelecao = tratamento.validaInt(0,tam);
		return indiceSelecao;
	}

	public String deletarJogadorEscolheCodigo() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite o Codigo do jogador: ");
		String codigo = tratamento.EntradaString();
		return codigo;
	}
	public int listarJogadorEscolheIndice(int tam)
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite o indice da selecao que deseja listar os jogadores");
		int indiceSelecao = tratamento.validaInt(0, tam);
		return indiceSelecao;
	}

}
