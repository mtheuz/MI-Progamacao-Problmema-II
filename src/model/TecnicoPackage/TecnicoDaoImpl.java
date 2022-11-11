package model.TecnicoPackage;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.SelecaoPackage.Selecao;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;
import view.TecnicoView;

/**
 *  A classe <b> TecnicoDaoImpl </b> é responsável pelo CRUD de objetos da classe Árbitro
 *	@author Mailson
 *	@since 2022
 */
public class TecnicoDaoImpl implements TecnicoDAO 
{
	/**
	 * O atributo lsita é uma copia da lista de seleções
	 */
	static ArrayList<Selecao> listaSelecoes; /*Esse atributo é uma copia da lista de seleções*/
	
	private ArrayList<Tecnico> listaTecnicos;
	
	public ArrayList<Tecnico> getListaTecnicos() {
		return listaTecnicos; 
	
	}
	public void setListaTecnicos(ArrayList<Tecnico> listaTecnicos) {
		this.listaTecnicos = listaTecnicos;
	
	}
	/**
	 * Método que retorna a lista de Seleções
	 * @return arrraylist
	 */
	public ArrayList<Selecao> getListaSeleoes() {
		return listaSelecoes;
	}
	/**
	 * Método que define a lista de Seleções no campo TecnincoDaoImpl.lista
	 * @param lista
	 */
	public void setLista(ArrayList<Selecao> listaSelecoes) {
		this.listaSelecoes = listaSelecoes;
	}	
	
	/**
	 * O método cadastrarTencico é responsável por cadastrar um novo técnico no sistema
	 */
	public TecnicoDaoImpl()
	{
		this.listaTecnicos = new ArrayList<Tecnico>(); 
	}
	/**
	 * O método cadastrarTecnico mostra as opções chamando a view para cadastrar um novo técnico
	 * return Tecnico
	 */
	@Override
	public Tecnico cadastrarTecnico() 
	{
		TecnicoView tecnicoView = new TecnicoView();
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		Tecnico tecnico = new Tecnico(); /*Instanciando um novo objeto da classe técnico para o cadastro*/
		
		tecnicoView.mostrar("==== Cadastro do Tecnico ====");
		
		
		//Laço de repetição para capturar nome do Tecnico (string)
		while(true)
		{
			tecnicoView.mostrar("Digite o nome do tecnico: ");
			Scanner entrada = new Scanner(System.in);
			String nome =tecnicoView.inputStr();
			 
			if (tratamento.validaNome(nome)) //verificando se o nome é válido
				if(ComparaTecnico(nome)) //verificando se já existe um cadastro igual
				{
					tecnico.setNome(nome); //Salvando o nome do Técnico  
					break; 
				}
					
				else
					tecnicoView.mostrar("Esse tecnico ja foi cadastrado no sistema");
			else
				tecnicoView.mostrar("Nome invalido, tente novamente");
		} 
		//Laço de repetição para capturar nacionalidade do Tecnico (string)
		while(true)
		{
			tecnicoView.mostrar("Digite a nacionalidade do tecnico: ");
			
			String nacionalidade = tecnicoView.inputStr();//Lendo a nacionalidade
			if(tratamento.validaNome(nacionalidade))	//verificando se a entrada de string é válida
			{
				tecnico.setNacionalidade(nacionalidade);//Salvando a nacionalidade
				break;
			}
		}		
		cadastrarTecnico(tecnico);
		return tecnico; //retorna o o objeto para ser inserido na sua respectiva Seleção
	}
	/**
	 * Essa função cadastra um técnico na lista de técnicos
	 * @param tecnico
	 */
	public void cadastrarTecnico(Tecnico tecnico) {
		listaTecnicos.add(tecnico);
		
	}
	/**
	 * O método cadastrarTencicoSemSelecao é responsável por cadastrar um novo técnico para alguma Seleção que esteja sem Técnico no sistema
	 */
	public void cadastrarTecnicoSemSelecao() {
		TecnicoView tecnicoView = new TecnicoView();
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		if(listaSelecoes!= null)
		{
			if( checarSelecoesSemTecnico())
			{
				Tecnico tecnico = new Tecnico(); /*Instanciando um novo objeto da classe técnico para o cadastro*/
				
				//Laço de repetição para capturar nome do Tecnico (string)
				while(true)
				{
					tecnicoView.mostrar("Digite o nome do tecnico: ");
					
					String nome = tecnicoView.inputStr(); //Lendo o nome do Técnico
					
					if (tratamento.validaNome(nome))//verificando se a entrada de string é válida
						if(ComparaTecnico(nome))//verificando se já existe um cadastro igual
						{ 
							tecnico.setNome(nome);//Salvando o nome do Técnico
							break;
						}
							
						else
							tecnicoView.mostrar("Esse tecnico ja foi cadastrado no sistema");
					else
						tecnicoView.mostrar("Nome invalido, tente novamente");
				}
				//Laço de repetição para ler a nacionalidade do Tecnico (string)
				while(true)
				{
					tecnicoView.mostrar("Digite a nacionalidade do tecnico: ");
					
					String nacionalidade = tecnicoView.inputStr();//Lendo a nacionalidade
					if(tratamento.validaNome(nacionalidade))	//verificando se a entrada de string é válida
					{
						tecnico.setNacionalidade(nacionalidade);//Salvando a nacionalidade
						break;
					}
				}		
				
				//Achando a seleção sem técnico para adicionar o técnico
				tecnicoView.mostrar("Para qual Selecao deseja cadastrar este Tecnico?");
				listarTecnico();
				
				while(true)
				{
					tecnicoView.mostrar("Digite o NOME da Selecao em que deseja cadastrar:");
					
					String nomeSelecao = tecnicoView.inputStr(); //Lendo o nome de uma seleção
					int teste =0; //Essa variavel auxilia em caso de erro de busca
					if(tratamento.validaNome(nomeSelecao))//verificando se a entrada de string é válida
					{
						for(int i=0; i<listaSelecoes.size();i++)  //Laço para localizar a seleção pesquisada e verificar se ela está sem Tecnico
						{
							if(((Selecao) listaSelecoes.get(i)).getNome().equals(nomeSelecao) && ((Selecao) listaSelecoes.get(i)).getTecnico().getNome().equals("Sem Tecnico"))
							{
								substituirTecnicoVazio(i, tecnico);
								((Selecao)listaSelecoes.get(i)).setTecnico(tecnico); //Salvando o técnico no cadastro da seleção
								tecnicoView.mostrar("Tecnico adicionado com sucesso!");
								teste =1; //Atualiza para sair do while true
								break; //Saindo do For
							}
						}
						if (teste == 0)//Caso de erro de busca
						{
							tecnicoView.mostrar("Algo deu errado, tente novamente");
						}
						break;
					}
					else
						tecnicoView.mostrar("Entrada invalida, tente novamente");
				}
				
				
			}
			else
				tecnicoView.mostrar("Nenhuma selecao esta sem tecnico no sistema");
		}
		else
			tecnicoView.mostrar("Nenhuma selecao foi ainda foi cadastrada no sistema");
	
	}

	/**
	 * Essa função altera um tecnico de uma selecao que esteja sem tecnico no sistema
	 * @param i
	 * @param tecnico
	 */
	public void substituirTecnicoVazio(int i, Tecnico tecnico) {
		((Selecao)listaSelecoes.get(i)).setTecnico(tecnico); //Salvando o técnico no cadastro da seleção
		
	}
	/**
	 * Essa função altera um tecnico de uma selecao que esteja sem tecnico na lita de técnicos
	 * @param i
	 * @param tecnico
	 */
	public void substituirTecnicoVazioNaListaTecnicos(int i, Tecnico tecnico) {
		listaTecnicos.set(i, tecnico);
		
	}
	/**
	 * Essa função checa se existe alguma seleção que esteja sem técnico no sistema
	 * Se algum cadastro tiver um nome igual ao que está sendo cadastro, a função retorna verdadeiro (True), senão, retorna falso (false)
	 * @return boolean
	 */
	private boolean checarSelecoesSemTecnico() {
		//Laço para percorrer os cadastros de técnicos
		for(int i=0; i<listaSelecoes.size();i++) 
		{
			//Verificando se alguma seleção está sem Técnico
			if(((Selecao) listaSelecoes.get(i)).getTecnico().getNome().equals("Sem Tecnico"));
				return true;
		}
		
		return false;
	}
	
	/**
	 * O método editarTecnico é responsável por editar um cadastro de técnico no sistema
	 * @return Void
	 */
	@Override
	public void editarTecnico() 
	{
		TecnicoView tecnicoView = new TecnicoView();
		TratamentosExcecoes tratamento = new TratamentosExcecoes();//Instanciando classe existe para validar dados de entrada no programa
		
		listarTecnico(); //Listando os cadastros
		
		if(listaSelecoes!= null) //Caso a lista não estiver vazia
		{
			String nomeTecnico;
			while(true)
			{
				tecnicoView.mostrar("Digite o NOME do Tecnico que deseja editar:");
				
				nomeTecnico = tecnicoView.inputStr();/*Entrada para guardar a entrada referente ao cadastro do arbitro que será excluido*/
				if(tratamento.validaNome(nomeTecnico))//verificando se a entrada de string é válida
					break;
			}
			int indice = buscaTecnico(nomeTecnico);/*Função para buscar Tecnico na lista de cadastros*/
			if(indice != -1)/*caso encontre algum resultado*/
			{
				tecnicoView.mostrar("1- Editar Nome 2- Editar Nacionalidade");
				int escolha = tecnicoView.inputInt(1, 2); //Lendo entrada e validando
				if(escolha==1)
				{
					while(true) //Laço para editar o nome do técnico localizado
					{
					tecnicoView.mostrar("Digite o novo nome do Tecnico");
					
					String nome = tecnicoView.inputStr();/*Entrada para guardar a entrada referente ao novo nome do arbitro localizado*/
					if(tratamento.validaNome(nome))//verificando se a entrada de string é válida
					{
						if(ComparaTecnico(nome))//Verificando se já existe algum técnico com esse nome
					
						{
							((Selecao) listaSelecoes.get(indice)).getTecnico().setNome(nome); /*metodo setter para definir novo nome do cadastro no campo nome do objeto*/
							tecnicoView.mostrar("Nome do Tecnico atualizado com sucesso!");
							break;
						}
						else
							tecnicoView.mostrar("Ja existe um Tecnico cadastrado com esse nome");
					}
					else
						tecnicoView.mostrar("Entrada invalida, tente novamente");
					}
					
				}
				else if(escolha == 2)
				{
					while(true)
					{
					tecnicoView.mostrar("Digite a nacionalidade do Tecnico");
					
					String nacionalidadeTec = tecnicoView.inputStr();/*Entrada para guardar a entrada referente ao novo nome do arbitro localizado*/
					if(tratamento.validaNome(nacionalidadeTec))
					{
						
						((Selecao) listaSelecoes.get(indice)).getTecnico().setNacionalidade(nacionalidadeTec); /*metodo setter para definir novo nome do cadastro no campo nome do objeto*/
						tecnicoView.mostrar("Nacionalidade do Tecnico atualizado com sucesso!");
						break;
					}
					
					
					else
						
						tecnicoView.mostrar("Entrada invalida, tente novamente");
				}
					

			}
			else
				tecnicoView.mostrar("Técnico não encontrado");
		}
		else
			tecnicoView.mostrar("Ainda nao foram cadastradas selecoes no sistema");
		}
	}
	/**
	 * Função para localizar um cadastro de um técnico na lista e devolver o indice
	 * @param nomeTecnico
	 * @return
	 */
	public int buscaTecnico(String nomeTecnico) 
	{
		
		for(int i=0; i<listaSelecoes.size();i++) /*Laço para procurar Tecnico nos cadastros*/
		{
			if(listaSelecoes.get(i).getTecnico().getNome().toUpperCase().equals(nomeTecnico.toUpperCase())) /*verificação de cada cada cadastro na lista com o nome a ser procurado*/
			{
				return i; /*A função retorna o indice do cadastro na lista, caso encontre*/
			}
			
		}
		return -1;/*retorno para caso não encontre*/ 
		
			
		
	}
	/**
	 * Essa função busca um técnico na lista através do nome
	 * @param nomeTecnico
	 * @return
	 */
	public int buscaTecnicoListaTecnicos(String nomeTecnico) 
	{
		
		for(int i=0; i<listaTecnicos.size();i++) /*Laço para procurar Tecnico nos cadastros*/
		{
			if(listaTecnicos.get(i).getNome().toUpperCase().equals(nomeTecnico.toUpperCase())) /*verificação de cada cada cadastro na lista com o nome a ser procurado*/
			{
				return i; /*A função retorna o indice do cadastro na lista, caso encontre*/
			}
			
		}
		return -1;/*retorno para caso não encontre*/ 
		
			
		
	}
	/**
	 * O método apagarTecnico é responsável por apagar um cadastro de técnico no sistema
	 * @return Void
	 */
	@Override
	public void apagarTecnico() {
		TecnicoView tecnicoView = new TecnicoView();
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		if(listaSelecoes!=null)
		{
			listarTecnico();
			String nomeTecnico;
			while(true)
			{
				tecnicoView.mostrar("Digite o Nome do Tecnico que deseja remover do sistema:");
				
				nomeTecnico = tecnicoView.inputStr();/*Entrada para guardar a entrada referente ao cadastro do arbitro que será excluido*/
				if(tratamento.validaNome(nomeTecnico))
					break;
			}
			int indice = buscaTecnico(nomeTecnico);/*Função para buscar Tecnico na lista de cadastros*/
			if(indice != -1)/*caso encontre algum resultado*/
			{
				removerTecnico(nomeTecnico,indice);
				tecnicoView.mostrar("Tecnico removido do sistema com sucesso!");
				
			}
			else
				tecnicoView.mostrar("Tecnico nao encontrado");
		
		}
		else
			tecnicoView.mostrar("Ainda nao foram cadastradas selecoes no sistema");
		
	}
	/**
	 * Essa função remove um técnico da lista de técnicos
	 * @param nome
	 * @param indice
	 */
	public void removerTecnico(String nome, int indice) {
		Tecnico tecnico = new Tecnico();
		int indice2 = buscaTecnicoListaTecnicos(nome);
		try
		{
			((Selecao) listaSelecoes.get(indice)).setTecnico(tecnico);
			if(indice2 !=-1)
				listaTecnicos.set(indice2, tecnico);
		}
		catch(Exception e)
		{
			if(indice2 !=-1)
				listaTecnicos.set(indice, tecnico);
	
		}
	}
	/**
	 * O método listarTecnico é responsável por listar os cadastros de técnicos no sistema
	 * @return Void
	 */
	@Override
	public void listarTecnico() 
	{
		if(listaSelecoes!= null)
		{	
			System.out.println("Lista de Tecnicos:");
			System.out.println();
			for(int i=0; i< listaSelecoes.size(); i++)
			{
				System.out.println("["+(i)+"]"+((Selecao) listaSelecoes.get(i)).getNome()+ " : " +((Selecao) listaSelecoes.get(i)).getTecnico().getNome()  );
			}
			System.out.println();
		return;
		}
		else
			System.out.println("Ainda nao foram cadastradas Selecoes no sistema, portanto nemhum cadastro de Tecnico foi encotrado");
	}
	/**
	 * Função para verificar se já existe o cadastro de Técnico com mesmo nome no sistema
	 * @param nome
	 * @return
	 */
	private boolean ComparaTecnico(String nome) {
		if(listaTecnicos == null)
			return true;
		for(int i=0; i<listaTecnicos.size();i++)
		{
			if(((Tecnico) listaTecnicos.get(i)).getNome().toUpperCase().equals(nome.toUpperCase()))
				return false;
		}
		return true;
	}
	



	
}

	


	