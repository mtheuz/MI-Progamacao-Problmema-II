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
import view.PesquisasView;

public class Pesquisas 
{
	public static void pesquisas(Map<String,List<Partida>> partidas, ArrayList<Selecao> listaSelecoes, PartidaDaoImpl partidass, JogadorDaoImpl jogador)
	{
		PesquisasView pesquisasView = new PesquisasView();
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		int escolha = pesquisasView.menuOpcoes();
		
		switch(escolha)
		{
		case 1:
			pesquisasView.mostrar("Escolha uma opcao:");
			pesquisasView.mostrar("[1]Pesquisa por data [2] Pesquisa por Selecao");
			int opcao = pesquisasView.inputInt(1, 2);
			if(opcao ==1)
			{
				String dataPesquisa = pesquisasView.inputData();
				

				if(!procuraPartidas(dataPesquisa, partidas, partidass))

				for(Entry<String, List<Partida>> grupo : partidas.entrySet())
				{
					for(Partida partida : grupo.getValue())
					{
						
						if(partida.getData().equals(dataPesquisa))
						{
							partidass.mostrarPartida(partida.getCodigo());
						}
					
					}
				}

				
						pesquisasView.mostrar("Nemhuma partida com essa foi encontrada");
						
				break;
			}
			if(opcao ==2)
			{
				if(listaSelecoes.size()>0)
				{
					pesquisasView.mostrar(null);
					pesquisasView.mostrar("Lista de Selecoes:");
					//Percorrendo a lista de cadastros
					for(int i=0; i< listaSelecoes.size(); i++)
					{
						System.out.println("["+(i)+"]"+((Selecao) listaSelecoes.get(i)).getNome()); // Imprimindo o nome da Seleção
					}
					pesquisasView.mostrar(null);
					
				}
				else
					pesquisasView.mostrar("Ainda nao foram cadastradas Selecoes no sistema");
					
				
				
			pesquisasView.mostrar("Digite o indice da Selecao que deseja exibir as partidas:");
			int escolhaSelecao = pesquisasView.inputInt(0, listaSelecoes.size());
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
			pesquisasView.mostrar("Digite um nome para pesquisar registros no sistema:");
			String nomeJogador= pesquisasView.inputStr();
			if(!listaJogadoresPorNome(listaSelecoes,nomeJogador, jogador))
				pesquisasView.mostrar("Nemhum jogador com esse nome foi encontrado!");
			
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
