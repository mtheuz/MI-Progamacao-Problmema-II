package model.PesquisaPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.JogadorPackage.Jogador;
import model.JogadorPackage.JogadorDaoImpl;
import model.PartidaPackage.Partida;
import model.PartidaPackage.PartidaDaoImpl;
import model.SelecaoPackage.Selecao;
import model.SelecaoPackage.SelecaoDaoImpl;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class Pesquisas 
{
	public static void pesquisas(Map<String,List<Partida>> partidas, ArrayList<Selecao> listaSelecoes, PartidaDaoImpl partidass, JogadorDaoImpl jogador)
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		
		System.out.println("Opcoes de Pesquisa: \n "); 
		System.out.println("[1]Por Partida\n[2]Por Jogador\n[3]Voltar");
		int escolha = tratamento.validaInt(1,3);
		
		switch(escolha)
		{
		case 1:
			System.out.println("Escolha uma opcao:");
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
				
				if(!procuraPartidas(dataPesquisa, partidas, partidass))
				
						System.out.println("Nemhuma partida com essa foi encontrada");
						
				break;
			}
			if(opcao ==2)
			{
				if(listaSelecoes.size()>0)
				{
					System.out.println();
					System.out.println("Lista de Selecoes:");
					//Percorrendo a lista de cadastros
					for(int i=0; i< listaSelecoes.size(); i++)
					{
						System.out.println("["+(i)+"]"+((Selecao) listaSelecoes.get(i)).getNome()); // Imprimindo o nome da Seleção
					}
					System.out.println();
					
				}
				else
					System.out.println("Ainda nao foram cadastradas Selecoes no sistema");
					
				
				
			System.out.println("Digite o indice da Selecao que deseja exibir as partidas:");
			int escolhaSelecao = tratamento.validaInt(1, listaSelecoes.size());
			String nomeselecao = listaSelecoes.get(escolhaSelecao).getNome();
			
			for(Entry<String, List<Partida>> grupo : partidas.entrySet())
			{
				for(Partida partida : grupo.getValue())
				{
					if(partida.getSelecao1().equals(nomeselecao) || partida.getSelecao2().equals(nomeselecao))
					{
					
						partidass.mostrarPartida(partida.getCodigo());
					}
				}
			}
			break;
		}
		case 2:
			System.out.println("Digite um nome para pesquisar registros no sistema:");
			String nomeJogador= tratamento.EntradaString();
			if(!listaJogadoresPorNome(listaSelecoes,nomeJogador, jogador))
				System.out.println("Nemhum jogador com esse nome foi encontrado!");
			
			break;
			
		case 3:
			
			break;
		
		
		
		}
	}

	private static boolean procuraPartidas(String dataPesquisa, Map<String, List<Partida>> partidas, PartidaDaoImpl partidass) {
		int aux =0;
		for(Entry<String, List<Partida>> grupo : partidas.entrySet())
		{
			for(Partida partida : grupo.getValue())
			{
				
				if(partida.getData().equals(dataPesquisa))
				{
					
					((PartidaDaoImpl) partidass).mostrarPartida( partida.getCodigo());
					aux++;
				}
			
			}
		}
		if(aux>0)
			return true;
		return false;
			
	}

	private static boolean listaJogadoresPorNome(ArrayList<Selecao> listaSelecoes, String nomeJogador, JogadorDaoImpl jogador) {
		int aux=0;
		for(Selecao selecao: listaSelecoes)
			for(Jogador jogadorr: selecao.getListaJogadores())
			{
				if(jogadorr.getNome().equals(nomeJogador))
				{
					jogador.imprimirJogador(jogadorr.getCode());
					aux =1;
				}
			}
		if(aux ==1 )
			return true;
		else
			return false;
	}
}
