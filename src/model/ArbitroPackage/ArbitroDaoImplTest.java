package model.ArbitroPackage;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArbitroDaoImplTest {

	@Test
	void testCadastrarArbitro() {
		
		ArbitroDaoImpl arbitro = new ArbitroDaoImpl();
		Arbitro arbitroTeste1 = new Arbitro();
		arbitro.cadastrarArbitro(arbitroTeste1, "João");
		assertTrue(arbitro.getListaArbitro().get(0).equals(arbitroTeste1));
	}
	@Test
	void testEditarArbitro()
	{
		ArbitroDaoImpl arbitro = new ArbitroDaoImpl();
		Arbitro arbitroTeste1 = new Arbitro();
		arbitro.cadastrarArbitro(arbitroTeste1, "João");
		int indice = arbitro.buscaArbitro(arbitro.getListaArbitro(), "João");
		arbitro.editarArbitro("Pedro", indice);
		assertTrue(arbitro.getListaArbitro().get(0).getNome().equals("Pedro"));
	}
	
	@Test
	void testBuscaArbitro()
	{
		ArbitroDaoImpl arbitro = new ArbitroDaoImpl();
		Arbitro arbitroTeste1 = new Arbitro();
		Arbitro arbitroTeste2 = new Arbitro();
		arbitro.cadastrarArbitro(arbitroTeste1, "Joao");
		int indice1 = arbitro.buscaArbitro(arbitro.getListaArbitro(), "Joao");
		int indice2 = arbitro.buscaArbitro(arbitro.getListaArbitro(), "Felipe");
		
		assertEquals(0, indice1);
		assertEquals(-1, indice2);
		
	}
	@Test
	void testRemoverArbitro()
	{
		ArbitroDaoImpl arbitro = new ArbitroDaoImpl();
		Arbitro arbitroTeste1 = new Arbitro();
		arbitro.cadastrarArbitro(arbitroTeste1, "Joao");
		int indice1 = arbitro.buscaArbitro(arbitro.getListaArbitro(), "Joao");
		if(indice1!= -1)
		{
			arbitro.removerArbitro(indice1);
			assertTrue(arbitro.getListaArbitro().isEmpty());
		}
	}
}
