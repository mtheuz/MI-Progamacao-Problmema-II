package model.JogadorPackage;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.SelecaoPackage.Selecao;
import model.SelecaoPackage.SelecaoDaoImpl;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;
/**
 *  A classe <b> JogadorDaoImpl </b> é responsável pelo CRUD de objetos da classe Árbitro
 * @author Mailson
 *	@since 2022
 */
public class JogadorDaoImpl implements JogadorDAO{
	
	SelecaoDaoImpl selecao = new SelecaoDaoImpl();
	private Map<String,String> posicoes;
	/**
	 * Construtor padrão da classe <b> JogadorDaoImpl </b>
	 * @param selecoes
	 */
	public JogadorDaoImpl(ArrayList<Selecao> selecoes) {
		this.posicoes = new HashMap<String,String>();
		selecao.setListaSelecoes(selecoes);
		posicoes.put("GK","Goleiro");
		posicoes.put("CB","Zagueiro");
		posicoes.put("RB","Lateral Direito");
		posicoes.put("LB","Lateral Esquerdo");
		posicoes.put("CDM","Volante");
		posicoes.put("CM","Meio Campista"); 
		posicoes.put("ST","Atacante");
	}
	
	/**
	 * O método cadastrar é responsável por cadastrar a quantidade desejada de jogadores em uma Seleção no sistema
	 */
	public void cadastrar(String nomeJoagador,String nomeDaSelecao) {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		Scanner entrada = new Scanner(System.in);

		//boolean listar = selecao.listarSelecao();
		String selecaoInput = "";
		int quantidadeJogadores = 0;
	
		if(selecao.getListaSelecoes().size()> 0) {
		//selecao.listarSelecao();
		//System.out.println("Digite o indice da Selecao que deseja inserir o jogador");
		//int selecaobusca = entrada.nextInt();
		selecaoInput = nomeDaSelecao;
		//System.out.println("Digite a quantidade de jogadores que deseja cadastrar");
		//quantidadeJogadores = entrada.nextInt();
		}
		//verifica se já existe selecao escolhida
		if(nomeDaSelecao != null) {
		if(!selecao.ComparaSelecao(selecaoInput)) { 
				
				//System.out.println("Digite o nome do Jogador: ");
				String nome = nomeJoagador;
				
				//listarPosicoes();
				//String pos = entrada.next();
				//pos = posicoes.get(pos.toUpperCase());
				//cria o objeto jogador
				Jogador novoJogador = new Jogador(nome); 
				inserirJogador(novoJogador,selecaoInput); 
				
		}
		}
		else {
			System.out.println("Ainda nao foram cadastradas Selecoes no sistema");
		}
	}
	

	/**
	 * O método inserirJogador é responsável por inserir o Jogador na lista de jogadores
	 */

	public void cadastrarNaselecao(String nomeSelecao) {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de jogadores que deseja cadastrar");
		int quantidadeJogadores = tratamento.validaInt();
		if(quantidadeJogadores<=26)
		{
			//verifica se já existe selecao escolhida
				for (int i = 0; i < quantidadeJogadores; i++) {
					System.out.println("==== Cadastro de Jogador ====");
					System.out.println("Digite o nome do Jogador: ");
					String nome = entrada.next();
					
					listarPosicoes();
					//String pos = entrada.next();
					//pos = posicoes.get(pos.toUpperCase());
					//cria o objeto jogador
					Jogador novoJogador = new Jogador(nome); 
					
					//insere na lista de jogadores na seleçao
					inserirJogador(novoJogador,nomeSelecao); 
				}
	}
		else
		System.out.println("Quantidade superior ao permitido para uma selecao na copa (22 jogadores)");
	}
	//Insere o Jogador na lista de jogadores 

	@Override
	public boolean inserirJogador(Jogador jogador, String nomeSelecao) {
		final int numeroTotalDeJogadores = 26;
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		try
		{
			if( listaJogadores == null || listaJogadores.size() < numeroTotalDeJogadores) {
				//Verifica se o jogador já foi cadastrado
				if(comparaJogador(jogador,nomeSelecao))
					System.out.println("Esse jogador já foi cadastrado");
				else {
					jogador.setCode(geraid(jogador));
					selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores().add(jogador);
					
				}
			}else
				return false;
		}
		catch(Exception erro)
		{
			jogador.setCode(geraid(jogador));
			selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores().add(jogador);
			
		}
		//System.out.println("Jogador inserido na base de dados seu codigo e "+ jogador.getCode());
		return true;
		
	}
	
	/**
	 * O método deletarJogador é responsável por excluir o jogador da lista de jogadores
	 */
	@Override
	public boolean deletarJogador(String codigo,String selecaoBusca) {
		int index = buscarJogador(codigo);
		int Busca = selecao.buscaSelecao(selecaoBusca);
		if(Busca != -1) {
			if(index !=1) {
			selecao.getListaSelecoes().get(Busca).getListaJogadores().remove(index);
			System.out.println("Jogador deletado com sucesso!\n");
			return true;
			}
		}
			System.out.println("Esse jogador ainda nao foi cadastrado!\n");
			return false;
		
	}

	/**
	 * O método atualizarDadosJogador é responsável por editar um jogador da lista de jogadores
	 */


	
	public boolean atualizarPosicao(String codigo, String nomeSelecao, String alteracao) {
		int index = buscarJogador(codigo); 
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		for(Map.Entry<String, String> pos: posicoes.entrySet()){
			if(alteracao.equals(pos.getValue())) {
				listaJogadores.get(index).setPosicao(alteracao);
				imprimirJogador(codigo);
				System.out.println("O jogador foi atualizado na base dados!");
				return true;
			}else {
				System.out.println("Valor digitado invalido");
				
				}
			}
		return false;
		}
	
	public boolean atualizarNome(String codigo, String nomeSelecao, String alteracao) {
		int index = buscarJogador(codigo); 
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		listaJogadores.get(index).setNome(alteracao);
		imprimirJogador(codigo);
		System.out.println("O jogador foi atualizado na base dados!");
		return true;
	}
	
	public boolean atulizarCartoesAmarelos(String codigo, String nomeSelecao, String alteracao) {
		int index = buscarJogador(codigo); 
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		if(listaJogadores.get(index).getCartoesAmarelos() != 0) {
			
			listaJogadores.get(index).setCartoesAmarelos(Integer.parseInt(alteracao));
			imprimirJogador(codigo);
			System.out.println("O jogador foi atualizado na base dados!");
			return true;
		}
		else {
			System.out.println("Esse jogador nao possui cartao amarelo");
			return false;
		}
	}
	
	public boolean atualizarCartoesVermelhos(String codigo, String nomeSelecao, String alteracao) {
		int index = buscarJogador(codigo); 
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		if(listaJogadores.get(index).getCartoesVermelhos() != 0) {
			listaJogadores.get(index).setCartoesVermelhos(Integer.parseInt(alteracao));
			imprimirJogador(codigo);
			System.out.println("O jogador foi atualizado na base dados!");
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean atualizarGolsMarcados(String codigo, String nomeSelecao, String alteracao) {
		int index = buscarJogador(codigo); 
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		if(listaJogadores.get(index).getGolsMarcados() != 0) {
			listaJogadores.get(index).setGolsMarcados(Integer.parseInt(alteracao));
			imprimirJogador(codigo);
			System.out.println("O jogador foi atualizado na base dados!");
			return true;
		}
		else {
			return false;
	}
		}
	

	/**
	 * A função gerarid gera um id para ser usado como codigo no cadastro de jogador
	 * O id é gerado pela data e hora do cadastro
	 * @param jogador
	 * @return String
	 */

	//Gera o id do jogador com base na data

	private String geraid(Jogador jogador) {
		LocalDateTime dataagr = LocalDateTime.now();
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyHHmmss");
	    String coddate = dataagr.format(formato);
		return coddate;
	}
	


	/**
	 * Essa função busca e retorna o índice um cadastro de um jogador na lista
	 * @param codigo
	 * @return int
	 */


	private int buscarJogador(String codigo) {
		final List<Selecao> listaSelecao = selecao.getListaSelecoes();
		for(int index = 0; index < listaSelecao.size();index++) {
			var listaJogador = listaSelecao.get(index).getListaJogadores();
			for (int ijogador = 0; ijogador < listaJogador.size(); ijogador++) {
				if(listaJogador.get(ijogador).getCode().equals(codigo)) {
					return ijogador;
				}
				
			}
		
	}
		return -1;
	}
	
	public boolean verificaExistencia(String codigo) {
		final List<Selecao> listaSelecao = selecao.getListaSelecoes();
		for(int index = 0; index < listaSelecao.size();index++) {
			var listaJogador = listaSelecao.get(index).getListaJogadores();
			for (int ijogador = 0; ijogador < listaJogador.size(); ijogador++) {
				if(listaJogador.get(ijogador).getCode().equals(codigo)) {
					return true;
				}
				
			}
		
	}
		return false;
	}

	/**
	 * O método listarjogadoresDados lista os jogadores e seus dados cadastrados no sistema
	 */

	//Lista todos os jogadores

	@Override
	public void listarJogadoresDados(int selecaoBusca) {
		System.out.printf("Lista de jogadores [%s]:",selecao.getListaSelecoes().get(selecaoBusca));
		System.out.println("");
		if(selecaoBusca != -1) {
			if(selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores().size()> 0) {
				for(Jogador jogador: selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores()) {
					System.out.printf("%s - %s \n"
							+ "Posicao: %s"
							+ "\nGols marcados: %d"
							+ "\nQuantidade de cartoes Amarelos: %d"
							+ "\nQuantidade de cartoes vermelhos: %d\n"
							,jogador.getCode(),
							jogador.getNome(),
							jogador.getPosicao(),
							jogador.getGolsMarcados(),
							jogador.getCartoesAmarelos(),
							jogador.getCartoesVermelhos());
					System.out.println("------------------------------------------");
				}
			}
			else {
				System.out.println("Nao existe jogador cadastrado");
				}
			}
		else {
			System.out.println("Selecao nao cadastrada");
		}
		}
		

	/**
	 * O método listarJogadores lista os jogadores cadastrados no sistema
	 */

	

	@Override
	public void listarJogadores(String nomeSelecao) {
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		System.out.printf("Lista de jogadores [%s]\n", nomeSelecao);
		if(selecaoBusca != -1) {
			if(selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores().size()> 0) {
			for(Jogador jogador: selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores()) {
				System.out.printf("%s - %s \n",jogador.getCode(),jogador.getNome());
				
				}
			}
			else {
				System.out.println("Não existe jogador cadastrado");
			}
		}
		else {
			System.out.println("Selecao nao cadastrada");
		}
		System.out.println("");
	}

	/**
	 * O método imprimirJogador imprime os dados de um objeto do tipo Jogador
	 */

	
	

	@Override
	public void imprimirJogador(String codigo) {
		for(int index = 0; index < selecao.getListaSelecoes().size();index++) {
			for (int ijogador = 0; ijogador < selecao.getListaSelecoes().get(index).getListaJogadores().size(); ijogador++) {
				if(selecao.getListaSelecoes().get(index).getListaJogadores().get(ijogador).getCode().equals(codigo)) {
					Jogador jogador = selecao.getListaSelecoes().get(index).getListaJogadores().get(ijogador);
					System.out.printf("%s - %s \n"
							+ "Posicao: %s"
							+ "\nGols marcados: %d"
							+ "\nQuantidade de cartoes Amarelos: %d"
							+ "\nQuantidade de cartoes vermelhos: %d\n"
							,jogador.getCode(),
							jogador.getNome(),
							jogador.getPosicao(),
							jogador.getGolsMarcados(),
							jogador.getCartoesAmarelos(),
							jogador.getCartoesVermelhos());
					System.out.println("------------------------------------------");
				}	
			}
				
		}
		
	}
	/**
	 * O método listarPosicoes mostra as posições em que os jogadores atuam e podem ser cadastrados
	 */
	@Override
	public void listarPosicoes() {
		System.out.println("Digite a sigla de  acordo com a sua posicao:\n");
		for(Map.Entry<String, String> pos: posicoes.entrySet() ) {
			System.out.println(pos.getKey()+ " - " + pos.getValue());
		}
		System.out.println("------------------------------------------");
	}


	/**
	 * Função para comparar 
	 * @param jogador
	 * @param nomeSelecao
	 * @return boolean
	 */


	private boolean comparaJogador(Jogador jogador, String nomeSelecao) {
		int selecaoBusca = selecao.buscaSelecao(nomeSelecao);
		final List<Jogador> listaJogadores = selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores();
		if(listaJogadores != null) {
			for(Jogador player : listaJogadores) {
				if(player.equals(jogador)){
					return true;
				}
		}
		if(selecao.getListaSelecoes()!= null)
		{
			return false;
		}
			
		for(Jogador player : selecao.getListaSelecoes().get(selecaoBusca).getListaJogadores()) {
			if(player.equals(jogador)){
				return true;
			}
		}}
		return false;
	}
	
	public void transformaEmMap() {  
		ObjectMapper mapper = new ObjectMapper();
	  
	    File fileObj = new File("selecoesJogadores.json");  
	    try {   
	        Map<String, List<String>> mapJson = mapper.readValue(  
	                fileObj, new TypeReference<Map<String, List<String>>>() {  
	        }); 
	        for (int i = 0; i < selecao.getListaSelecoes().size(); i++) {
	        	String nomeSelecao = "";
				for (Map.Entry<String, List<String>> selecaoMap : mapJson.entrySet()) {
					nomeSelecao = selecaoMap.getKey();
					if(selecao.getListaSelecoes().get(i).getNome().equals(selecaoMap.getKey())) {
						for(int j =0; j< selecaoMap.getValue().size();j++) {
							cadastrar(selecaoMap.getValue().get(j),selecaoMap.getKey());
						}
					}
				}
			}
	      
	        
	    } catch (Exception e) {   
	        e.printStackTrace();  
	    }   
	    }

	

}
