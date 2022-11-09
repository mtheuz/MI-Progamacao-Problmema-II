package model.TecnicoPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TecnicoDaoImplTest {

	@Test
	void testCadastrarSelecao() {

		TecnicoDaoImpl tecnico = new TecnicoDaoImpl();
		Tecnico tecnicoTeste = new Tecnico();
		tecnicoTeste.setNome("Joao");
		tecnico.cadastrarTecnico(tecnicoTeste);
		assertEquals(tecnico.getListaTecnicos().get(0).getNome(),"Joao");
	} 
	@Test
	void testCadastrarSelecaoSemTecnico()
	{
		TecnicoDaoImpl tecnico = new TecnicoDaoImpl();
		Tecnico tecnicoTeste = new Tecnico();
		tecnicoTeste.setNome("Sem Tecnico");
		tecnico.cadastrarTecnico(tecnicoTeste);
		
		int indice = tecnico.buscaTecnicoListaTecnicos("SEM TECNICO");
		Tecnico tecnicoTeste2 = new Tecnico();
		tecnicoTeste2.setNome("Brasil");
		tecnico.substituirTecnicoVazioNaListaTecnicos(indice, tecnicoTeste2);
		
		assertTrue(tecnico.getListaTecnicos().get(indice).getNome().equals("Brasil"));
		
		
	} 
	
	@Test
	void testBuscaTecnico()
	{
		TecnicoDaoImpl tecnico = new TecnicoDaoImpl();
		Tecnico tecnicoTeste = new Tecnico();
		tecnicoTeste.setNome("Joao");
		tecnico.cadastrarTecnico(tecnicoTeste);
		int indice = tecnico.buscaTecnicoListaTecnicos("Joao");
		assertTrue(tecnico.getListaTecnicos().get(indice).getNome().equals("Joao")); 
	}

	@Test
	void testeRemoverTecnico()
	{
		TecnicoDaoImpl tecnico = new TecnicoDaoImpl();
		Tecnico tecnicoTeste = new Tecnico();
		tecnicoTeste.setNome("Joao");
		tecnico.cadastrarTecnico(tecnicoTeste);
		int indice = tecnico.buscaTecnicoListaTecnicos("Joao");
		tecnico.removerTecnico("Joao",indice);
		assertTrue(tecnico.getListaTecnicos().get(indice).getNome().equals("Sem Tecnico"));
		
	}
	
}
