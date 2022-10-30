package model.TratamentoDeExcecoesPackage;

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
				String escolha = entrada.next();
				if(isInt(escolha) && (Integer.parseInt(escolha) <=maximo && Integer.parseInt(escolha)>=minimo) )
					return Integer.parseInt(escolha);
				else
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
	
	public boolean isInt(String nome) {
		
		if(nome.matches("[a-zA-Z\s]+"))
		{
			return false;
		}
		return true;
		}
	
	public String EntradaString() {
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				String nome = entrada.nextLine();
				if(validaNome(nome)) 
				{
					return nome;
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
	
	public String entradaDateDay() {
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				int dia = entrada.nextInt();
				if(dia>0 && dia<=31) 
				{
					return String.valueOf(dia);
				}
				else
					{
					System.out.println("Dia inválido, Tente novamente");
					}
					
			}
			catch(Exception erro){
				System.out.println("Entrada Invalida, tente novamente");
				continue;
		}
		
	}
	
	public String entradaDateMes() {
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				int mes = entrada.nextInt();
				if(mes>0 && mes<=12) 
				{
					return String.valueOf(mes);
				}
				else
					{
					System.out.println("Mes inválido, Tente novamente");
					}
					
			}
			catch(Exception erro){
				System.out.println("Entrada Invalida, tente novamente");
				continue;
		}
		
	}

	
}
