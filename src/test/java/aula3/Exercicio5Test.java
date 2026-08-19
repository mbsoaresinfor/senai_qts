package aula3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercicio5Test {

	@Test
	public void testvalidaPacientePediatria1() {
		// arrange
		int idade = 0;
		String nome = "ana lucia";
		String resultadoEsperado = "";
		
		// ack
		String resultado = Exercicio5
				.validaPacientePediatria(idade, nome);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
	}
	
	@Test
	public void testvalidaPacientePediatria2() {
		// arrange
		int idade = 13;
		String nome = "ana lucia";
		String resultadoEsperado = "Idade inválida para pediatria";
		
		// ack
		String resultado = Exercicio5
				.validaPacientePediatria(idade, nome);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		Assertions.assertFalse(resultado.isEmpty());
	}
}
