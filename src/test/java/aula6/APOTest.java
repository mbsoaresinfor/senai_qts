package aula6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class APOTest {

	@Test
	void testValidaDataMatrixCaminhoFeliz() {
		// arrange
		String dm = "17898XY0660559260124ABCDE123459";
		boolean resultadoEsperado = true;
		
		// ack
		boolean resultado = APO.validaDataMatrix(dm);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}
	
	@Test
	void testValidaDataMatrixCaminhoInFeliz0() {
		// arrange
		String dm = "17A98560660559260124ABCDE12345A";
		boolean resultadoEsperado = false;
		
		// ack
		boolean resultado = APO.validaDataMatrix(dm);
		
		// assert
		Assertions.assertEquals(resultadoEsperado,
				resultado);
		
	}

}
