package view;

import java.util.Scanner;

import model.PartidaPackage.PartidaDaoImpl;
import model.TratamentoDeExcecoesPackage.TratamentosExcecoes;

public class PartidaView {

	public int menuOpcoes()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("\n");
		System.out.println("Opcoes para Partida:");
		System.out.println("[1]Cadastrar\n[2]Editar\n[3]Listar por Grupo\n[4]Cancelar Partida\n[5]Voltar\n");
		int opcao = tratamento.validaInt(1, 4);
		return opcao;
	}
	
	public int menuEdição(String selecao1, String selecao2)
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("\n");
		System.out.println("Opcoes para Edicao:");
		System.out.printf("Digite por indice o que deseja atualizar:\n"
				+ "[1] Data\n"
				+ "[2] Horario\n"
				+ "[3] Local\n"
				+ "[4] Cartoes Amarelos para a selecao do(a) %s\n"
				+ "[5] Cartoes Amarelos para a selecao do(a) %s\\n"
				+ "[6] Cartoes Vermelhos para a selecao do(a) %s\n"
				+ "[7] Cartoes Vermelhos para a selecao do(a) %s\n"
				+ "[8] Quantidade de Gols para a selecao do(a) %s\n"
				+ "[9] Quantidade de Gols para a selecao do(a) %s\n",
				selecao1,selecao2,selecao1,selecao2,selecao1,selecao2
				);
		int opcao = tratamento.validaInt(1, 9);
		return opcao;
	}
	
	public void mostrar(String str)
	{
		System.out.println(str);
	}
	public int indiceJogadorPartida(int tamanho) {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite o indice do Jogador: ");
		int indice = tratamento.validaInt(0,tamanho);
		return indice;
	}
	public int indicePartida() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite o indice do grupo que deseja inserir a partida");
		int numPartida = tratamento.validaInt(0,7);
		return numPartida;
	}
	
	public int opcaoCartao() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Opcoes cartão:\n[0]Adicionar\n[1]Retirar");
		int opcaoCartao = tratamento.validaInt(0,1);
		return opcaoCartao;
	}
	
	public int opcaoGol() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Opcoes Gols:\n[0]Adicionar\n[1]Retirar");
		int opcaoGols = tratamento.validaInt(0,1);
		return opcaoGols;
	}
	
	public String cadastrarDia() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o dia [dd]:");
		String dia = tratamento.entradaDateDay();
		return dia;
	}
	
	public String cadastrarMes() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o mes [MM]:");
		String mes = tratamento.entradaDateMes();
		return mes;
	}
	public String cadastrarAno() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o ano [YYYY]:");
		String ano = tratamento.entradaDateAno();
		return ano;
	}
	
	public String cadastrarHora() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe a hora [HH]:");
		String hora = tratamento.entradaHora();
		return hora;
	}
	
	public String cadastrarMinuto() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o minuto [mm]:");
		String minutos = tratamento.entradaMinuto();
		return minutos;
	}
	
	public int cadastrarLocal() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o indice do local:");
		int local = tratamento.validaInt(0, 7);
		return local;
	}
	
	public String cadastrarPartidaEscolheCodigoPartida() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o codigo da partida que deseja inserir:\n");
		String codigo = tratamento.EntradaInt();
		return codigo;
	}
	
	public String cadastrarPartidaEscolheJogador() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o codigo do Jogador:\n");
		String jogador = tratamento.EntradaInt();
		return jogador;
	}
	
	public int yesOrNoGol(String selecao) {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.printf("A selecao %s fez gol?\n[1] Sim\n[0] Nao", selecao);
		int gols = tratamento.validaInt(0,1);
		return gols;
	}
	public int yesOrNoCartao(String selecao, String cartaoOpcao) {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.printf("A selecao %s recebeu cartao %s? \n[1] Sim\n[0] Nao", selecao, cartaoOpcao);
		int cartao = tratamento.validaInt(0,1);
		return cartao;
	}

	
	public String cadastrarGolsSelecao() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite a quantidade de Gols:\n");
		String gols = tratamento.EntradaInt();
		return gols;
	}
	
	public String cadastrarCartoesSelecao() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Digite a quantidade de Cartoes:\n");
		String cartoes = tratamento.EntradaInt();
		return cartoes;
	}
	
	public int continuidade(String opcaoContinuidade) {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.printf("Deseja cadastrar mais %s ?\n[1]Sim \n[0]Nao:\n",opcaoContinuidade);
		int opcao = tratamento.validaInt(0,1);
		return opcao;
	}
	
	public String editarPartidaEscolheGrupo()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o grupo: ");
		String grupo = tratamento.EntradaString();
		return grupo;
		
	}
	
	public String editarPartidaEscolheCodigo() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o codigo da partida que deseja editar");
		String codigo = tratamento.EntradaInt();
		return codigo;
	}
	public String cancelarPartidaEscolheGrupo()
	{
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		
		System.out.println("Informe o grupo: ");
		String grupo = tratamento.EntradaString();
		return grupo;
	}
	public String cancelarPartidaEscolheCodigo() {
		TratamentosExcecoes tratamento = new TratamentosExcecoes();
		System.out.println("Informe o codigo da partida que deseja resetar");
		String codigo = tratamento.EntradaString();
		return codigo;
	}
}
