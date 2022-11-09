package view;

import java.io.IOException;

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

import controller.*;


/**
 * Essa classe é a classe principal do programa onde fica o menu principal
 * @author Mailson
 * @since 2022
 */
public class menuPrincipalView 
{ 
	
	/**
	 * Método onde fica a principal execução do programa
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */ 
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		
		System.out.println("Bem vindo ao Syscopa 2.0!\n");
		
		Controller controller = new Controller(); 
		int escolha = menuView();
		controller.menu(escolha);
	}

	public static int menuView() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println();
		System.out.println("MENU:");
		System.out.println("[1]Partidas\n[2]Selecoes\n[3]Jogadores\n[4]Tecnicos\n[5]Arbitros\n[6]Pesquisas\n[7]Encerrar\n");
		System.out.println("Digite uma opcao:"); 
		//while aqui
		int escolha = tratamento.validaInt(0, 7);
		return escolha;
	}
}
 

	

		
	




