package view;

import java.util.Scanner;

import model.PartidaPackage.PartidaDaoImpl;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class PartidaView {

	public int menuOpcoes()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Opcoes para Partida:");
		System.out.println("[1]Cadastrar\n[2]Editar\n[3]Listar por Grupo\n[4]Cancelar Partida\n[5]Voltar\n");
		int opcao = tratamento.validaInt(1, 4);
		return opcao;
	}
	public void mostrar(String str)
	{
		System.out.println(str);
	}
	public String editarPartidaEscolheGrupo()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o grupo: ");
		String grupo = tratamento.EntradaString();
		return grupo;
		
	}
	
	public String editarPartidaEscolheCodigo() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o codigo da partida que deseja editar");
		String codigo = tratamento.EntradaString();
		return codigo;
	}
	public String cancelarPartidaEscolheGrupo()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		
		System.out.println("Informe o grupo: ");
		String grupo = tratamento.EntradaString();
		return grupo;
	}
	public String cancelarPartidaEscolheCodigo() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o codigo da partida que deseja resetar");
		String codigo = tratamento.EntradaString();
		return codigo;
	}
}
