package model.SelecaoPackage;

// for reading file data  
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import model.JogadorPackage.JogadorDaoImpl;
import model.PartidaPackage.Partida;
import model.TecnicoPackage.TecnicoDaoImpl;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;


/**
 * A classe <b> SelecaoDaoImpl </b> é responsável pelo CRUD de objetos da classe Árbitro
 * @author Mailson
 *	@since 2022
 */
public class SelecaoDaoImpl implements SelecaoDAO
{
	/**
	 * listaSelecoes é uma lista (ArrayList) que armazena todos os cadastro de Seleção do sistema
	 */
	private ArrayList<Selecao> listaSelecoes;

/**
 * Construtor padrão da classe <b>SelecaoDaoImpl</b>
 */
public SelecaoDaoImpl()
{
	this.listaSelecoes = new ArrayList<Selecao>(); 
}

/**
 * Método para consultar o atributo listaSelecoes
 * @return Arraylist
 */
public ArrayList<Selecao> getListaSelecoes() {
	return listaSelecoes;
}
/**
 * Método para setar a lista listaSelecoes
 */
public void setListaSelecoes(ArrayList<Selecao> listaSelecoes) {
	this.listaSelecoes = listaSelecoes;
}



public void cadastrarNomesDeTodasSelecoes()
{
	TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa

	//String[] grupos = {"A","B","C","D","E","F","G","H"};
	String[] grupos = {"A","B"};
	System.out.println("Cadastro dos grupos:\n");
	for(String grupo:grupos)
	{
		
		for(int i=0; i<4;i++)
		{
			System.out.printf("Digite o nome da selecao %d do grupo %s:\n",(i+1), grupo);
			while(true)
			{
				String nomeSelecao = tratamento.EntradaString();
				if(ComparaSelecao(nomeSelecao))
				{
					Selecao selecao = new Selecao(nomeSelecao, grupo);
					this.listaSelecoes.add(selecao);
					break;
				}
				System.out.println("Essa selecao ja foi cadastrada");
				System.out.println("Tente novamente:");
			}
		}
	}
	
	
}

public void leArquivoSelecoes() throws IOException
{
	FileInputStream stream = new FileInputStream("selecoes.txt");
    InputStreamReader reader = new InputStreamReader(stream);
    BufferedReader br = new BufferedReader(reader);
    String linha = br.readLine();
    String[] grupos = {"A","B","C","D","E","F","G","H"};
    
    while(linha != null) 
    {
    	
    	for(String grupo: grupos)
    	{
	    	for(int i =0; i<4; i++)
	    	{
	    		Selecao selecao = new Selecao(linha, grupo);
				this.listaSelecoes.add(selecao);
		        linha = br.readLine();
		        if(linha == null)
		        	break;
	    	}
    	}
    }
}
/**
 * O método cadastrarSeleção é responsável por cadastrar uma nova Seleção no sistema <br></br>
 * O limite de cadastros é de 32 seleções na copa do mundo
 * @param Partida 
 * @param map 
 */
@Override
public void cadastrarSelecao() {
	
		TratamentosExcecoes tratamento = new TratamentosExcecoes();//Instanciando classe para validar dados de entrada no programa
	
			
		System.out.println("Digite o nome da Selecao que deseja completar o cadastro:");
		
		String nome = tratamento.EntradaString();
		
		int indice = buscaSelecao(nome);
		Selecao selecao = new Selecao();
		if(indice != -1)
		{
			selecao = listaSelecoes.get(indice);
		}
		else
			selecao=null;
		if(selecao != null)
		{
			System.out.println("Concluir o cadastro: \n");
			TecnicoDaoImpl tecnico = new TecnicoDaoImpl();//Instanciando classe responsável pelo CRUD de Técnicos no sistema
			tecnico.setLista(listaSelecoes);//Igualidando a lista de seleções à lista que está dentro da classe técnico para não acessar externamente
			
			selecao.setTecnico(tecnico.cadastrarTecnico());//Chamando método para cadastrar técnico
			System.out.println("Tecnico cadastrado com sucesso!\n");
			
			JogadorDaoImpl jogador= new JogadorDaoImpl(this.listaSelecoes);//Instanciando classe responsável pelo CRUD de Jogadores no sistema
			jogador.cadastrarNaselecao(nome); //Chamando método responsável por cadastrar jogador em determinada seleção
			
			listaSelecoes.set(indice, selecao);
			System.out.println("Selecao cadastrada com sucesso no sistema!");	
		}
		else
			System.out.println("Nemhuma Selecao com esse nome foi cadastrada no sistema");
		
	}
	




/**
 * Essa função verifica se já existe uma Seleção com o mesmo nome no sistema
 * @param nome
 * @return boolean
 */
public boolean ComparaSelecao(String nome) {
	//Percorrendo a lista de seleções
	if(this.listaSelecoes.size()> 1) {
	for(int i=0; i<listaSelecoes.size();i++)
	{
		if(((Selecao) listaSelecoes.get(i)).getNome().toUpperCase().equals(nome.toUpperCase()))
			return false;
	}
	return true;
	}
	return true;
	
}
/**
 * O método editarSeleção é responsável por editar uma Seleção no sistema 
 */
@Override
public void editarSelecao() {
	TratamentosExcecoes tratamento = new TratamentosExcecoes();//Instanciando classe para validar dados de entrada no programa
	if(listaSelecoes.size()>0) //Verificando se há cadastros
	{
		listarSelecao(); //Listando cadastros de Seleções
		
		System.out.println("Digite o nome da selecao que deseja editar: ");
		Scanner entrada = new Scanner(System.in);
		String nomeSelecao = entrada.next(); //Lendo nome da seleção
		int indice = buscaSelecao(nomeSelecao); //Busca o indice na lista do cadastro da seleção digitada
		if(indice != -1)
		{

			System.out.println("1- Editar Nome 2- Voltar");
			int escolha= tratamento.validaInt(1,2);
			switch(escolha)
			{
			case 1:

			
			//Laço para editar o nome da Seleção
			while(true)
			{
				System.out.println("Digite o novo nome da Selecao ");
				String novoNomeSelecao = entrada.next(); //Lendo entrada do novo nome
				if(tratamento.validaNome(novoNomeSelecao))
				{
					if(ComparaSelecao(novoNomeSelecao))//Verifica se Seleção já foi cadastrada
					{
						((Selecao) listaSelecoes.get(indice)).setNome(novoNomeSelecao); //Graavando novo nome no cadastro
						System.out.println("Nome editado com sucesso! ");
						break;
					}
					else
						System.out.println("Essa Selecao ja foi cadastrado no sistema");
				}
				else
					System.out.println("Entrada invalida, tente novamente");
			}
			break; 	
			
			case 2:
			
				break;
				
			
		}
		}
		else
			System.out.println("Selecao nao encontrada");
	}
	else
		System.out.println("Ainda nao foram cadastradas Selecoes no sistema");
}

/**
 * Essa função é responsável por buscar e retornar o indice de um cadastro de seleção
 * @param nomeSelecao
 * @return int
 */
public int buscaSelecao(String nomeSelecao) {
	for(int i=0; i<getListaSelecoes().size();i++) /*Laço para procurar Tecnico nos cadastros*/
	{
		if(( listaSelecoes.get(i)).getNome().toUpperCase().equals(nomeSelecao.toUpperCase())) /*verificação de cada cada cadastro na lista com o nome a ser procurado*/
		{
			return i; /*A função retorna o indice do cadastro na lista, caso encontre*/
		}
		
	}
	return -1;/*retorno para caso não encontre*/
}

/**
 * O método editarSeleção é responsável por apagar uma Seleção no sistema
 */
@Override
public void apagarSelecao()
{
	
	
	if (listaSelecoes.size()> 0) /*Verificação para checar se a lista de Seleções está vazia*/
	{
		listarSelecao();; /*Listar Seleções cadastrados no sistema para o usuário escolher*/
		System.out.println("Digite o nome referente a Selecao que deseja remover do sistema:");
		Scanner entrada = new Scanner(System.in);
		String nomeSelecao = entrada.next();/*Entrada para guardar a entrada referente ao cadastro da Seleção que será excluida*/
		
		int indice = buscaSelecao(nomeSelecao); /*Função para buscar Seleção na lista de cadastros*/
		if(indice != -1) /*caso encontre algum resultado*/
		{
			listaSelecoes.remove(indice); /*Removendo a Seleção da lista de cadastrados pelo indice encontrado na busca*/
			System.out.println("Selecao removida do sistema com sucesso!");
		}
		else
			System.out.println("Selecao não encontrada no sistema.");/*Mensagem de falha na busca*/

	}
	else
		System.out.println("Ainda nao existem Selecoes Cadastrados no sistema");/* Mensagem para caso a lista esteja vazia*/
	}

/**
 * O método listarSelecao é responsável por listar as Seleções no sistema
 */
@Override
public void listarSelecao() {
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
		
	}



}


