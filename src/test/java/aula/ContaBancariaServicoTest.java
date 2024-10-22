package aula;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ContaBancariaServicoTest {

	private ContaBancariaServico bancariaServico;
	private ContaBancaria contaBancaria;
	
	@BeforeEach
    public void init(){
		contaBancaria = Mockito.mock(ContaBancaria.class);
		bancariaServico = 
				new ContaBancariaServico(contaBancaria);
    }
	
	@Test
	public void testProcessarDepositoSucesso() {
		// arrange
		when(contaBancaria
				.depositaDinheiro(anyFloat()))
		.thenReturn(3f);
		
		// ack
		String resultado = bancariaServico
				.processarDeposito("", 5f);
		
		// assert
		Assertions.assertEquals("sucesso", resultado);
	}
	
	@Test
	public void testProcessarDepositoError() {
		// arrange
		when(contaBancaria
				.depositaDinheiro(null))
		.thenReturn(null);
		
		// ack
		String resultado = bancariaServico
				.processarDeposito("", null);
		
		// assert
		Assertions.assertEquals("erro", resultado);
	}
}
