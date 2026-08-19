package aula3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio2Test {

	@Test
	public void testcalculaTxJuros1() {
		// arrange
		double entrada = 4;
		double resultadoEsperado = 0.1;
		
		// ack
		double resultado = Exercicio2
				.calculaTxJuros(entrada);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testcalculaTxJuros2() {
		// arrange
		double entrada = 5;
		double resultadoEsperado = 0.5;
		
		// ack
		double resultado = Exercicio2
				.calculaTxJuros(entrada);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testcalculaTxJuros3() {
		// arrange
		double entrada = 10;
		double resultadoEsperado = 0.5;
		
		// ack
		double resultado = Exercicio2
				.calculaTxJuros(entrada);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testcalculaTxJuros4() {
		// arrange
		double entrada = 11;
		double resultadoEsperado = 0;
		
		// ack
		double resultado = Exercicio2
				.calculaTxJuros(entrada);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testcalculaTxJuros5() {
		// arrange
		double entrada = 19;
		double resultadoEsperado = 0;
		
		// ack
		double resultado = Exercicio2
				.calculaTxJuros(entrada);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testcalculaTxJuros6() {
		// arrange
		double entrada = 20;
		double resultadoEsperado = 0.3;
		
		// ack
		double resultado = Exercicio2
				.calculaTxJuros(entrada);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
}
