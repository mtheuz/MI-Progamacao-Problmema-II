package model.ArbitroPackage;


import org.junit.*; 
import static org.junit.Assert.*;



class ArbitroDaoImplTest {
	public ArbitroDaoImpl arbitro = new ArbitroDaoImpl();
	public Arbitro arbitro2 = new Arbitro();
	
	@Test
	void testeCadastrarArbitro() {
		
		arbitro.cadastrarArbitro();
		assertEquals(false, arbitro.getListaArbitro().isEmpty());
		

	}

}
