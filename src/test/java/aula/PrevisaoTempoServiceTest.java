package aula;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PrevisaoTempoServiceTest {

	
	private PrevisaoTempoService previsaoTempoService;
	private Tempo tempoMock;
	
	@BeforeEach
	public void init() {
		tempoMock = Mockito.mock(Tempo.class);
		previsaoTempoService = new PrevisaoTempoService(tempoMock);
	}

	
	@DisplayName("Deve retornar a string 'Tempo frio e não úmido', pois "
			+ "temperatura e umidade < 18.")
	@Test
	public void testProcessarTempo1() {
		// arrange
		InformacoesTempo informacoesTempo = new InformacoesTempo();
		informacoesTempo.setTemperatura(17f);
		informacoesTempo.setUmidade(17f);
		when(tempoMock.getInformacoesTempo(anyInt())).thenReturn(informacoesTempo);
		String resultadEsperado = "Tempo frio e não úmido";
		
		// ack
		String resultado = previsaoTempoService.processarTempo(1);
		
		// assertion
		Assertions.assertEquals(resultadEsperado, resultado);
	}
	
	@DisplayName("Deve retornar a string 'Tempo quente e não úmido', pois "
			+ "temperatura > 18 e umidade < 18.")
	@Test
	public void testProcessarTempo2() {
		// arrange
		InformacoesTempo informacoesTempo = new InformacoesTempo();
		informacoesTempo.setTemperatura(19f);
		informacoesTempo.setUmidade(17f);
		when(tempoMock.getInformacoesTempo(anyInt())).thenReturn(informacoesTempo);
		String resultadEsperado = "Tempo quente e não úmido";
		
		// ack
		String resultado = previsaoTempoService.processarTempo(1);
		
		// assertion
		Assertions.assertEquals(resultadEsperado, resultado);
	}
	
	@DisplayName("Deve retornar a string 'Tempo quente e úmido', pois "
			+ "temperatura < 18 e umidade > 18.")
	@Test
	public void testProcessarTempo3() {
		// arrange
		InformacoesTempo informacoesTempo = new InformacoesTempo();
		informacoesTempo.setTemperatura(17f);
		informacoesTempo.setUmidade(19f);
		when(tempoMock.getInformacoesTempo(anyInt())).thenReturn(informacoesTempo);
		String resultadEsperado = "Tempo quente e úmido";
		
		// ack
		String resultado = previsaoTempoService.processarTempo(1);
		
		// assertion
		Assertions.assertEquals(resultadEsperado, resultado);
	}
	
	@DisplayName("Deve retornar uma string vazia, pois "
			+ "temperatura = 18 e umidade = 18.")
	@Test
	public void testProcessarTempo4() {
		// arrange
		InformacoesTempo informacoesTempo = new InformacoesTempo();
		informacoesTempo.setTemperatura(18f);
		informacoesTempo.setUmidade(18f);
		when(tempoMock.getInformacoesTempo(anyInt())).thenReturn(informacoesTempo);
		String resultadEsperado = "";
		
		// ack
		String resultado = previsaoTempoService.processarTempo(1);
		
		// assertion
		Assertions.assertEquals(resultadEsperado, resultado);
	}
}
