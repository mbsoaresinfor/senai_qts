package aula;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ContaBancariaServicoTest {

	ContaBancaria contaBancariaMocked;
	ContaBancariaServico contaBancariaServico;
	
	@BeforeEach
	public void init() {
		contaBancariaMocked = Mockito
					.mock(ContaBancaria.class);
		contaBancariaServico = 
				new ContaBancariaServico(contaBancariaMocked);
	}
	
	
	@Test
	public void testprocessarDepositoSucesso() {
		// arrange
		String resultadoesperado = "sucesso";
		when(contaBancariaMocked
				.depositaDinheiro(anyFloat())).thenReturn(1f);
		
		// ack
		String resultado = contaBancariaServico
				.processarDeposito("abc", 50f);
		
		// assert
		Assertions.assertEquals(resultadoesperado, 
				resultado);
	}
	
	@Test
	public void testprocessarDepositoError() {
		// arrange
		String resultadoesperado = "erro";
		when(contaBancariaMocked
				.depositaDinheiro(anyFloat())).thenReturn(null);
		
		// ack
		String resultado = contaBancariaServico
				.processarDeposito("abc", 50f);
		
		// assert
		Assertions.assertEquals(resultadoesperado, 
				resultado);
	}
}
