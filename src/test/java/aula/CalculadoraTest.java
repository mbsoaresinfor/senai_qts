package aula;

import static org.junit.jupiter.api.Assertions.*;

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

}
