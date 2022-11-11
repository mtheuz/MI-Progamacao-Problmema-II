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
import model.PartidaPackage.PartidaDaoImpl;
import model.TecnicoPackage.TecnicoDaoImpl;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;
import view.SelecaoView;


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


/**
 * O método CadastrarNomeDeTodasSelecoes cadastra apenas o nome das seleções na parte inicial do programa
 */
public void cadastrarNomesDeTodasSelecoes()
{
	TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
	SelecaoView selecaoView = new SelecaoView();
	String[] grupos = {"A","B","C","D","E","F","G","H"};
	selecaoView.mostrar("Cadastro dos grupos:\n");
	int indice =0;
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
					cadastrarSelecao(selecao); 
					indice++;
					break;
				}
				selecaoView.mostrar("Essa selecao ja foi cadastrada");
				selecaoView.mostrar("Tente novamente:");
			}
		}
	}
	
	
}
/**
 * O método leArquivoSelecoes lê as selecoes do arquivo txt para gerar cadastros pré definidos de seleções
 * @throws IOException
 */
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
 * @param Str 
 */
@Override
public void procedimentoCadastrarSelecao(String nome) {
		SelecaoView selecaoView = new SelecaoView();
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
			selecaoView.mostrar("Concluir o cadastro: \n");
			TecnicoDaoImpl tecnico = new TecnicoDaoImpl();//Instanciando classe responsável pelo CRUD de Técnicos no sistema
			tecnico.setLista(listaSelecoes);//Igualidando a lista de seleções à lista que está dentro da classe técnico para não acessar externamente
			
			selecao.setTecnico(tecnico.cadastrarTecnico());//Chamando método para cadastrar técnico
			selecaoView.mostrar("Tecnico cadastrado com sucesso!\n");
			
			JogadorDaoImpl jogador= new JogadorDaoImpl(this.listaSelecoes);//Instanciando classe responsável pelo CRUD de Jogadores no sistema
			jogador.cadastrarNaselecao(nome); //Chamando método responsável por cadastrar jogador em determinada seleção
			
			this.listaSelecoes.set(indice, selecao);
			selecaoView.mostrar("Selecao cadastrada com sucesso no sistema!");
		}
		else
			selecaoView.mostrar("Nemhuma Selecao com esse nome foi cadastrada no sistema");
		
	}
	 



/**
 * A função cadastrar Selecao insere uma nova seleção na lista de Selecoes.
 * @param selecao
 * @param indice
 */
public void cadastrarSelecao(Selecao selecao) {
	 
	this.listaSelecoes.add(selecao);
	
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
 * O método ProcedimentoditarSeleção é responsável por editar uma Seleção no sistema 
 * @param partidas 
 */
@Override
public void ProcedimentoEditarSelecao(PartidaDaoImpl partidas) {
	TratamentosExcecoes tratamento = new TratamentosExcecoes();//Instanciando classe para validar dados de entrada no programa
	SelecaoView selecaoView = new SelecaoView();
	if(listaSelecoes.size()>0) //Verificando se há cadastros
	{
		listarSelecao(); //Listando cadastros de Seleções
		
		selecaoView.mostrar("Digite o NOME da selecao que deseja editar: ");
		String nomeSelecao = tratamento.EntradaString(); //Lendo nome da seleção
		int indice = buscaSelecao(nomeSelecao); //Busca o indice na lista do cadastro da seleção digitada
		if(indice != -1)
		{

			selecaoView.mostrar("1- Editar Nome 2- Voltar");
			int escolha= selecaoView.inputInt();
			switch(escolha) 
			{
			case 1:

			
			//Laço para editar o nome da Seleção
			while(true)
			{
				selecaoView.mostrar("Digite o novo nome da Selecao ");
				String novoNomeSelecao = selecaoView.inputStr();
				if(tratamento.validaNome(novoNomeSelecao))
				{
					if(ComparaSelecao(novoNomeSelecao))//Verifica se Seleção já foi cadastrada
					{
						editarSelecao(novoNomeSelecao, indice);
						selecaoView.mostrar("Nome editado com sucesso! ");
						atualizarSelecaoNoGrupo(nomeSelecao,novoNomeSelecao, partidas);
						break;
					}
					else
						selecaoView.mostrar("Essa Selecao ja foi cadastrado no sistema");
				}
				else
					selecaoView.mostrar("Entrada invalida, tente novamente");
			}
			break; 	
			
			case 2:
			
				break;
				 
			
		}
		}
		else
			selecaoView.mostrar("Selecao nao encontrada");
	}
	else
		selecaoView.mostrar("Ainda nao foram cadastradas Selecoes no sistema");
}
/**
 * A função editarSelecao edita o nome de um objeto seleção na lista de seleções
 * @param novoNomeSelecao
 * @param indice
 */
public void editarSelecao(String novoNomeSelecao, int indice) {
	((Selecao) listaSelecoes.get(indice)).setNome(novoNomeSelecao); //Graavando novo nome no cadastro
	
}


/**
 * A função atualizar SelecaoNoGrupo atualiza as partidas que já foram geradas com o novo nome da seleção editada
 * @param nome
 * @param novoNomeSelecao
 * @param partidas
 */
private void atualizarSelecaoNoGrupo(String nome,String novoNomeSelecao, PartidaDaoImpl partidas) {
	Map<String,List<Partida>> partidass = partidas.getPartidas();
	for(Entry<String, List<Partida>> grupo: partidass.entrySet())
	{
		for(Partida partida: grupo.getValue())
		{
			if(partida.getSelecao1().equals(nome))
			{
				partida.setSelecao1(novoNomeSelecao);
			}
			else if(partida.getSelecao2().equals(nome))
			{
				partida.setSelecao2(novoNomeSelecao);
			}
		}
	}
	
}

/**
 * Essa função é responsável por buscar e retornar o indice de um cadastro de seleção
 * @param nomeSelecao
 * @return int
 */
public int buscaSelecao(String nomeSelecao) {

	for(int i=0; i<this.listaSelecoes.size();i++) /*Laço para procurar Tecnico nos cadastros*/
	{
		if(( this.listaSelecoes.get(i)).getNome().toUpperCase().equals(nomeSelecao.toUpperCase())) /*verificação de cada cada cadastro na lista com o nome a ser procurado*/
		{
			return i; /*A função retorna o indice do cadastro na lista, caso encontre*/
		}
		
	}
	return -1;/*retorno para caso não encontre*/
}



/**
 * O método listarSelecao é responsável por listar as Seleções no sistema
 */
@Override
public void listarSelecao() {
	SelecaoView selecaoView = new SelecaoView();
	if(listaSelecoes.size()>0)
	{
		
		selecaoView.mostrar("Lista de Selecoes:");
		//Percorrendo a lista de cadastros
		for(int i=0; i< listaSelecoes.size(); i++)
		{
			System.out.println("["+(i)+"]"+((Selecao) listaSelecoes.get(i)).getNome()); // Imprimindo o nome da Seleção
		}
		System.out.println();
		 
	}
	else
		selecaoView.mostrar("Ainda nao foram cadastradas Selecoes no sistema");
		
	}

 

}


