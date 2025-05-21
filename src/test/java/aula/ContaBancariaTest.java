package aula;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ContaBancariaTest {

	
	
	private ContaBancaria contaBancariaMock;

	@BeforeEach
	public void init() {
		contaBancariaMock = Mockito.mock(ContaBancaria.class);
	}

	@Test
	public void testgetNomeCorrentista() {
		// arrange
		String resultadoEsperado = "João da Silva";
		when(contaBancariaMock.getNomeCorrentista()).thenReturn("João da Silva");

		// ack
		String resultado = contaBancariaMock.getNomeCorrentista();

		// assert
		Assertions.assertEquals(resultadoEsperado, resultado);

	}
	
	@Test
	public void testDepositarDinheiro() {
		// arrange
		float resultadoEsperado = 200f;
		when(contaBancariaMock.depositaDinheiro(50f)).thenReturn(200f);

		// ack
		float resultado = contaBancariaMock.depositaDinheiro(50f);

		// assert
		Assertions.assertEquals(resultadoEsperado, resultado);

	}
	
	@Test
	public void testDepositarDinheiro2() {
		// arrange
		float resultadoEsperado = 1000f;
		when(contaBancariaMock.depositaDinheiro(anyFloat())).thenReturn(1000f);

		// ack
		float resultado = contaBancariaMock.depositaDinheiro(new Random().nextFloat());

		// assert
		Assertions.assertEquals(resultadoEsperado, resultado);

	}
	
	@Test
	public void testSacarDinheiro() {
		// arrange
		float resultadoEsperado = 30f;
		when(contaBancariaMock.sacarDinheiro(10f)).thenReturn(resultadoEsperado);

		// ack
		float resultado = contaBancariaMock.sacarDinheiro(10f);

		// assert
		Assertions.assertEquals(resultadoEsperado, resultado);

	}
}
