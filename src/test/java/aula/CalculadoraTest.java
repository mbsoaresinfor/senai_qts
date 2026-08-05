package aula;

import org.junit.jupiter.api.Assertions;
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
	
}
