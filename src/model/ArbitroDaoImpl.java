package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A classe <b> ArbitroDaoImpl </b> é responsável pelo CRUD de objetos da classe Árbitro
 * @author Mailson
 * @since 2022
 */
public class  ArbitroDaoImpl implements ArbitroDAO
{
	/**
	 * listaArbitros é uma lista (ArrayList) que armazena todos os cadastro de Árbitro do sistema
	 */
	private ArrayList<Arbitro> listaArbitros;

/**
 * Construtor padrão da classe <b>ArbitroDaoImpl</b>
 */
public ArbitroDaoImpl()
{
	this.listaArbitros = new ArrayList<Arbitro>(); // Inicializando lista vazia
}

/**
 * O método cadastrarArbitro é responsável por cadastrar um novo árbitro no sistema
 * @return Void
 */
public void cadastrarArbitro() 
{
	TratamentosExcecoes tratamento = new TratamentosExcecoes();//Instanciando classe existe para validar dados de entrada no programa
	
	final int QtdArbitros = 36; //Quantidade de Árbitros que a copa pode ter
	if(listaArbitros.size()<QtdArbitros)
	{
		Arbitro juiz = new Arbitro(); /*Instanciando um objeto da classe Arbitro*/
		
		Scanner entrada = new Scanner(System.in); 
		
		while(true) 
		{ 
			System.out.println("Digite o nome do Arbitro que deseja cadastrar");
			String nome = entrada.next(); /*Guardando a entrada do nome do novo Arbitro*/
			;
			
			if(tratamento.validaNome(nome))
			{	
				if (comparaArbitro(nome))
				{
					juiz.setNome(nome); /*Chamando método setter para guardar o nome*/
					System.out.println("Arbitro cadastrado com sucesso no sistema!");
					listaArbitros.add(juiz); /*Adicionando o cadastro a lista de cadastros de arbitros*/
					break;
				}
				
				else
					System.out.println("Ja existe um arbitro cadastrado com esse nome");
			}
			else
				System.out.println("Nome invalido, tente novamente");
					
		}
		
	
	}	
	
	else
	{
		System.out.println("Total limite de arbitros cadastrados atingido");
	}
}

/**
 * Função que serve para verificar se Árbitro existe no sistema
 * @param nome
 * @return boolean
 */
private boolean comparaArbitro(String nome) {
	for(int i=0; i<listaArbitros.size();i++)
	{
		if(((Arbitro) listaArbitros.get(i)).getNome().toUpperCase().equals(nome.toUpperCase()))
			return false;
	}
	return true;
}

/**
 * O método listarArbitro é responsável por listar os Árbitros cadastrados no sistema
 * @return Void
 */
@Override
public void listarArbitros() {
	
	if (listaArbitros.size()> 0) /*Verificação para checar se a lista de Árbitros está vazia*/
	{
		System.out.println("Lista de Arbitros:");
		System.out.println();
		for(int i=0; i< listaArbitros.size(); i++) /*Laço para percorrer a lista*/
		{
			System.out.println("["+(i+1)+"]"+"Nome: "+((Arbitro) listaArbitros.get(i)).getNome()); /*exibindo o nome de cada arbitro junto com o código (iterador) referente a cada cadastro*/
		}
		System.out.println();
	}
	else
		System.out.println("Ainda nao existem Arbitros Cadastrados no sistema");/* Mensagem para caso a lista esteja vazia*/
}

/**
 * O método editarArbitro é responsável por editar um cadastro de árbitro no sistema
 * @return Void
 */
@Override
public void editarArbitro() {
	
	TratamentosExcecoes tratamento = new TratamentosExcecoes();
	
	listarArbitros();/*Listar árbitros cadastrados no sistema para o usuário escolher*/
	if (listaArbitros.size()> 0) /*Verificação para checar se a lista de Árbitros está vazia*/
	{
		String nomeArbitro;
		while(true)
		{
			System.out.println("Digite o nome do Arbitro que deseja editar:");
			Scanner entrada = new Scanner(System.in); 
			nomeArbitro = entrada.next();/*Entrada para guardar a entrada referente ao cadastro do arbitro que será excluido*/
			if(tratamento.validaNome(nomeArbitro))
				break;
		}
			
		int indice = buscaArbitro(listaArbitros, nomeArbitro);/*Função para buscar arbitro na lista de cadastros*/
		if(indice != -1)/*caso encontre algum resultado*/
		{
			while(true)
			{
			System.out.println("Digite o novo nome do Arbitro");
			Scanner NovonomeArbitro = new Scanner(System.in); 
			String nome = NovonomeArbitro.nextLine();/*Entrada para guardar a entrada referente ao novo nome do arbitro localizado*/
			if(tratamento.validaNome(nome))
			{
				if(comparaArbitro(nome))
			
				{
					((Arbitro) listaArbitros.get(indice)).setNome(nome); /*metodo setter para definir novo nome do cadastro no campo nome do objeto*/
					System.out.println("Cadastro de arbitro atualizado com sucesso!");
					break;
				}
				else
					System.out.println("Ja existe um arbitro cadastrado com esse nome");
			}
			else
				System.out.println("Entrada invalida, tente novamente");
			}
		}
		else
		{
			System.out.println("Arbitro nao encontrado no sistema");
		}
	
	}
}
/**
 * O método cadastrarArbitro é responsável por editar um cadastro de árbitro no sistema
 * @return Void
 */
@Override
public void apagarArbitro() 
{
	if (listaArbitros.size()> 0) /*Verificação para checar se a lista de Árbitros está vazia*/
	{
		listarArbitros(); /*Listar árbitros cadastrados no sistema para o usuário escolher*/
		System.out.println("Digite o nome referente ao Arbitro que deseja remover do sistema:");
		Scanner entrada = new Scanner(System.in);
		String nomeArbitro = entrada.next();/*Entrada para guardar a entrada referente ao cadastro do arbitro que será excluido*/
		
		int indice = buscaArbitro(listaArbitros, nomeArbitro); /*Função para buscar arbitro na lista de cadastros*/
		if(indice != -1) /*caso encontre algum resultado*/
		{
			listaArbitros.remove(indice); /*Removendo o arbitro da lista de cadastrados pelo indice encontrado na busca*/
			System.out.println("Arbitro removido do sistema com sucesso!");
		}
		else
			System.out.println("Arbitro não Cadastrado no sistema.");/*Mensagem de falha na busca*/

	}
	else
		System.out.println("Ainda nao existem Arbitros Cadastrados no sistema");/* Mensagem para caso a lista esteja vazia*/
	}

/**
 * Esta função é responsável por buscar e retornar o indice na lista de um cadastro de árbitro
 * @param listaArbitros
 * @param nomeArbitro
 * @return
 */
private int buscaArbitro(ArrayList listaArbitros, String nomeArbitro) 
{
	
	for(int i=0; i<listaArbitros.size();i++) /*Laço para procurar arbitro nos cadastros*/
	{
		if(((Arbitro) listaArbitros.get(i)).getNome().toUpperCase().equals(nomeArbitro.toUpperCase())) /*verificação de cada cada cadastro na lista com o nome a ser procurado*/
		{
			return i; /*A função retorna o indice do cadastro na lista, caso encontre*/
		}
		else
			return -1;/*retorno para caso não encontre*/
	}
	return 0;
	
	
}


	
}

