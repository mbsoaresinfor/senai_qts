package aula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class CalculadoraTest {


	@Test
	void testSomar() { 
		// arrange
		double v1 = 15;
		double v2 = 15;
		double resultadoEsperado = 30;
		
		// ack
		double resultado = new Calculadora()
				.somar(v1, v2);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	public void testSubtrairParticaoValida() {
		// arrange
		double v1 = 0;
		double v2 = 1000;
		double resultadoEsperado = -1000;
		
		// ack
		double resultado = new Calculadora()
				.subtrair(v1, v2);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	public void testSubtrairParticaoInvalida1() {
		// arrange
		double v1 = -1;
		double v2 = 0;
		double resultadoesperado = 0;
		
		// ack
		Double resultado = new Calculadora()
				.subtrair(v1, v2);
		
		// assertion
		Assertions.assertEquals(resultadoesperado,
				resultado);
		
	}
	
	@Test
	public void testSubtrairParticaoInvalida2() {
		// arrange
		double v1 = 1001;
		double v2 = 1000;
		double resultadoesperado = 0;
		
		// ack
		Double resultado = new Calculadora()
				.subtrair(v1, v2);
		
		// assertion
		Assertions.assertEquals(resultadoesperado,
				resultado);
		
	}
	
}
