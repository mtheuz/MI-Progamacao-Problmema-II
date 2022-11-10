package model.PartidaPackage;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.JogadorPackage.Jogador;
import model.JogadorPackage.JogadorDaoImpl;
import model.SelecaoPackage.SelecaoDaoImpl;

class PartidaTest {

	@Test
	void testInputDia() {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		String ValorObtido1 = partida.inputDia("222");
		String ValorObtido2 = partida.inputDia("17");
		String ValorObtido3 = partida.inputDia("00");
		String ValorObtido4 = partida.inputDia("44");
		
		assertEquals("Entrada invalida",ValorObtido1);
		assertEquals("17",ValorObtido2);
		assertEquals("Entrada invalida",ValorObtido3);
		assertEquals("Entrada invalida",ValorObtido4);
	}
	
	@Test
	void testInputMinutos() {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		String ValorObtidoMinutos1 = partida.inputMinutos("600");
		String ValorObtidoMinutos2 = partida.inputMinutos("70");
		String ValorObtidoMinutos3 = partida.inputMinutos("30");
		String ValorObtidoMinutos4 = partida.inputMinutos("1");
		
		assertEquals("Entrada invalida",ValorObtidoMinutos1);
		assertEquals("Entrada invalida",ValorObtidoMinutos2);
		assertEquals("30",ValorObtidoMinutos3);
		assertEquals("Entrada invalida",ValorObtidoMinutos4);
	}
	
	@Test
	void testSomagols() throws InterruptedException {
		
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		List<List<String>> listaGols = new ArrayList<List<String>>();
		String[] gols = {"3","1","2","4","4","5"};
		for (int i = 0; i < gols.length; i++) {
			List<String> jogador = new ArrayList<String>();
			jogador.add(partida.geraid());
			jogador.add(gols[i]);
			listaGols.add(jogador);
		}
		int valorEsperadoGols = partida.somaGols(listaGols);
		assertEquals(19,valorEsperadoGols);
		
	}
	@Test
	void testinputGolsSelecao1() throws InterruptedException, IOException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();  
		Jogador jogador = new Jogador("Carlos");
		jogadorDao.inserirJogador(jogador, "Alemanha");
		partida.geraPartidas();
		final String CodeJogador = selecao.getListaSelecoes().get(0).getListaJogadores().get(0).getCode();
		boolean resultado = partida.inputGolsSelecao1(partida.getPartidas().get("A").get(0), "2", CodeJogador);
		boolean resultado1 = partida.inputGolsSelecao1(partida.getPartidas().get("A").get(0), "2", "123456789");
		assertTrue(resultado);
		assertFalse(resultado1);
		
	}
	
	@Test
	void testinputGolsSelecao2() throws InterruptedException, IOException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();  
		Jogador jogador = new Jogador("Joao");
		jogadorDao.inserirJogador(jogador, "Arabia Saudita");
		partida.geraPartidas();
		final String CodeJogador = selecao.getListaSelecoes().get(1).getListaJogadores().get(0).getCode();
		boolean resultado = partida.inputGolsSelecao2(partida.getPartidas().get("A").get(0), "2", CodeJogador);
		boolean resultado1 = partida.inputGolsSelecao2(partida.getPartidas().get("A").get(0), "2", "123456789");
		assertTrue(resultado);
		assertFalse(resultado1);
		
	}
	@Test
	void testInputCartosAmarelosSelecao1() throws InterruptedException, IOException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();  
		Jogador jogador = new Jogador("Carlos");
		jogadorDao.inserirJogador(jogador, "Alemanha");
		partida.geraPartidas();
		final String CodeJogador = selecao.getListaSelecoes().get(0).getListaJogadores().get(0).getCode();
		boolean resultado = partida.inputCartosAmarelosSelecao1(partida.getPartidas().get("A").get(0), "2", CodeJogador);
		boolean resultado1 = partida.inputCartosAmarelosSelecao1(partida.getPartidas().get("A").get(0), "2", "123456789");
		assertTrue(resultado);
		assertFalse(resultado1);
		
	}
	@Test
	void testInputCartosAmarelosSelecao2() throws InterruptedException, IOException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();  
		Jogador jogador = new Jogador("Joao");
		jogadorDao.inserirJogador(jogador, "Arabia Saudita");
		partida.geraPartidas();
		final String CodeJogador = selecao.getListaSelecoes().get(1).getListaJogadores().get(0).getCode();
		boolean resultado = partida.inputCartosAmarelosSelecao2(partida.getPartidas().get("A").get(0), "2", CodeJogador);
		boolean resultado1 = partida.inputCartosAmarelosSelecao2(partida.getPartidas().get("A").get(0), "2", "123456789");
		assertTrue(resultado);
		assertFalse(resultado1);
		
	}
	
	@Test
	void testInputCartosVermelhoSelecao1() throws InterruptedException, IOException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();  
		Jogador jogador = new Jogador("Carlos");
		jogadorDao.inserirJogador(jogador, "Alemanha");
		partida.geraPartidas();
		final String CodeJogador = selecao.getListaSelecoes().get(0).getListaJogadores().get(0).getCode();
		boolean resultado = partida.inputCartosVermelhoSelecao1(partida.getPartidas().get("A").get(0), "1", CodeJogador);
		boolean resultado1 = partida.inputCartosVermelhoSelecao1(partida.getPartidas().get("A").get(0), "1", "123456789");
		assertTrue(resultado);
		assertFalse(resultado1);
		
	}
	
	@Test
	void testInputCartosVermelhoSelecao2() throws InterruptedException, IOException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();  
		Jogador jogador = new Jogador("Joao");
		jogadorDao.inserirJogador(jogador, "Arabia Saudita");
		partida.geraPartidas();
		final String CodeJogador = selecao.getListaSelecoes().get(1).getListaJogadores().get(0).getCode();
		boolean resultado = partida.inputCartosVermelhoSelecao2(partida.getPartidas().get("A").get(0), "1", CodeJogador);
		boolean resultado1 = partida.inputCartosVermelhoSelecao2(partida.getPartidas().get("A").get(0), "1", "123456789");
		assertTrue(resultado);
		assertFalse(resultado1);
		
	}
	

}
