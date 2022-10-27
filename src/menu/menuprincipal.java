package menu;

/*
Autores: Matheus Mota e Mailson Alves
Componente Curricular: EXA805 Algoritimo e Progamação II
Concluido em: 03/10/2022
Declaro que este código foi elaborado por mim de forma coletiva e não contém nenhum
trecho de código de outro colega além dos envolvidos ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/

import java.util.Scanner;



import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;
import model.SelecaoPackage.Selecao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import model.ArbitroPackage.ArbitroDaoImpl;
import model.JogadorPackage.JogadorDaoImpl;
import model.PartidaPackage.Partida;
import model.PartidaPackage.PartidaDaoImpl;
import model.SelecaoPackage.SelecaoDaoImpl;
import model.TecnicoPackage.TecnicoDaoImpl;



/**
 * Essa classe é a classe principal do programa onde fica o menu principal
 * @author Mailson
 * @since 2022
 */
public class menuprincipal 
{
	
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		//Instanciando objetos que serão usadas para invocar métodos nas opções do menu
		ArbitroDaoImpl juiz = new ArbitroDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Árbitros no sistema
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Seleções no sistema
		TecnicoDaoImpl tecnico = new TecnicoDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Técnicos no sistema
		tecnico.setLista(selecao.getListaSelecoes());
		JogadorDaoImpl jogador = new JogadorDaoImpl(selecao.getListaSelecoes());//Instanciando objeto da Classe responsável pelo CRUD de Jogadores no sistema
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		PartidaDaoImpl partidas = new PartidaDaoImpl(selecao.getListaSelecoes());
		System.out.println("Bem vindo ao Syscopa 2.0!\n");
		
		//selecao.cadastrarNomesDeTodasSelecoes();
		System.out.println("Inicializando o programa,aguarde...");
		selecao.leArquivoSelecoes();
		//jogador.transformaEmMap();
		partidas.geraPartidas();

		
		int continua = 0;// variável para condicionar while do menu principal 
		
		while(continua ==0)// repetição do menu principal
		{
			
			//Exibindo opções do menu
			System.out.println();
			System.out.println("MENU:");
			System.out.println("1-Partidas 2-Selecoes 3- Jogadores 4- Tecnicos 5- Arbitros 6- Pesquisas 7- Encerrar");
			System.out.println("Digite uma opcao:");
			
			int escolha = tratamento.validaInt(0,7); //Leitura da entrada de inteiro valido(de 1 a 7)
			
			

			switch(escolha)
			{
			
			
			case 1:
				//Exibindo opções do menu da opção 1 (Seleções)
				System.out.println("Opcoes para Partida:");
				partidas.listarTodasPartidas();
				System.out.println("1- Cadastrar Partidas 2- Editar 3- Listar por Grupo 4- Cancelar Partida 5-Voltar");
				int escolha0 = tratamento.validaInt(0,5);
				
				if(escolha0==1)
				{
					partidas.inserir();
				}
				if(escolha0 == 2)
				{
					partidas.atualizar(null);
				}
				if(escolha0 == 3)
				{
					partidas.listarTodasPartidas();
				}
				if(escolha0== 4)	
					
				{	Scanner entrada = new Scanner(System.in);
					String[] grupos = {"A","B","C","D","E","F","G","H"};
					partidas.listarTodasPartidas();
					System.out.println("Informe o grupo: ");
					String grupo = tratamento.EntradaString();
					partidas.listarPartidaCodigo(grupo.toUpperCase());;
					System.out.println("Informe o codigo da partida que deseja resetar");
					String codigo = entrada.next();
					partidas.deletar(codigo);
				}
				if(escolha0== 5)
				{
					continue;
				}
				break;
			
			
			case 2:
				//Exibindo opções do menu da opção 1 (Seleções)
				System.out.println("Opcoes para Selecao:");
				System.out.println("1- Cadastrar ou Editar Selecao 2- Listar Selecoes 3- Voltar");
				int escolha1 = tratamento.validaInt(0,3);//Leitura da entrada de inteiro valido(de 1 a 5)
				
				
				if(escolha1 == 1)
				{
					selecao.cadastrarSelecao();
					
				}
				
				else if (escolha1 == 2)
				{
					selecao.listarSelecao();
				}
				
				else if (escolha1 == 3)
				{
					continue;
				}
				
			break;
			
			
			case 3:
				System.out.println("Opcoes para Jogador:");
				System.out.println("1- Cadastrar \n2- Editar \n3- Excluir \n4- Listar \n5- Voltar");
				
				Scanner entrada = new Scanner(System.in);
				int escolha5 = tratamento.validaInt(1, 5);
				if(escolha5 == 1)
				{
					jogador.cadastrarUmJogador();
				}
					
				else if(escolha5 == 2)
				{
					jogador.editarJogador();
					
					
				}
				else if(escolha5 == 3) {
					selecao.listarSelecao();
					System.out.println("Digite o indice da selecao que deseja excluir um jogador");
					int indiceSelecao = tratamento.validaInt(1, selecao.getListaSelecoes().size());
					jogador.listarJogadores(selecao.getListaSelecoes().get(indiceSelecao).getNome());
					System.out.println("Digite o Codigo do jogador: ");
					String codigo = entrada.next();
					jogador.deletarJogador(codigo,selecao.getListaSelecoes().get(indiceSelecao).getNome());


				}
				else if(escolha5 == 4)
				{	
					selecao.listarSelecao();
					System.out.println("Digite o indice da selecao que deseja listar os jogadores");
					int indiceSelecao = tratamento.validaInt(1, selecao.getListaSelecoes().size());
					jogador.listarJogadores(selecao.getListaSelecoes().get(indiceSelecao).getNome());
					
				}
				else if(escolha == 5) {
					continue;
				}
				
				break;
			
			case 4:/* Caso o usuário escolha a opção 4, irão aparecer as opções referentes a Técnico.*/
				
				System.out.println("Opcoes para Tecnico:"); /*Lista de opções para esse menu*/
				System.out.println(" 1- Cadastrar Tecnico 2- Editar 3- Excluir 4- Listar 5- Voltar");
				int escolha3 = tratamento.validaInt(1,5);/*Váriavel para guardar a escolha da entrada*/
				if(escolha3 == 1)
				{
					tecnico.cadastrarTecnicoSemSelecao();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer o cadastro um novo técnico. */
				}
				
				if(escolha3 == 2)
				{
					tecnico.editarTecnico();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer o cadastro um novo técnico. */
				}
				else if(escolha3 == 3)
				{
					tecnico.apagarTecnico();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a remoção de um técnico */
				}
				else if(escolha3 == 4)
				{
					tecnico.listarTecnico();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a listagem dos técnicos cadastrados no sistema. */
				}
				else if(escolha == 5) {
					continue; /* Volta para parte anterior do menu*/
				}
				
				break;
			
				
			
			
			case 5: /* Caso o usuário escolha a opção 4, irão aparecer as opções referentes a Arbitro.*/
				System.out.println("Opcoes para Arbitro:");/*Lista de opções para esse menu*/
				System.out.println("1- Cadastrar 2- Editar 3- Excluir 4- Listar 5- Voltar");
				
				
				int escolha4 = tratamento.validaInt(1,5); /*Váriavel para guardar a escolha da entrada*/
				if(escolha4 == 1) 
				{
					juiz.cadastrarArbitro(); /*Chamando o método da classe responsável pelo CRUD de arbitro para fazer o cadastro um novo arbitro. */
				}
				else if(escolha4 == 2)
				{
			
					juiz.editarArbitro();/*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a edição de um arbitro. */
				}
				else if(escolha4 == 3)
				{
	
					juiz.apagarArbitro(); /*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a exlusão de um arbitro. */
				}
				else if(escolha4 == 4)
				{	
					juiz.listarArbitros(); /*Chamando o método da classe responsável pelo CRUD de arbitro para fazer a listagem dos arbitros cadastrados no sistema. */
				}
				else if(escolha == 5) {
					continue;/* Volta para parte anterior do menu*/
				}
				break;
			case 6:
				
			
			case 7:
				
				continua = -1; //Atualizando a variavel que sai do while do menu princiapl
				
				break; // Saída do menu principal
			
		
			}
			}
			
			System.out.println("Fim do programa");
			
			
				
		}


			
			
	
}


	

		
	




