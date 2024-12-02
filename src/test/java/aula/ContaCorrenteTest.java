package aula;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContaCorrenteTest {

	@Test
	void testDepositar() {
		// arrange
		ContaCorrente conta = new ContaCorrente(500f);
		float resultadoEsperado = 600f;
		
		// ack
		float resultadoPrograma = conta.depositar(100f);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultadoPrograma);
	}
	
	@Test
	void testDepositarValorNegativo() {
		// arrange
		ContaCorrente conta = new ContaCorrente(500f);
		float resultadoEsperado = -1f;
		
		// ack
		float resultadoPrograma = conta.depositar(-2f);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultadoPrograma);
	}
	
	@Test
	void testSacar() {
		// arrange
		ContaCorrente conta = new ContaCorrente(1000f);
		float resultadoEsperado = 900f;
		
		// ack
		float resultadoPrograma = conta.sacar(100f);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultadoPrograma);
	}
	
	@Test
	void testSacarSaldoSuficiente() {
		// arrange
		ContaCorrente conta = new ContaCorrente(1000f);
		float resultadoEsperado = -1f;
		
		// ack
		float resultadoPrograma = conta.sacar(1001f);
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultadoPrograma);
	}

}
