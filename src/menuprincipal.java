
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
import java.io.IOException;
import java.util.Scanner;
import model.ArbitroDaoImpl;
import model.JogadorDaoImpl;
import model.SelecaoDaoImpl;
import model.TecnicoDaoImpl;
import model.TratamentosExcecoes;

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
	 */
	public static void main(String[] args) 
	{
		//Instanciando objetos que serão usadas para invocar métodos nas opções do menu
		ArbitroDaoImpl juiz = new ArbitroDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Árbitros no sistema
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Seleções no sistema
		TecnicoDaoImpl tecnico = new TecnicoDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Técnicos no sistema
		JogadorDaoImpl jogador = new JogadorDaoImpl(selecao.getListaSelecoes());//Instanciando objeto da Classe responsável pelo CRUD de Jogadores no sistema
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		
		int continua = 0;// variável para condicionar while do menu principal 
		System.out.println("Bem vindo ao Syscopa!");
		while(continua ==0)// repetição do menu principal
		{
			
			//Exibindo opções do menu
			System.out.println();
			System.out.println("MENU:");
			System.out.println("1- Selecoes 2- Jogadores 3- Tecnicos 4- Arbitros 5- Encerrar");
			System.out.println("Digite uma opcao:");
			
			int escolha = tratamento.validaInt(0,5); //Leitura da entrada de inteiro valido(de 1 a 5)
		
			
			switch(escolha)
			{
			
			case 1:
				//Exibindo opções do menu da opção 1 (Seleções)
				System.out.println("Opcoes para Selecao:");
				System.out.println("1- Cadastrar 2- Editar 3- Excluir 4- Listar 5- Voltar");
				int escolha1 = tratamento.validaInt(0,5);//Leitura da entrada de inteiro valido(de 1 a 5)
				
				
				if(escolha1 == 1)
				{
					selecao.cadastrarSelecao(); //Chamando método do DAO para cadastrar Seleção
				}
				
				else if (escolha1 == 2)
				{
					selecao.editarSelecao();//Chamando método do DAO para editar Seleção
				}
				
				else if (escolha1 == 3)
				{
					selecao.apagarSelecao(); //Chamando método do DAO para apagar Seleção
				}
				else if (escolha1 == 4)
				{
					selecao.listarSelecao(); //Chamando método do DAO para listar Seleções
				}
				else if(escolha == 5) // Volta para parte anterior do menun
				{
					continue;
				}
			break;
			
			
			case 2:
				System.out.println("Opcoes para Jogador:");
				System.out.println("1- Cadastrar \n2- Editar \n3- Excluir \n4- Listar \n5- Voltar");
				
				Scanner entrada = new Scanner(System.in);
				int escolha5 = tratamento.validaInt(1, 5);
				if(escolha5 == 1)
				{
					jogador.cadastrar();
					}
					
				else if(escolha5 == 2)
				{
					System.out.println("Digite o nome da selecao do Jogador");
					selecao.listarSelecao();
					String nomeSelecao = entrada.next();
					jogador.listarJogadores(nomeSelecao);
					System.out.println("Digite o Codigo do jogador: ");
					String codigo = entrada.next();
					jogador.imprimirJogador(nomeSelecao);
					
					
					System.out.println("Opcoes para update");
					System.out.println("1- Editar nome"
			
							+ "\n2- Editar posicao"
							+ "\n3- Editar Numero de cartoes amarelos"
							+ "\n4- Editar Numero de cartoes vermelho"
							+ "\n5- Editar Gols marcados");
					System.out.println("Digite a opcao que deseja alterar: ");
					int opcao = entrada.nextInt();
					
					if(opcao == 1) {
						
						jogador.imprimirJogador(codigo);
						System.out.println("Digite o nome do jogador: ");
						String nome = entrada.next();
						jogador.atualizarDadosJogador(codigo, opcao, nome,nomeSelecao);
					}
					
					else if(opcao == 2) {
						
						System.out.println("Digite o nome da selecao que deseja alterar o jogador");
						String selecaobusca = entrada.nextLine();
						jogador.imprimirJogador(codigo);
						jogador.listarPosicoes();
						System.out.println("Digite a posicao: ");
						String posicao = entrada.next();
						jogador.atualizarDadosJogador(codigo, opcao, posicao,nomeSelecao);
					}
					else if(opcao == 3) {
						jogador.imprimirJogador(codigo);
						System.out.println("O que deseja fazer?"
								+ "\n[1] Retirar cartao"
								+ "\n[2] Adicionar cartao");
						int opcaoCartao = entrada.nextInt();
						if(opcaoCartao == 1) {
							System.out.println("Digite a quantidade de cartoes amarelos");
							String cartoesAmarelos = entrada.next();
							jogador.atualizarDadosJogador(codigo, opcao, "-"+cartoesAmarelos,nomeSelecao);
						}
						else if(opcaoCartao == 2){
							System.out.println("Digite a quantidade de cartoes amarelos");
							String cartoesAmarelos = entrada.next();
							jogador.atualizarDadosJogador(codigo, opcao, cartoesAmarelos,nomeSelecao);
						}
						
						
					}
					else if(opcao == 4) {
						jogador.imprimirJogador(codigo);
						System.out.println("O que deseja fazer?"
								+ "\n[1] Retirar cartao"
								+ "\n[2] Adicionar cartao");
						int opcaoCartao = entrada.nextInt();
						if(opcaoCartao == 1) {
							System.out.println("Digite a quantidade de cartoes vermelhos");
							String cartoesVermelhos= entrada.next();
							jogador.atualizarDadosJogador(codigo, opcao, "-"+cartoesVermelhos,nomeSelecao);
						}
						else if(opcaoCartao == 2){
							System.out.println("Digite a quantidade de cartoes amarelos");
							String cartoesVermelhos = entrada.next();
							jogador.atualizarDadosJogador(codigo, opcao, cartoesVermelhos,nomeSelecao);
						}
					}
					else if(opcao == 5) {
						jogador.imprimirJogador(codigo);
						System.out.println("O que deseja fazer?"
								+ "\n[1] Retirar cartao"
								+ "\n[2] Adicionar cartao");
						int opcaoCartao = entrada.nextInt();
						if(opcaoCartao == 1) {
							System.out.println("Digite a quantidade de gols");
							String gols= entrada.next();
							jogador.atualizarDadosJogador(codigo, opcao, "-"+gols,nomeSelecao);
						}
						else if(opcaoCartao == 2){
							System.out.println("Digite a quantidade de gols");
							String gols = entrada.next();
							jogador.atualizarDadosJogador(codigo, opcao, gols,nomeSelecao);
					}
					}
					
				}
				else if(escolha5 == 3) {
					selecao.listarSelecao();
					System.out.println("Digite o nome da selecao que deseja listar os jogadores");
					String nomeSelecao = entrada.next();
					jogador.listarJogadores(nomeSelecao);
					System.out.println("Digite o Codigo do jogador: ");
					String codigo = entrada.next();
					jogador.deletarJogador(codigo,nomeSelecao);


				}
				else if(escolha5 == 4)
				{	
					selecao.listarSelecao();
					System.out.println("Digite o nome da selecao que deseja listar os jogadores");
					String nomeSelecao = entrada.next();
					jogador.listarJogadoresDados(nomeSelecao);
				}
				else if(escolha == 5) {
					continue;
				}
				
				break;
			
			case 3:/* Caso o usuário escolha a opção 4, irão aparecer as opções referentes a Técnico.*/
				
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
			
				
			
			
			case 4: /* Caso o usuário escolha a opção 4, irão aparecer as opções referentes a Arbitro.*/
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
			case 5:
				continua = -1; //Atualizando a variavel que sai do while do menu princiapl
				
				break; // Saída do menu principal
			}
			
			
		}
			
			System.out.println("Fim");
			
			
				
		}
}


	

		
	




