package tu;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import aula8.MainAula8;
import aula8.Produto;

public class MainAula8Test {

	@Test
	public void testCriarProduto0() {
		// arrange
		String texto = "1;tv samsung;1250";
		
		// ack
		Produto produto =MainAula8.criarProduto(texto);
		
		// assert
		Assertions.assertNotNull(produto);
		Assertions.assertEquals(1, produto.getCodigo());
		Assertions.assertEquals("tv samsung", produto.getNome());
		Assertions.assertEquals(1250, produto.getPreco());
	}
	
	@Test
	public void testCriarProduto1() {
		// arrange
		String texto = "1;1250";
		
		// ack
		Produto produto =MainAula8.criarProduto(texto);
		
		// assert
		Assertions.assertNull(produto);
	
	}
	
	@Test
	public void testValidarProduto1() {
		// arrange
		Produto produto = new Produto();
		produto.setCodigo(1);
		produto.setNome("nome do produto");
		produto.setPreco(1);
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		// ack
		boolean r =MainAula8.validaProduto(produto,lista);
		
		// assert
		Assertions.assertTrue(r);
	
	}
	
	@Test
	public void testValidarProduto2() {
		// arrange
		Produto produto = new Produto();
		produto.setCodigo(1);
		produto.setNome("nome do produto");
		produto.setPreco(1);
		ArrayList<Produto> lista = new ArrayList<Produto>();
		lista.add(produto);
		
		Produto produto2 = new Produto();
		produto2.setCodigo(1);
		produto2.setNome("nome do produto");
		produto2.setPreco(1);
		
		// ack
		boolean r =MainAula8.validaProduto(produto2,lista);
		
		// assert
		Assertions.assertFalse(r);
	
	}
	
	@Test
	public void testValidarProduto3() {
		// arrange
		Produto produto = new Produto();
		produto.setCodigo(1);
		produto.setNome("");
		produto.setPreco(1);
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		// ack
		boolean r =MainAula8.validaProduto(produto,lista);
		
		// assert
		Assertions.assertFalse(r);
	
	}
	
	@Test
	public void testValidarProduto4() {
		// arrange
		Produto produto = new Produto();
		produto.setCodigo(1);
		produto.setNome("teste");
		produto.setPreco(0);
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		// ack
		boolean r =MainAula8.validaProduto(produto,lista);
		
		// assert
		Assertions.assertFalse(r);
	
	}
}
