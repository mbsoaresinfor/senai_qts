package aula;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ContaBancariaTest {

	ContaBancaria contaBancariaMock;
	
	@BeforeEach
    public void init(){
		contaBancariaMock = 
    			Mockito.mock(ContaBancaria.class);    	
    }
	
	@Test
	public void testNomeCorrentista() {
		// arrange
		String resultadoEsperado = "João da Silva";
		when(contaBancariaMock.getNomeCorrentista())
		.thenReturn("João da Silva");
		
		// ack
		String resultado = contaBancariaMock
				.getNomeCorrentista();
		
		// assert
		Assertions.assertEquals(resultadoEsperado, 
				resultado);
	}
	
	@Test
	public void testDepositar50() {
		// arrange
		when(contaBancariaMock.depositaDinheiro(50f))
		.thenReturn(200f);
		
		// ack
		float resultado = contaBancariaMock
				.depositaDinheiro(50f);
		
		// assert
		Assertions.assertEquals(200f, resultado);
	}
	
	@Test
	public void testSacarDinheiro() {
		// arrange
		when(contaBancariaMock.sacarDinheiro(10f))
		.thenReturn(30f);
		
		// ack
		float resultado = contaBancariaMock
				.sacarDinheiro(10f);
		
		// assert
		Assertions.assertEquals(30f, resultado);
	}
	
	@Test
	public void testDepositarQualquerValor() {
		// arrange
		when(contaBancariaMock
				.depositaDinheiro(anyFloat()))
		.thenReturn(1000f);
		
		// ack, assert
		for(float i=0; i < 50; i++) {
			float resultado = contaBancariaMock
					.depositaDinheiro(i);
			Assertions.assertEquals(1000f, resultado);
		}
		
	}
	
	
}
