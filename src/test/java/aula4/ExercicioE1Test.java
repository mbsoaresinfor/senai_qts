package aula4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExercicioE1Test {

	@Test
	public void testValidaAluno1() {
		// arrange
		String nome= "ana12";
		int idade = 20;
		int mes = 10;
		int ano = 2026;
		boolean resultadoEsperado = true;
		
		// ack
		boolean resultado = ExercicioE1
				.validaAluno(nome, idade, mes, ano);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	public void testValidaAluno2() {
		// arrange
		String nome= "ana1";
		int idade = 20;
		int mes = 10;
		int ano = 2026;
		boolean resultadoEsperado = false;
		
		// ack
		boolean resultado = ExercicioE1
				.validaAluno(nome, idade, mes, ano);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	public void testValidaAluno3() {
		// arrange
		String nome= "12345678901234567890123456789012345678901234567890";
		int idade = 20;
		int mes = 10;
		int ano = 2026;
		boolean resultadoEsperado = false;
		
		// ack
		boolean resultado = ExercicioE1
				.validaAluno(nome, idade, mes, ano);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	public void testValidaAluno4() {
		// arrange
		String nome= "ana12";
		int idade = -1;
		int mes = 10;
		int ano = 2026;
		boolean resultadoEsperado = false;
		
		// ack
		boolean resultado = ExercicioE1
				.validaAluno(nome, idade, mes, ano);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	public void testValidaAluno5() {
		// arrange
		String nome= "ana12";
		int idade = 151;
		int mes = 10;
		int ano = 2026;
		boolean resultadoEsperado = false;
		
		// ack
		boolean resultado = ExercicioE1
				.validaAluno(nome, idade, mes, ano);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
}
