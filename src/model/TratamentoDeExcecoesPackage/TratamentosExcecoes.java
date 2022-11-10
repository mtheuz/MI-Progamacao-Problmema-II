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
					System.err.println("Tente novamente");
					}
					
			}
			catch(Exception erro){
				System.err.println("Entrada Invalida, tente novamente");
				continue;
		}
		
	}
	public String EntradaInt() {
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				String nome = entrada.nextLine();
				if(isInt(nome)) 
				{
					return nome;
				}
				else
					{
					System.err.println("Tente novamente");
					}
					
			}
			catch(Exception erro){
				System.err.println("Entrada Invalida, tente novamente");
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
					System.err.println("Dia inválido, Tente novamente");
					}
					
			}
			catch(Exception erro){
				System.err.println("Entrada Invalida, tente novamente");
				continue;
		}
		
	}
	
	public String entradaDateMes() {
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				String mes = entrada.next();
				if(mes.length() == 2 && ((Integer.valueOf(mes) <= 23) && (Integer.valueOf(mes) >= 00))) 
				{
					return mes;
				}else {
					System.err.println("Entrada invalida, tente novamente");
				}
				
					
			}
			catch(Exception erro){
				System.err.println("Entrada Invalida, tente novamente");
				continue;
		}
		
	}
	
	public String entradaDateAno() {
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				String ano = entrada.next();
				if(ano.length() == 4) {
					return ano;
				}
				else {
					System.err.println("Entrada invalida, tente novamente");
				}
					
			}
			catch(Exception erro){
				System.err.println("Entrada Invalida, tente novamente");
				continue;
		}
		
	}
	
	public String entradaHora() {
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				String hora = entrada.next();
				if(hora.length() == 2 && ((Integer.valueOf(hora) <= 23) && (Integer.valueOf(hora) >= 00))) {
					return hora;
				}
				else {
					System.err.println("Entrada invalida");
				}
					
			}
			catch(Exception erro){
				System.err.println("Entrada Invalida, tente novamente");
				continue;
		}
		
	}
	
	public String entradaMinuto() {
		while(true)
			try
			{
				Scanner entrada = new Scanner(System.in);
				String minuto = entrada.next();
				if(minuto.length() == 2 && ((Integer.valueOf(minuto) <= 59) && (Integer.valueOf(minuto) >= 00))) {
					return minuto;
				}
				else {
					System.err.println("Entrada invalida, tente novamente");
				}
					
			}
			catch(Exception erro){
				System.err.println("Entrada Invalida, tente novamente");
				continue;
		}
		
	}

	
}
