package controller;

import java.io.IOException;
import java.util.Scanner;

import model.ArbitroPackage.ArbitroDaoImpl;
import model.JogadorPackage.JogadorDaoImpl;
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
			int escolha0 = partidaView.menuOpcoes();
			
			if(escolha0==1)
			{
				partidasDao.inserir();
			}
			
			
			if(escolha0 == 2)
			{
				partidasDao.listarTodasPartidas();
				String grupo = partidaView.editarPartidaEscolheGrupo();
				partidasDao.listarPartidaCodigo(grupo.toUpperCase());;
				String codigo = partidaView.editarPartidaEscolheCodigo();
				partidasDao.atualizar(codigo);
			}
			if(escolha0 == 3)
			{
				partidasDao.listarTodasPartidas();
			}
			if(escolha0== 4)		
			{	
				partidasDao.listarTodasPartidas();
				String grupo = partidaView.cancelarPartidaEscolheGrupo();
				partidasDao.listarPartidaCodigo(grupo.toUpperCase());;
				String codigo = partidaView.cancelarPartidaEscolheCodigo();
				partidasDao.deletar(codigo);
			}
			if(escolha0== 5)
			{
				break;
			}
			break;
		 
		
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
	
			
	
	


