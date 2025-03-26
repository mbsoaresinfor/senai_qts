package aula;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@DisplayName("Deve somar dois valores")
	@Test
	void testSomarSomarDoisValores() {
		// arrange
		Calculadora calc = new Calculadora();
		Double entrada1 = 5d; 
		Double entrada2 = 15d;
		Double resultadoEsperado = 20d;
		
		// ack
		Double resultado = calc.somar(entrada1, entrada2);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultado);
	}
	
	@DisplayName("Deve somar dois valores com virgula")
	@Test
	void testSomarSomarDoisValoresComVirgula() {
		// arrange
		Calculadora calc = new Calculadora();
		Double entrada1 = 5.12d; 
		Double entrada2 = 15.01d;
		Double resultadoEsperado = 20.13d;
		
		// ack
		Double resultado = calc.somar(entrada1, entrada2);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultado);
	}
	
	@DisplayName("Deve tratar parametros null")
	@Test
	void testSomarTratarParametrosNull() {
		// arrange
		Calculadora calc = new Calculadora();
		Double entrada1 = null; 
		Double entrada2 = null;
				
		// ack
		Double resultado = calc.somar(entrada1, entrada2);
		
		// assertion
		Assertions.assertNull(resultado);
	}
	
	@DisplayName("Deve somar os valores do vetor")
	@Test
	void testSomarSomar() {
		// arrange
		Calculadora calc = new Calculadora();
		Double[] entrada1 = {1d,2d,5d,8d};
		Double resultadoEsperado = 16d;		
				
		// ack
		Double resultado = calc.somar(entrada1);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultado);
	}
	
	@DisplayName("Deve retornar 0 para o vetor vazio")
	@Test
	void testSomarVetorVazio() {
		// arrange
		Calculadora calc = new Calculadora();
		Double[] entrada1 = {};
		Double resultadoEsperado = 0d;		
				
		// ack
		Double resultado = calc.somar(entrada1);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultado);
		
	}
	
	@DisplayName("Deve gerar uma excessao pois o vetor e null")
	@Test
	void testSomarComVetorNull() {
		// arrange
		Calculadora calc = new Calculadora();
		Double[] entrada1 = null;				
				
		// ack, assertion
		try {			
			Double resultado = calc.somar(entrada1);
			Assertions.fail("Deveria ter gerado a excessao, pois o vetor e  null");
		}catch(Exception e) {
			System.out.println("exception ..tudo ok");
		}

	}
	
	@DisplayName("Deve retornar mensagem de erro = 'lista null' quando tem uma lista NULL")
	@Test
	public void testMultiplicacao() {
		// arrange
		Calculadora calc = new Calculadora();
		ArrayList<Double> entrada1 = null;				
				
		// ack					
		ResultadoCalculoVO resultado = calc.multiplicacao(entrada1);
		
		// assertion
		Assertions.assertEquals("lista null", resultado.mensagemError());

	}
	
	@DisplayName("Deve gerar retornar mensagem de erro = 'Tamanho maximo de elementos [5]'"
			+ " quando a lista tiver mais de 5 elementos")
	@Test
	public void testMultiplicacao1() {
		// arrange
		Calculadora calc = new Calculadora();
		ArrayList<Double> entrada1 =  new ArrayList<Double>();
		entrada1.add(1d);
		entrada1.add(1d);
		entrada1.add(1d);
		entrada1.add(1d);
		entrada1.add(1d);
		entrada1.add(1d);
				
		// ack					
		ResultadoCalculoVO resultado = calc.multiplicacao(entrada1);
		
		// assertion
		Assertions.assertEquals("Tamanho maximo de elementos [5]", resultado.mensagemError());

	}

	@DisplayName("Deve calcular a multiplicao")
	@Test
	public void testMultiplicacao2() {
		// arrange
		Calculadora calc = new Calculadora();
		ArrayList<Double> entrada1 =  new ArrayList<Double>();
		entrada1.add(1d);
		entrada1.add(2d);
		entrada1.add(3d);
		entrada1.add(4d);
		entrada1.add(5d);
		Double resultadoEsperado = 120d;
				
		// ack					
		ResultadoCalculoVO resultado = calc.multiplicacao(entrada1);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultado.resultado());

	}
	
	@DisplayName("Deve retornar o valor 0 pois a lista e vazia.")
	@Test
	public void testMultiplicacao3() {
		// arrange
		Calculadora calc = new Calculadora();
		ArrayList<Double> entrada1 =  new ArrayList<Double>();		
		Double resultadoEsperado = 0d;
				
		// ack					
		ResultadoCalculoVO resultado = calc.multiplicacao(entrada1);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultado.resultado());

	}
	

}
