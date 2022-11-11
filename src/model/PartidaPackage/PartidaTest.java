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
		int valorObtido = partida.somaGols(listaGols);
		assertEquals(19,valorObtido);
		
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
	
	@Test
	void testRetirarGols() throws InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		List<String> jogador1 = new ArrayList<String>();
		List<String> jogador2 = new ArrayList<String>();
		jogador1.add(partida.geraid());
		jogador1.add("0");
		jogador2.add(partida.geraid());
		jogador2.add("2");
		boolean resultado1 = partida.retirarGols(2, jogador1);
		boolean resultado2 = partida.retirarGols(1, jogador2);
		assertFalse(resultado1);
		assertTrue(resultado2);
		assertEquals("1",jogador2.get(1));
	} 
	
	@Test
	void testAdicionarGols() throws InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		List<String> jogador1 = new ArrayList<String>();
		List<String> jogador2 = new ArrayList<String>();
		jogador1.add(partida.geraid());
		jogador1.add("4");
		jogador2.add(partida.geraid());
		jogador2.add("2");
		boolean resultado1 = partida.adicionarGols(2, jogador1);
		boolean resultado2 = partida.adicionarGols(1, jogador2);
		assertTrue(resultado1);
		assertTrue(resultado2);
		assertEquals("6",jogador1.get(1));
		assertEquals("3",jogador2.get(1));
	} 
	
	@Test
	void testAdicionarCartaoVermelho() throws InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		List<String> jogador1 = new ArrayList<String>();
		List<String> jogador2 = new ArrayList<String>();
		jogador1.add(partida.geraid());
		jogador1.add("0");
		jogador2.add(partida.geraid());
		jogador2.add("1");
		boolean resultado1 = partida.adicionarCartaoVemelho(jogador1);
		boolean resultado2 = partida.adicionarCartaoVemelho(jogador2);
		assertTrue(resultado1);
		assertFalse(resultado2);

	}
	
	@Test
	void testRetirarCartaoVermelho() throws InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		List<String> jogador1 = new ArrayList<String>();
		List<String> jogador2 = new ArrayList<String>();
		jogador1.add(partida.geraid());
		jogador1.add("0");
		jogador2.add(partida.geraid());
		jogador2.add("1");
		boolean resultado1 = partida.retirarCartaoVemelho(jogador1);
		boolean resultado2 = partida.retirarCartaoVemelho(jogador2);
		assertFalse(resultado1);
		assertTrue(resultado2);

	}
	@Test
	void testAdicionarCartaoAmarelo() throws InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		List<String> jogador1 = new ArrayList<String>();
		List<String> jogador2 = new ArrayList<String>();
		jogador1.add(partida.geraid());
		jogador1.add("0");
		jogador2.add(partida.geraid());
		jogador2.add("2");
		boolean resultado1 = partida.adicionarCartaoAmarelo(2,jogador1);
		boolean resultado2 = partida.adicionarCartaoAmarelo(2,jogador2);
		assertTrue(resultado1);
		assertFalse(resultado2);
		assertEquals("2",jogador1.get(1));
		assertEquals("2",jogador2.get(1));

	}
	
	@Test
	void testRetirarCartaoAmarelo() throws InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		List<String> jogador1 = new ArrayList<String>();
		List<String> jogador2 = new ArrayList<String>();
		jogador1.add(partida.geraid());
		jogador1.add("1");
		jogador2.add(partida.geraid());
		jogador2.add("2");
		boolean resultado1 = partida.retirarCartaoAmarelo(2,jogador1);
		boolean resultado2 = partida.retirarCartaoAmarelo(1,jogador2);
		assertFalse(resultado1);
		assertTrue(resultado2);
		assertEquals("1",jogador1.get(1));
		assertEquals("1",jogador2.get(1));

	}
	
	@Test
	void testListarJogadoresCartoes() throws IOException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();  
		Jogador jogador = new Jogador("Carlos");
		jogadorDao.inserirJogador(jogador, "Alemanha");
		Jogador jogador2 = new Jogador("Joao");
		jogadorDao.inserirJogador(jogador2, "Alemanha");
		List<List<String>> listaGols = new ArrayList<List<String>>();
		List<List<String>> listaGols2 = new ArrayList<List<String>>();
		
		String code = selecao.getListaSelecoes().get(0).getListaJogadores().get(0).getCode();
		String code2 = selecao.getListaSelecoes().get(0).getListaJogadores().get(1).getCode();
		List<String> jogadorGol = new ArrayList<String>();
		List<String> jogadorGol2 = new ArrayList<String>();
		jogadorGol.add(code);
		jogadorGol.add("2");
		listaGols.add(jogadorGol);
		jogadorGol2.add(code2);
		jogadorGol2.add("3");
		listaGols.add(jogadorGol2);
		
		boolean listar = partida.listarJogadoresCartoes(listaGols);
		boolean listar2 = partida.listarJogadoresCartoes(listaGols2);
		assertTrue(listar);
		assertFalse(listar2);
		
		
	}
	
	@Test
	void listarPartidaCodigoNaoJogadas() throws IOException, InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		JogadorDaoImpl jogadorDao = new JogadorDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();
		partida.geraPartidas();
		
		boolean listar = partida.listarPartidaCodigoNaoJogadas("A");
		assertTrue(listar);
		for (int i = 0; i < 6; i++) {
			partida.getPartidas().get("A").get(i).setSituacao(true);
		}
		boolean listar2 = partida.listarPartidaCodigoNaoJogadas("A");
		assertFalse(listar2);
	}
	
	
	@Test
	void listarPartidaCodigoJogadas() throws IOException, InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partida = new PartidaDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();
		partida.geraPartidas();
		
		boolean listar = partida.listarPartidaCodigoJogados("A");
		assertFalse(listar);
		for (int i = 0; i < 6; i++) {
			partida.getPartidas().get("A").get(i).setSituacao(true);
		}
		boolean listar2 = partida.listarPartidaCodigoJogados("A");
		assertTrue(listar2);
	}
	
	@Test
	void testMostrarPartida() throws IOException, InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partidaDao = new PartidaDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();
		partidaDao.geraPartidas();
		Partida partida = partidaDao.getPartidas().get("A").get(0);
		partidaDao.atualizarData(partida, "17", "12", "2020");
		partidaDao.atualizarHora(partida, "17", "30");
		partidaDao.atualizarLocal(partida, 0);
		boolean mostrar = partidaDao.mostrarPartida(partida.getCodigo());
		assertTrue(mostrar);
		
	}
	@Test
	 void testListarTodasPartidas() throws IOException, InterruptedException{
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partidaDao = new PartidaDaoImpl(selecao.getListaSelecoes());
		
		boolean listar = partidaDao.listarTodasPartidas();
		assertFalse(listar);
		selecao.leArquivoSelecoes();
		partidaDao.geraPartidas();
		boolean listar2 = partidaDao.listarTodasPartidas();
		assertTrue(listar2);
		
	}
	
	@Test
	 void testimprimeGrupos() throws IOException, InterruptedException{
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partidaDao = new PartidaDaoImpl(selecao.getListaSelecoes());
		
		boolean imprimir = partidaDao.imprimeGrupos();
		assertFalse(imprimir);
		
		selecao.leArquivoSelecoes();
		boolean imprimir2 = partidaDao.imprimeGrupos();
		assertTrue(imprimir2);
		
	}
	
	@Test
	void testDeletar() throws IOException, InterruptedException {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		PartidaDaoImpl partidaDao = new PartidaDaoImpl(selecao.getListaSelecoes());
		selecao.leArquivoSelecoes();
		partidaDao.geraPartidas();
		Partida partida = partidaDao.getPartidas().get("A").get(0);
		partidaDao.atualizarData(partida, "17", "12", "2020");
		partidaDao.atualizarHora(partida, "17", "30");
		partidaDao.atualizarLocal(partida, 0);
		
		boolean deletar1 = partidaDao.deletar("12334");
		assertFalse(deletar1);
		
		boolean deletar2 = partidaDao.deletar(partida.getCodigo());
		assertTrue(deletar2);
	}
	

}
