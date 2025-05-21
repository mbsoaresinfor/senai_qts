package aula;

import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ContaCorrenteServicoTest {

	private ContaBancaria contaBancariaMock;
	private ContaCorrenteServico contaCorrenteServico;
	
	@BeforeEach
	public void init() {
		contaBancariaMock = Mockito.mock(ContaBancaria.class);
		contaCorrenteServico = new ContaCorrenteServico(contaBancariaMock);
	}
	
	@Test
	public void testprocessarDepositoSucesso() {
		// arrange
		when(contaBancariaMock.depositaDinheiro(anyFloat()))
				.thenReturn(2f);
		String resultadoEsperado = "sucesso";
		
		// ack
		String resultado = contaCorrenteServico.processarDeposito("abc", 12f);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void testprocessarDepositoError() {
		// arrange
		when(contaBancariaMock.depositaDinheiro(anyFloat()))
				.thenReturn(null);
		String resultadoEsperado = "erro";
		
		// ack
		String resultado = contaCorrenteServico.processarDeposito("abc", 12f);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultado);
	}
}
