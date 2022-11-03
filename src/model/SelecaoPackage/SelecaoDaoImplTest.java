package model.SelecaoPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SelecaoDaoImplTest {

	@Test
	void testCadastrarSelecao() {
		SelecaoDaoImpl selecao = new SelecaoDaoImpl();
		selecao.cadastrarSelecao("Brasil");
		int indice = selecao.buscaSelecao("Brasil");
		assertTrue(selecao.getListaSelecoes().get(indice).getNome().equals("Brasil"));
	}

}
