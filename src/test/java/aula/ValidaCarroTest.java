package aula;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidaCarroTest {

	@DisplayName("Deve retornar true pois o id e valido")
	@Test
	void testvalidaIdCarroValido() {
		// arrange
		ValidaCarro validar = new ValidaCarro();		 

		// ack
		boolean resultado = validar.validaIdCarro(0);
		
		// assertion
		Assertions.assertTrue(resultado);
	}
	
	@DisplayName("Deve retornar false pois o id e invalido")
	@Test
	void testvalidaIdCarroInValido() {
		// arrange
		ValidaCarro validar = new ValidaCarro();		 

		// ack
		boolean resultado = validar.validaIdCarro(-1);
		
		// assertion
		Assertions.assertFalse(resultado);
	}
	
	@DisplayName("Deve retornar true pois o modelo tem <= a 20 caracteres")
	@Test
	void testvalidaModeloCarroValido() {
		// arrange
		ValidaCarro validar = new ValidaCarro();
		String modelo = "12345678901234567890";

		// ack
		boolean resultado = validar.validaModelCarro(modelo);
		
		// assertion
		Assertions.assertTrue(resultado);
	}
	
	@DisplayName("Deve retornar false pois o modelo tem mais de 20 caracteres")
	@Test
	void testvalidaModeloCarroInValido() {
		// arrange
		ValidaCarro validar = new ValidaCarro();
		String modelo = "123456789012345678901";

		// ack
		boolean resultado = validar.validaModelCarro(modelo);
		
		// assertion
		Assertions.assertFalse(resultado);
	}
	
	@DisplayName("Deve retornar true pois a ano e valido (> 1980)")
	@Test
	void testvalidaAnoCarroValido() {
		// arrange
		ValidaCarro validar = new ValidaCarro();
		int ano  = 1981;

		// ack
		boolean resultado = validar.validaAnoFabricacao(ano);
		
		// assertion
		Assertions.assertTrue(resultado);
	}
	
	@DisplayName("Deve retornar false pois a ano e invalido (<= 1980)")
	@Test
	void testvalidaAnoCarroInValido() {
		// arrange
		ValidaCarro validar = new ValidaCarro();
		int ano  = 1980;

		// ack
		boolean resultado = validar.validaAnoFabricacao(ano);
		
		// assertion
		Assertions.assertFalse(resultado);
	}
	
	@DisplayName("Deve retornar true pois as marcas sao validas")
	@Test
	void testvalidaMarcaCarroValido() {
		// arrange
		ValidaCarro validar = new ValidaCarro();
		List<String> marcasValidas = List.of("VW","GM");
		

		// ack, assertion
		for(String marca : marcasValidas) {
			boolean resultado = validar.validaMarcaCarro(marca);
			Assertions.assertTrue(resultado);
		}				
	}
	
	@DisplayName("Deve retornar false pois as marcas sao invalidas")
	@Test
	void testvalidaMarcaCarroInValido() {
		// arrange
		ValidaCarro validar = new ValidaCarro();
		List<String> marcasInValidas = List.of("fiat","ferrari","","abc");
		

		// ack, assertion
		for(String marca : marcasInValidas) {
			boolean resultado = validar.validaMarcaCarro(marca);
			Assertions.assertFalse(resultado);
		}				
	}
	
	@DisplayName("Deve retornar false pois a marca e == NULL")
	@Test
	void testvalidaMarcaNULLCarro() {
		// arrange
		ValidaCarro validar = new ValidaCarro();
		
		// ack		
		boolean resultado = validar.validaMarcaCarro(null);
		
		// assertion
		Assertions.assertFalse(resultado);
	}
	
	

}
