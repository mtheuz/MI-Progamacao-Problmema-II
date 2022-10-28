package model.PesquisaPackage;

import java.util.List;
import java.util.Map;

import model.PartidaPackage.Partida;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class Pesquisas 
{
	public static void pesquisas()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		System.out.println("Opcoes de Pesquisa: \n "); 
		System.out.println("[1]Por Partida\n[2]Por Selecao\n[3]Por Jogador \n[4]Por Tecnico\n[5]Por Arbitro \n[6]Voltar");
		int escolha = tratamento.validaInt(1,6);
		
		switch(escolha)
		{
		case 1:
			System.out.println("Escolha uma opção:");
			System.out.println("[1]Pesquisa por data [2] Pesquisa por Selecao");
			int opcao = tratamento.validaInt(1,2);
			if(opcao ==1)
			{
				System.out.println("Digite o dia:");
				String dia = tratamento.entradaDateDay();
				System.out.println("Digite o mes:");
				String mes = tratamento.entradaDateMes();
				System.out.println("Digite o ano:");
				int entradaAno = tratamento.validaInt();
				String ano = String.valueOf(entradaAno);
				
				String dataPesquisa = dia+"/"+mes+"/"+ano;
				
				
			}
			if(opcao ==2)
			{
				
			}
			break;
		
		case 2:
			
			break;
			
		case 3:
			
			break;
			
		case 4:
			
			break;
			
		case 5:
			
			break;
		
		
		}
	}
}
