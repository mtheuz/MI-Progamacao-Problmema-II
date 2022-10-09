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
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import model.ArbitroPackage.ArbitroDaoImpl;
import model.JogadorPackage.JogadorDaoImpl;
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
	 */
	public static void main(String[] args) 
	{
		//Instanciando objetos que serão usadas para invocar métodos nas opções do menu
		ArbitroDaoImpl juiz = new ArbitroDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Árbitros no sistema
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Seleções no sistema
		TecnicoDaoImpl tecnico = new TecnicoDaoImpl();//Instanciando objeto da Classe responsavel pelo CRUD de Técnicos no sistema
		JogadorDaoImpl jogador = new JogadorDaoImpl(selecao.getListaSelecoes());//Instanciando objeto da Classe responsável pelo CRUD de Jogadores no sistema
		TratamentosExcecoes tratamento = new TratamentosExcecoes(); //Instanciando classe existe para validar dados de entrada no programa
		
		Map< String,ArrayList <Selecao> > grupos = new HashMap<String, ArrayList <Selecao>>();
	
		grupos.put("A", new ArrayList<Selecao>());
		grupos.put("B", new ArrayList<Selecao>());
		grupos.put("C", new ArrayList<Selecao>());
		grupos.put("D", new ArrayList<Selecao>());
		grupos.put("E", new ArrayList<Selecao>());
		grupos.put("F", new ArrayList<Selecao>());
		grupos.put("G", new ArrayList<Selecao>());
		grupos.put("H", new ArrayList<Selecao>());
		System.out.println("Bem vindo ao Syscopa 2.0");
		
	}
}

	

		
	




