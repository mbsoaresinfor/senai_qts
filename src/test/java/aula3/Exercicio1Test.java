package aula3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio1Test {

	@Test
	public void testValidaIdade1() {
		// arrange
		int idade =0;
		boolean resultadoEsperado = true;
		
		// ack
		boolean resultado = Exercicio1
				.validaIdade(idade);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	public void testValidaIdade2() {
		// arrange
		int idade =-1;
		boolean resultadoEsperado = false;
		
		// ack
		boolean resultado = Exercicio1
				.validaIdade(idade);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	public void testValidaIdade3() {
		// arrange
		int idade =130;
		boolean resultadoEsperado = true;
		
		// ack
		boolean resultado = Exercicio1
				.validaIdade(idade);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	public void testValidaIdade4() {
		// arrange
		int idade =131;
		boolean resultadoEsperado = false;
		
		// ack
		boolean resultado = Exercicio1
				.validaIdade(idade);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
}
