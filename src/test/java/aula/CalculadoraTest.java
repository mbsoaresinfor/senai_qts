package aula;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

	@Test
	public void testSomar() {
		// arrange
		Double valor1 = 5d;
		Double valor2= 7d;
		Double resultadoEsperado = 12d;
		Calculadora calculadora = new Calculadora();
		
		// ack
		Double resultado = calculadora
				.somar(valor1, valor2);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testSomarValoresNull0() {
		// arrange
		Double valor1 = null;
		Double valor2= null;
		Double resultadoEsperado = -1d;
		Calculadora calculadora = new Calculadora();
		
		// ack
		Double resultado = calculadora
				.somar(valor1, valor2);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testSomarValoresNull1() {
		// arrange
		Double valor1 = null;
		Double valor2= 2d;
		Double resultadoEsperado = -1d;
		Calculadora calculadora = new Calculadora();
		
		// ack
		Double resultado = calculadora
				.somar(valor1, valor2);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testSomarValoresNull2() {
		// arrange
		Double valor1 = 2d;
		Double valor2= null;
		Double resultadoEsperado = -1d;
		Calculadora calculadora = new Calculadora();
		
		// ack
		Double resultado = calculadora
				.somar(valor1, valor2);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testSomarComValoresNegativo() {
		// arrange
		Double valor1 = 20d;
		Double valor2= -30d;
		Double resultadoEsperado = -10d;
		Calculadora calculadora = new Calculadora();
		
		// ack
		Double resultado = calculadora
				.somar(valor1, valor2);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testSomarVetor() {
		// arrange
		Double[] vetor = {1d,2d,3d,4d,5d};		
		Double resultadoEsperado = 15d;
		Calculadora calculadora = new Calculadora();
		
		// ack
		Double resultado = calculadora.somar(vetor);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,resultado);
	}
	
	@Test
	public void testSomarVetorComValoresNegativo() {
		// arrange
		Double[] vetor = {10d,-2d,3d,-4d};		
		Double resultadoEsperado = 7d;
		Calculadora calculadora = new Calculadora();
		
		// ack
		Double resultado = calculadora.somar(vetor);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,resultado);
	}
	
	@Test
	public void testSomarVetorComValorNull() {
		// arrange
		Double[] vetor = null;
		Calculadora calculadora = new Calculadora();
		
		// ack, assert
		try {
			Double resultado = calculadora.somar(vetor);
			Assertions.fail();
		}catch(IllegalArgumentException e) {
			System.out.println("ERROR:" + e.getMessage() );
		}
		
	}
	
	@Test
	public void testDivisao() {
		// arrange
		Double entrada1 = 5d;
		Double entrada2 = 5d;
		Double resultadoEsperado = 1d;
		Calculadora calculadora = new Calculadora();
		
		// ack
		Double resultado = calculadora.divisao(entrada1, entrada2);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,resultado);
	}
	
	@Test
	public void testDivisaoComZero() {
		// arrange
		Double entrada1 = 5d;
		Double entrada2 = 0d;		
		Calculadora calculadora = new Calculadora();
		
		// ack, assert
		try {
			Double resultado = calculadora.divisao(entrada1,entrada2);
			Assertions.fail();
		}catch(IllegalArgumentException e) {
			System.out.println("ERROR:" + e.getMessage() );
		}
	}
	
	@Test
	public void testDivisaoComValoresNull() {
		// arrange
		Double entrada1 = null;
		Double entrada2 = null;		
		Calculadora calculadora = new Calculadora();
		
		// ack, assert
		try {
			Double resultado = calculadora.divisao(entrada1,entrada2);
			Assertions.fail();
		}catch(IllegalArgumentException e) {
			System.out.println("ERROR:" + e.getMessage() );
		}
	}
	
	@Test
	public void testMultiplicacao() {
		// arrange
		List<Double> lista = Arrays.asList(1d,2d,3d);
		Calculadora calculadora = new Calculadora();
		Double resultadoMultiplicao = 6d;
		
		// ack
		ResultadoCalculoVO resultado = calculadora.multiplicacao(lista);
		
		// assert
		Assertions.assertNotNull(resultado);
		Assertions.assertEquals(resultadoMultiplicao, resultado.resultado());
		Assertions.assertFalse(resultado.temError());
		Assertions.assertEquals("", resultado.mensagemError());
		
	}
	
	//@Test
	public void testMultiplicacaoComNull() {
		// arrange
		List<Double> lista = null;
		Calculadora calculadora = new Calculadora();
		Double resultadoMultiplicao = 6d;
		
		// ack
		ResultadoCalculoVO resultado = calculadora.multiplicacao(lista);
		
		// assert
		Assertions.assertNotNull(resultado);
		Assertions.assertEquals(resultadoMultiplicao, resultado.resultado());
		Assertions.assertFalse(resultado.temError());
		Assertions.assertEquals("", resultado.mensagemError());
		
	}
	
	@Test
	public void testMultiplicacaoComMaisCincoElementos() {
		// arrange
		List<Double> lista = Arrays.asList(1d,2d,3d,4d,6d,7d);
		Calculadora calculadora = new Calculadora();
		Double resultadoMultiplicao = 0d;
		
		// ack
		ResultadoCalculoVO resultado = calculadora.multiplicacao(lista);
		
		// assert
		Assertions.assertNotNull(resultado);
		Assertions.assertEquals(resultadoMultiplicao, resultado.resultado());
		Assertions.assertTrue(resultado.temError());
		Assertions.assertEquals("Tamanho maximo de elementos [5]", 
							resultado.mensagemError());
		
	}
}
