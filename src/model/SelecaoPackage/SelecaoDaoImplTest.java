package model.SelecaoPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SelecaoDaoImplTest {
 
	@Test
	void testCadastrarSelecao() {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		Selecao selecaoTeste = new Selecao();
		int indice =0;
		selecao.cadastrarSelecao(selecaoTeste);
		assertTrue(selecao.getListaSelecoes().get(indice).equals(selecaoTeste));
	} 
	@Test
	void testComparaSelecao()
	{
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		Selecao selecao1Teste = new Selecao();
		selecao1Teste.setNome("Brasil");
		selecao.cadastrarSelecao(selecao1Teste);
		
		Selecao selecao2Teste = new Selecao();
		selecao2Teste.setNome("Brasil");
		selecao.cadastrarSelecao(selecao2Teste);
		
		assertFalse(selecao.ComparaSelecao("Brasil"));
		
		
	}
	@Test
	void testEditaSelecao()
	{
		SelecaoDaoImpl selecao = new SelecaoDaoImpl(); 
		Selecao selecao1Teste = new Selecao();
		selecao1Teste.setNome("Brasil"); 
		selecao.cadastrarSelecao(selecao1Teste);
		int indice = selecao.buscaSelecao("Brasil");
		selecao.editarSelecao("Coreia", indice);
		
		assertEquals(selecao.getListaSelecoes().get(indice).getNome(), "Coreia");
		 
		
	}
	@Test
	void testBuscaSelecao()
	{
		SelecaoDaoImpl selecao = new SelecaoDaoImpl(); 
		Selecao selecao1Teste = new Selecao();
		selecao1Teste.setNome("Brasil");
		selecao.cadastrarSelecao(selecao1Teste);
		int indice = selecao.buscaSelecao("Brasil");
		assertEquals(indice, 0);
	}
}
   