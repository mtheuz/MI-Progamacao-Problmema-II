package model.TecnicoPackage;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.SelecaoPackage.Selecao;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

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
	@Override
	public Tecnico cadastrarTecnico() 
	{
		Tecnico tecnico = new Tecnico(); /*Instanciando um novo objeto da classe técnico para o cadastro*/
		TratamentosExcecoes tratamento = new TratamentosExcecoes();//Instanciando classe existe para validar dados de entrada no programa
		
		System.out.println("==== Cadastro do Tecnico ====");
		
		//Laço de repetição para capturar nome do Tecnico (string)
		while(true)
		{
			System.out.println("Digite o nome do tecnico: ");
			Scanner entrada = new Scanner(System.in);
			String nome = entrada.nextLine(); //Lendo a nome
			if (tratamento.validaNome(nome)) //verificando se o nome é válido
				if(ComparaTecnico(nome)) //verificando se já existe um cadastro igual
				{
					tecnico.setNome(nome); //Salvando o nome do Técnico  
					break;
				}
					
				else
					System.out.println("Esse tecnico ja foi cadastrado no sistema");
			else
				System.out.println("Nome invalido, tente novamente");
		}
		//Laço de repetição para capturar nacionalidade do Tecnico (string)
		while(true)
		{
			System.out.println("Digite a nacionalidade do tecnico: ");
			Scanner entrada = new Scanner(System.in);
			String nacionalidade = entrada.nextLine();//Lendo a nacionalidade
			if(tratamento.validaNome(nacionalidade))	//verificando se a entrada de string é válida
			{
				tecnico.setNacionalidade(nacionalidade);//Salvando a nacionalidade
				break;
			}
		}		
		listaTecnicos.add(tecnico);
		return tecnico; //retorna o o objeto para ser inserido na sua respectiva Seleção
	}
	
	/**
	 * O método cadastrarTencicoSemSelecao é responsável por cadastrar um novo técnico para alguma Seleção que esteja sem Técnico no sistema
	 */
	public void cadastrarTecnicoSemSelecao() {
		if(listaSelecoes!= null)
		{
			if( checarSelecoesSemTecnico())
			{
				Tecnico tecnico = new Tecnico(); /*Instanciando um novo objeto da classe técnico para o cadastro*/
				TratamentosExcecoes tratamento = new TratamentosExcecoes();//Instanciando classe existe para validar dados de entrada no programa
				//Laço de repetição para capturar nome do Tecnico (string)
				while(true)
				{
					System.out.println("Digite o nome do tecnico: ");
					Scanner entrada = new Scanner(System.in);
					String nome = tratamento.EntradaString(); //Lendo o nome do Técnico
					if (tratamento.validaNome(nome))//verificando se a entrada de string é válida
						if(ComparaTecnico(nome))//verificando se já existe um cadastro igual
						{
							tecnico.setNome(nome);//Salvando o nome do Técnico
							break;
						}
							
						else
							System.out.println("Esse tecnico ja foi cadastrado no sistema");
					else
						System.out.println("Nome invalido, tente novamente");
				}
				//Laço de repetição para ler a nacionalidade do Tecnico (string)
				while(true)
				{
					System.out.println("Digite a nacionalidade do tecnico: ");
					Scanner entrada = new Scanner(System.in);
					String nacionalidade = tratamento.EntradaString();//Lendo a nacionalidade
					if(tratamento.validaNome(nacionalidade))	//verificando se a entrada de string é válida
					{
						tecnico.setNacionalidade(nacionalidade);//Salvando a nacionalidade
						break;
					}
				}		
				
				//Achando a seleção sem técnico para adicionar o técnico
				System.out.println("Para qual Selecao deseja cadastrar este Tecnico?");
				listarTecnico();
				
				while(true)
				{
					System.out.println("Digite o NOME da Selecao que em deseja cadastrar:");
					Scanner nomeSelecao = new Scanner(System.in);
					String nome = tratamento.EntradaString(); //Lendo o nome de uma seleção
					int teste =0; //Essa variavel auxilia em caso de erro de busca
					if(tratamento.validaNome(nome))//verificando se a entrada de string é válida
					{
						for(int i=0; i<listaSelecoes.size();i++)  //Laço para localizar a seleção pesquisada e verificar se ela está sem Tecnico
						{
							if(((Selecao) listaSelecoes.get(i)).getNome().equals(nome) && ((Selecao) listaSelecoes.get(i)).getTecnico().getNome().equals("Sem Tecnico"))
							{
								((Selecao)listaSelecoes.get(i)).setTecnico(tecnico); //Salvando o técnico no cadastro da seleção
								System.out.println("Tecnico adicionado com sucesso!");
								teste =1; //Atualiza para sair do while true
								break; //Saindo do For
							}
						}
						if (teste == 0)//Caso de erro de busca
						{
							System.out.println("Algo deu errado, tente novamente");
						}
						break;
					}
					else
						System.out.println("Entrada invalida, tente novamente");
				}
				
			}
			else
				System.out.println("Nenhuma selecao esta sem tecnico no sistema");
		}
		else
			System.out.println("Nenhuma selecao foi ainda foi cadastrada no sistema");
	
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
		TratamentosExcecoes tratamento = new TratamentosExcecoes();//Instanciando classe existe para validar dados de entrada no programa
		
		listarTecnico(); //Listando os cadastros
		
		if(listaSelecoes!= null) //Caso a lista não estiver vazia
		{
			String nomeTecnico;
			while(true)
			{
				System.out.println("Digite o nome do Tecnico que deseja editar:");
				Scanner entrada = new Scanner(System.in); 
				nomeTecnico = entrada.next();/*Entrada para guardar a entrada referente ao cadastro do arbitro que será excluido*/
				if(tratamento.validaNome(nomeTecnico))//verificando se a entrada de string é válida
					break;
			}
			int indice = buscaTecnico( nomeTecnico);/*Função para buscar Tecnico na lista de cadastros*/
			if(indice != -1)/*caso encontre algum resultado*/
			{
				System.out.println("1- Editar Nome 2- Editar Nacionalidade");
				int escolha = tratamento.validaInt(1,2); //Lendo entrada e validando
				if(escolha==1)
				{
					while(true) //Laço para editar o nome do técnico localizado
					{
					System.out.println("Digite o novo nome do Tecnico");
					Scanner NovonomeTecnico = new Scanner(System.in); 
					String nome = NovonomeTecnico.nextLine();/*Entrada para guardar a entrada referente ao novo nome do arbitro localizado*/
					if(tratamento.validaNome(nome))//verificando se a entrada de string é válida
					{
						if(ComparaTecnico(nome))//Verificando se já existe algum técnico com esse nome
					
						{
							((Selecao) listaSelecoes.get(indice)).getTecnico().setNome(nome); /*metodo setter para definir novo nome do cadastro no campo nome do objeto*/
							System.out.println("Nome do Tecnico atualizado com sucesso!");
							break;
						}
						else
							System.out.println("Ja existe um Tecnico cadastrado com esse nome");
					}
					else
						System.out.println("Entrada invalida, tente novamente");
					}
					
				}
				else if(escolha == 2)
				{
					while(true)
					{
					System.out.println("Digite a nacionalidade do Tecnico");
					Scanner entrada = new Scanner(System.in); 
					String nacionalidadeTec = entrada.next();/*Entrada para guardar a entrada referente ao novo nome do arbitro localizado*/
					if(tratamento.validaNome(nacionalidadeTec))
					{
						
						((Selecao) listaSelecoes.get(indice)).getTecnico().setNacionalidade(nacionalidadeTec); /*metodo setter para definir novo nome do cadastro no campo nome do objeto*/
						System.out.println("Nacionalidade do Tecnico atualizado com sucesso!");
						break;
					}
					
					
					else
						
						System.out.println("Entrada invalida, tente novamente");
				}
					

			}
			else
				System.out.println("Técnico não encontrado");
		}
		else
			System.out.println("Ainda nao foram cadastradas selecoes no sistema");
		}
	}
	/**
	 * Função para localizar um cadastro de um técnico na lista e devolver o indice
	 * @param nomeTecnico
	 * @return
	 */
	private int buscaTecnico(String nomeTecnico) 
	{
		
		for(int i=0; i<listaSelecoes.size();i++) /*Laço para procurar Tecnico nos cadastros*/
		{
			if(((Selecao) listaSelecoes.get(i)).getTecnico().getNome().toUpperCase().equals(nomeTecnico.toUpperCase())) /*verificação de cada cada cadastro na lista com o nome a ser procurado*/
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
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		if(listaSelecoes!=null)
		{
			listarTecnico();
			String nomeTecnico;
			while(true)
			{
				System.out.println("Digite o nome do Tecnico que deseja remover do sistema:");
				Scanner entrada = new Scanner(System.in); 
				nomeTecnico = entrada.next();/*Entrada para guardar a entrada referente ao cadastro do arbitro que será excluido*/
				if(tratamento.validaNome(nomeTecnico))
					break;
			}
			int indice = buscaTecnico(nomeTecnico);/*Função para buscar Tecnico na lista de cadastros*/
			if(indice != -1)/*caso encontre algum resultado*/
			{
				Tecnico tecnico = new Tecnico();
				((Selecao) listaSelecoes.get(indice)).setTecnico(tecnico);
				System.out.println("Tecnico removido do sistema com sucesso!");
				
			}
			else
				System.out.println("Tecnico nao encontrado");
		
		}
		else
			System.out.println("Ainda nao foram cadastradas selecoes no sistema");
		
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

	


	