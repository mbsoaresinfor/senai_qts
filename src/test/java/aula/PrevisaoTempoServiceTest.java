package aula;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PrevisaoTempoServiceTest {

	Tempo tempoMocked;
	PrevisaoTempoService previsaoTempoService;
	
	@BeforeEach
	public void init() {
		tempoMocked = Mockito.mock(Tempo.class);
		previsaoTempoService = new PrevisaoTempoService();
		previsaoTempoService.setTempo(tempoMocked);
	}
	
	@Test
	public void testA() {
		// arrange
		when(tempoMocked.getTemperatura()).thenReturn(18f);
		when(tempoMocked.getUmidade()).thenReturn(18f);
		String resultadoesperado = "Tempo frio e não úmido";
		
		// ack
		String resultado = previsaoTempoService.processarTempo();
		
		// assertion
		Assertions.assertEquals(resultadoesperado, resultado);
	}
	
	@Test
	public void testB() {
		// arrange
		when(tempoMocked.getTemperatura()).thenReturn(19f);
		when(tempoMocked.getUmidade()).thenReturn(17f);
		String resultadoesperado = "Tempo quente e não úmido.";
		
		// ack
		String resultado = previsaoTempoService.processarTempo();
		
		// assertion
		Assertions.assertEquals(resultadoesperado, resultado);
	}
	
	@Test
	public void testC() {
		// arrange
		when(tempoMocked.getTemperatura()).thenReturn(17f);
		when(tempoMocked.getUmidade()).thenReturn(19f);
		String resultadoesperado = "Tempo frio e úmido.";
		
		// ack
		String resultado = previsaoTempoService.processarTempo();
		
		// assertion
		Assertions.assertEquals(resultadoesperado, resultado);
	}
}
