package aula;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CorreiosAPIServicoIntegracaoTest {

	private CorreiosAPIServico correiosAPIServico;
	
	@BeforeEach
	public void inicio() {
		correiosAPIServico = new CorreiosAPIServico(); 
	}
	
	@Test
	public void testBuscarOk() {
		// arrange
		
		// ack
		Endereco end = correiosAPIServico
				.buscar("90520010");
		
		// assertions
		Assertions.assertEquals("Rua Dom Pedrito", 
				end.getLogradouro());
		Assertions.assertEquals("Passo da Areia", 
				end.getBairro());
		Assertions.assertEquals("RS",end.getUf());
	}
}
