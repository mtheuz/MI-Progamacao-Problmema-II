package controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.ArbitroPackage.ArbitroDaoImpl;
import model.JogadorPackage.JogadorDaoImpl;
import model.PartidaPackage.Partida;
import model.PartidaPackage.PartidaDaoImpl;
import model.PesquisaPackage.Pesquisas;
import model.SelecaoPackage.SelecaoDaoImpl; 
import model.TecnicoPackage.TecnicoDaoImpl;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;
import view.*;

public class Controller {

	
	public void menu(int escolha) throws IOException, InterruptedException
	{
		ArbitroDaoImpl juizDao = new ArbitroDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Árbitros no sistema
		SelecaoDaoImpl selecaoDao = new SelecaoDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Seleções no sistema
		TecnicoDaoImpl tecnicoDao = new TecnicoDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Técnicos no sistema
		tecnicoDao.setLista(selecaoDao.getListaSelecoes());
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecaoDao.getListaSelecoes());//Instanciando objeto da Classe responsável pelo CRUD de Jogadores no sistema
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		PartidaDaoImpl partidasDao = new PartidaDaoImpl(selecaoDao.getListaSelecoes());
		Pesquisas pesquisas = new Pesquisas();
		selecaoDao.leArquivoSelecoes();
		partidasDao.geraPartidas(); 
		jogadorDao.transformaEmMap();
		
		while(escolha !=7)
		{
		switch(escolha)
		{
		
		case 1:
			//Exibindo opções do menu da opção 1 (Seleções)
			PartidaView partidaView = new PartidaView();
			
			do {
				int escolha0 = partidaView.menuOpcoes();
				if(escolha0==1) {
					String[] grupos = {"A","B","C","D","E","F","G","H"};
					partidasDao.imprimeGrupos();
					int indicePartida = partidaView.indicePartida();
					int controle = 1;
					
					do {
						partidasDao.listarPartidaCodigoNaoJogadas(grupos[indicePartida]);
						String codigo = partidaView.cadastrarPartidaEscolheCodigoPartida();
						Partida partida = partidasDao.findPartida(codigo);
						if(partida!= null) {
							String selecao1 = partida.getSelecao1();
							String selecao2 = partida.getSelecao2();
							partidaView.mostrar("|Partida: "+selecao1+" X "+selecao2+"|");
							
							String dia = partidaView.cadastrarDia();
							String mes = partidaView.cadastrarMes();
							String ano = partidaView.cadastrarAno();
							String hora = partidaView.cadastrarHora();
							String minutos = partidaView.cadastrarMinuto();
							partidasDao.listarLocal();
							int local = partidaView.cadastrarLocal();
							
							int selecao1Gols = partidaView.yesOrNoGol(selecao1);
							if(selecao1Gols == 1) {
								int controle2 = 1;
								do {
								jogadorDao.listarJogadores(selecao1);
								String codigoJogador = partidaView.cadastrarPartidaEscolheJogador();
								String gols = partidaView.cadastrarGolsSelecao();
								partidasDao.inputGolsSelecao1(partida, gols, codigoJogador);
								controle2 = partidaView.continuidade("gols");
								}while(controle2 != 0);
							}
							
							selecao1Gols = partidaView.yesOrNoGol(selecao2);
							if(selecao1Gols == 1) {
								int controle2 = 1;
								do {
								jogadorDao.listarJogadores(selecao2);
								String codigoJogador = partidaView.cadastrarPartidaEscolheJogador();
								String gols = partidaView.cadastrarGolsSelecao();
								partidasDao.inputGolsSelecao2(partida, gols, codigoJogador);
								controle2 = partidaView.continuidade("gols");
								}while(controle2 != 0);
							}
							
							int selecaoCartoesAmarelos = partidaView.yesOrNoCartao(selecao1,"Amarelo");
							if(selecaoCartoesAmarelos == 1) {
								int controle2 = 1;
								do {
								jogadorDao.listarJogadores(selecao1);
								String codigoJogador = partidaView.cadastrarPartidaEscolheJogador();
								String cartoes = partidaView.cadastrarCartoesSelecao();
								partidasDao.inputCartosAmarelosSelecao1(partida, cartoes, codigoJogador);
								controle2 = partidaView.continuidade("cartoes");
								}while(controle2 != 0);
							}
							
							selecaoCartoesAmarelos = partidaView.yesOrNoCartao(selecao1,"Amarelo");
							if(selecaoCartoesAmarelos == 1) {
								int controle2 = 1;
								do {
								jogadorDao.listarJogadores(selecao2);
								String codigoJogador = partidaView.cadastrarPartidaEscolheJogador();
								String cartoes = partidaView.cadastrarCartoesSelecao();
								partidasDao.inputCartosAmarelosSelecao2(partida, cartoes, codigoJogador);
								controle2 = partidaView.continuidade("cartoes");
								}while(controle2 != 0);
								
							}
							int selecaoCartoesVermelhos = partidaView.yesOrNoCartao(selecao1,"Vermelho");
							if(selecaoCartoesVermelhos == 1) {
								int controle2 = 1;
								do {
								jogadorDao.listarJogadores(selecao1);
								String codigoJogador = partidaView.cadastrarPartidaEscolheJogador();
								partidasDao.inputCartosVermelhoSelecao1(partida, "1", codigoJogador);
								controle2 = partidaView.continuidade("cartoes");
								}while(controle2 != 0);
							}
							
							selecaoCartoesAmarelos = partidaView.yesOrNoCartao(selecao2,"Vermelho");
							if(selecaoCartoesVermelhos == 1) {
								int controle2 = 1;
								do {
								jogadorDao.listarJogadores(selecao2);
								String codigoJogador = partidaView.cadastrarPartidaEscolheJogador();
								partidasDao.inputCartosVermelhoSelecao2(partida, "1", codigoJogador);
								controle2 = partidaView.continuidade("cartoes");
								}while(controle2 != 0);
								
							}
							
							final String estadio = partidasDao.getEstadios()[local];
							if(partidasDao.inserir(dia, mes, ano, hora, minutos, estadio, partida)) {
								System.out.println("");
								partidaView.mostrar("-----------------Partida Gerada-----------------");
								partidasDao.mostrarPartida(partida.getCodigo());
								controle = partidaView.continuidade("Partida");
							}else{
								partidaView.mostrar("Uma das selecoes da partida ou ambas nao foram cadastradas por completo no sistema");
								partidaView.mostrar("Cadastre as selecoes antes de cadastrar a partida\n");
							}
						}else{
							partidaView.mostrar("Partida inexistente");
						};
				}while(controle != 0);
			}
			
			
			if(escolha0 == 2)
			{
				partidasDao.listarTodasPartidas();
				String grupo = partidaView.editarPartidaEscolheGrupo();
				if(partidasDao.listarPartidaCodigoJogados(grupo.toUpperCase())) {
				String codigo = partidaView.editarPartidaEscolheCodigo();
				Partida partida = partidasDao.findPartida(codigo);
				
				final String selecao1 = partida.getSelecao1();
				final String selecao2 = partida.getSelecao2();
				partidasDao.mostrarPartida(codigo);
				int opcaoAtualizacao = partidaView.menuEdição(selecao1,selecao2);
				switch (opcaoAtualizacao) {
				case 1:
					String dia = partidaView.cadastrarDia();
					String mes = partidaView.cadastrarMes();
					String ano = partidaView.cadastrarAno();
					partidasDao.atualizarData(partida, dia, mes, ano);
					partidasDao.mostrarPartida(codigo);
					break;
				case 2:
					String hora = partidaView.cadastrarHora();
					String minutos = partidaView.cadastrarMinuto();
					partidasDao.atualizarHora(partida, hora, minutos);
					partidasDao.mostrarPartida(codigo);
					break;
				case 3:
					partidasDao.listarLocal();
					int local = partidaView.cadastrarLocal();
					partidasDao.atualizarLocal(partida, local);
					partidasDao.mostrarPartida(codigo);
					break;
				case 4:
					int opcaoCartao = partidaView.opcaoCartao();
					if(opcaoCartao == 0) {
						partidaView.mostrar("Cartoes Amarelo");
						partidasDao.listarJogadoresCartoes(partida.getCartoesAmarelosSelecao1());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getCartoesAmarelosSelecao1().size());
						List<String> jogador = partida.getCartoesAmarelosSelecao1().get(indiceJogador);
						String quantidadeCartoes = partidaView.cadastrarCartoesSelecao();
						int quantidadeCartoesInt = Integer.parseInt(quantidadeCartoes);
						partidasDao.adicionarCartaoAmarelo(quantidadeCartoesInt, jogador);
						partidasDao.mostrarPartida(codigo);
					}
					else {
						partidaView.mostrar("Cartoes Amarelo");
						partidasDao.listarJogadoresCartoes(partida.getCartoesAmarelosSelecao1());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getCartoesAmarelosSelecao1().size());
						List<String> jogador = partida.getCartoesAmarelosSelecao1().get(indiceJogador);
						String quantidadeCartoes = partidaView.cadastrarCartoesSelecao();
						int quantidadeCartoesInt = Integer.parseInt(quantidadeCartoes);
						partidasDao.retirarCartaoAmarelo(quantidadeCartoesInt, jogador);
						partidasDao.mostrarPartida(codigo);
					}
					break;
					
				case 5:
					opcaoCartao = partidaView.opcaoCartao();
					if(opcaoCartao == 0) {
						partidaView.mostrar("Cartoes Amarelo");
						partidasDao.listarJogadoresCartoes(partida.getCartoesAmarelosSelecao2());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getCartoesAmarelosSelecao2().size());
						List<String> jogador = partida.getCartoesAmarelosSelecao2().get(indiceJogador);
						String quantidadeCartoes = partidaView.cadastrarCartoesSelecao();
						int quantidadeCartoesInt = Integer.parseInt(quantidadeCartoes);
						partidasDao.adicionarCartaoAmarelo(quantidadeCartoesInt, jogador);
						partidasDao.mostrarPartida(codigo);
					}
					else {
						partidaView.mostrar("Cartoes Amarelo");
						partidasDao.listarJogadoresCartoes(partida.getCartoesAmarelosSelecao2());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getCartoesAmarelosSelecao2().size());
						List<String> jogador = partida.getCartoesAmarelosSelecao2().get(indiceJogador);
						String quantidadeCartoes = partidaView.cadastrarCartoesSelecao();
						int quantidadeCartoesInt = Integer.parseInt(quantidadeCartoes);
						partidasDao.retirarCartaoAmarelo(quantidadeCartoesInt, jogador);
						partidasDao.mostrarPartida(codigo);
						
					}
					break;
				
				case 6:
					opcaoCartao = partidaView.opcaoCartao();
					if(opcaoCartao == 0) {
						partidaView.mostrar("Cartoes Vermelho");
						partidasDao.listarJogadoresCartoes(partida.getCartoesVermelhosSelecao1());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getCartoesVermelhosSelecao1().size());
						List<String> jogador = partida.getCartoesVermelhosSelecao1().get(indiceJogador);
						partidasDao.retirarCartaoVemelho(jogador);
						partidasDao.mostrarPartida(codigo);
					}
					else {
						partidaView.mostrar("Cartoes Vermelho");
						partidasDao.listarJogadoresCartoes(partida.getCartoesVermelhosSelecao1());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getCartoesVermelhosSelecao1().size());
						List<String> jogador = partida.getCartoesVermelhosSelecao1().get(indiceJogador);
						partidasDao.adicionarCartaoVemelho(jogador);
						partidasDao.mostrarPartida(codigo);
						}
					break;
					
				case 7:
					opcaoCartao = partidaView.opcaoCartao();
					if(opcaoCartao == 0) {
						partidaView.mostrar("Cartoes Vermelho");
						partidasDao.listarJogadoresCartoes(partida.getCartoesVermelhosSelecao2());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getCartoesVermelhosSelecao2().size());
						List<String> jogador = partida.getCartoesVermelhosSelecao2().get(indiceJogador);
						partidasDao.retirarCartaoVemelho(jogador);
						partidasDao.mostrarPartida(codigo);
					}
					else {
						partidaView.mostrar("Cartoes Vermelho");
						partidasDao.listarJogadoresCartoes(partida.getCartoesVermelhosSelecao2());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getCartoesVermelhosSelecao2().size());
						List<String> jogador = partida.getCartoesVermelhosSelecao2().get(indiceJogador);
						partidasDao.adicionarCartaoVemelho(jogador);
						partidasDao.mostrarPartida(codigo);
						}
					break;
				
				case 8:
					int opcaoGols = partidaView.opcaoGol();
					if(opcaoGols == 0) {
						partidaView.mostrar("Gols");
						partidasDao.listarJogadoresCartoes(partida.getGolsSelecao1());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getGolsSelecao1().size());
						List<String> jogador = partida.getGolsSelecao1().get(indiceJogador);
						String quantidadeGols = partidaView.cadastrarGolsSelecao();
						int quantidadeGolsInt = Integer.parseInt(quantidadeGols);
						partidasDao.adicionarGols(quantidadeGolsInt, jogador);
						partidasDao.mostrarPartida(codigo);
					}
					else {
						partidaView.mostrar("Gols");
						partidasDao.listarJogadoresCartoes(partida.getGolsSelecao1());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getGolsSelecao1().size());
						List<String> jogador = partida.getGolsSelecao1().get(indiceJogador);
						String quantidadeGols = partidaView.cadastrarGolsSelecao();
						int quantidadeGolsInt = Integer.parseInt(quantidadeGols);
						partidasDao.retirarGols(quantidadeGolsInt, jogador);
						partidasDao.mostrarPartida(codigo);
						}
					break;
					
				case 9:
					opcaoGols = partidaView.opcaoGol();
					if(opcaoGols == 0) {
						partidaView.mostrar("Gols");
						partidasDao.listarJogadoresCartoes(partida.getGolsSelecao2());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getGolsSelecao2().size());
						List<String> jogador = partida.getGolsSelecao2().get(indiceJogador);
						String quantidadeGols = partidaView.cadastrarGolsSelecao();
						int quantidadeGolsInt = Integer.parseInt(quantidadeGols);
						partidasDao.adicionarGols(quantidadeGolsInt, jogador);
						partidasDao.mostrarPartida(codigo);
					}
					else {
						partidaView.mostrar("Gols");
						partidasDao.listarJogadoresCartoes(partida.getGolsSelecao2());
						int indiceJogador = partidaView.indiceJogadorPartida(partida.getGolsSelecao2().size());
						List<String> jogador = partida.getGolsSelecao2().get(indiceJogador);
						String quantidadeGols = partidaView.cadastrarGolsSelecao();
						int quantidadeGolsInt = Integer.parseInt(quantidadeGols);
						partidasDao.retirarGols(quantidadeGolsInt, jogador);
						partidasDao.mostrarPartida(codigo);
						}
					break;

				default:
					break;
				}
				}
			}
			if(escolha0 == 3)
			{
				partidasDao.listarTodasPartidas();
			}
			if(escolha0== 4)		
			{	
				partidasDao.listarTodasPartidas();
				String grupo = partidaView.cancelarPartidaEscolheGrupo();
				if(partidasDao.listarPartidaCodigoJogados(grupo.toUpperCase())) {
				String codigo = partidaView.cancelarPartidaEscolheCodigo();
				partidasDao.deletar(codigo);
				}
			}
			if(escolha0== 5)
			{
				break;
			}
			}while(true);
		 
		
		case 2:
			//Exibindo opções do menu da opção 1 (Seleções)
			
			SelecaoView selecaoView = new SelecaoView();
			int escolha1 = selecaoView.menuOpcoes();
			
			
			if(escolha1 == 1)
			{
				String nomeSelecao = selecaoView.cadastrarSelecao();
				selecaoDao.procedimentoCadastrarSelecao(nomeSelecao); //Método para completar o cadastro da seleção
				
			}
			
			else if (escolha1 == 2)
			{
				selecaoDao.listarSelecao();
			}
			
			else if (escolha1 == 3)
			{
				selecaoDao.ProcedimentoEditarSelecao(partidasDao);
				
			}
			else if (escolha1 == 4)
			{
				break;
			}
		break;
		
		
		case 3:
			JogadorView jogadorView = new JogadorView();
			int escolha5 = jogadorView.menuOpcoes();
			
			if(escolha5 == 1)
			{
				jogadorDao.cadastrarUmJogador();
			}
				
			else if(escolha5 == 2)
			{
				jogadorDao.editarJogador();
				
				
			}
			else if(escolha5 == 3) {
				selecaoDao.listarSelecao();
				int tam = selecaoDao.getListaSelecoes().size();
				int indiceSelecao = jogadorView.deletarJogadorEscolheIndice(tam);
				jogadorDao.listarJogadores(selecaoDao.getListaSelecoes().get(indiceSelecao).getNome());
				String codigo = jogadorView.deletarJogadorEscolheCodigo();
				jogadorDao.deletarJogador(codigo,selecaoDao.getListaSelecoes().get(indiceSelecao).getNome());


			}
			else if(escolha5 == 4)
			{	
				selecaoDao.listarSelecao();
				int tam = selecaoDao.getListaSelecoes().size();
				int indiceSelecao = jogadorView.listarJogadorEscolheIndice(tam);
				jogadorDao.listarJogadoresDados(indiceSelecao);
				
			}
			else if(escolha == 5) {
				break;
			}
			
			break;
		
		case 4:/* Caso o usuário escolha a opção 4, irão aparecer as opções referentes a Técnico.*/
			
			TecnicoView tecnicoView = new TecnicoView();
			int escolha3 = tecnicoView.menuOpcoes();
			if(escolha3 == 1)
			{
				tecnicoDao.cadastrarTecnicoSemSelecao();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer o cadastro um novo técnico. */
			}
			
			if(escolha3 == 2)
			{
				tecnicoDao.editarTecnico();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer o cadastro um novo técnico. */
			}
			else if(escolha3 == 3)
			{
				tecnicoDao.apagarTecnico();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a remoção de um técnico */
			}
			else if(escolha3 == 4)
			{
				tecnicoDao.listarTecnico();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a listagem dos técnicos cadastrados no sistema. */
			}
			else if(escolha == 5) {
				break; /* Volta para parte anterior do menu*/
			}
			
			break;
		
			
		
		
		case 5: /* Caso o usuário escolha a opção 4, irão aparecer as opções referentes a Arbitro.*/
			ArbitroView arbitroView = new ArbitroView();
			int escolha4 = arbitroView.menuOpcoes();
			
			if(escolha4 == 1) 
			{
				juizDao.cadastrarArbitro(); /*Chamando o método da classe responsável pelo CRUD de arbitro para fazer o cadastro um novo arbitro. */
			}
			else if(escolha4 == 2)
			{
		
				juizDao.editarArbitro();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a edição de um arbitro. */
			}
			else if(escolha4 == 3)
			{

				juizDao.apagarArbitro(); /*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a exlusão de um arbitro. */
			}
			else if(escolha4 == 4)
			{	
				juizDao.listarArbitros(); /*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a listagem dos arbitros cadastrados no sistema. */
			}
			else if(escolha == 5) {
				break;/* Volta para parte anterior do menu*/
			}
			break;
		case 6:

			pesquisas.pesquisas(partidasDao.getPartidas(), selecaoDao.getListaSelecoes(), partidasDao,jogadorDao);

			break;
		 
		default:
		{
		
			break;
		}
	}
		escolha = menuPrincipalView.menuView();
	}
	System.out.println("Fim do programa");
	}
}
	
			
	
	


