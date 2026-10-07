package aula;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ContaCorrenteTest {

	ContaBancaria conta;

	@BeforeEach
	public void init() {
		conta = Mockito.mock(ContaBancaria.class);
	}

	@Test
	public void testNomeCorrentista() {
		// arrange
		when(conta.getNomeCorrentista()).thenReturn("João da Silva");

		// ack, assertion
		Assertions.assertEquals("João da Silva", conta.getNomeCorrentista());
	}

}
