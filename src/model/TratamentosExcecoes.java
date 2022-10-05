package model;

import java.io.IOException;
import java.util.Scanner;

/**
 * A classe <b> TratamentoExcecoes </b> é responsável por fazer validações e ler dados de entrada no sistema
 * @author Mailson
 *
 */
public class TratamentosExcecoes {

	/**
	 * Método que lê um inteiro e valida de acordo com o minino e máximo desejado
	 * @param minimo
	 * @param maximo
	 * @return int
	 */
	public int validaInt(int minimo,int maximo)
	{
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				int escolha = entrada.nextInt();
				if(escolha <=maximo || escolha>minimo)
					return escolha;
				else
					System.out.println("Escolha entre 1 e "+ maximo);
				System.out.println("Tente novamente");
			}
			catch(Exception erro){
				System.out.println("Entrada Invalida, tente novamente");
				continue;
			}
	}
	public int validaInt()
	{
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				int escolha = entrada.nextInt();
				if(escolha>=0) 
				{
					return escolha;
				}
				else
					{
					System.out.println("Tente novamente");
					}
					
			}
			catch(Exception erro){
				System.out.println("Entrada Invalida, tente novamente");
				continue;
		}
		
	}
	/**
	 * Método que valida uma String
	 * @param nome
	 * @return
	 */
	public boolean validaNome(String nome) {
		
		if(nome.matches("[a-zA-Z\s]+"))
		{
			return true;
		}
		return false;
		}
	
	

	
}
