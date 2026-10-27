package integracao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import aula.CorreiosAPI;
import aula.CorreiosAPIServico;
import aula.Endereco;

public class CorreiosAPIServicoTest {

	@Test
	public void testBuscarCepValido() {
		// arrange
		CorreiosAPIServico correio = new
				CorreiosAPIServico(new CorreiosAPI());
		
		// ack
		Endereco end = correio.buscar("94965170");
		
		// assert
		Assertions.assertFalse(end.getLogradouro()
				.equals("LOGRADOURO NÃO ENCONTRADO"));
	}
}
