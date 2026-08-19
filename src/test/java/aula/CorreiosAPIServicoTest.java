package aula;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CorreiosAPIServicoTest {

    @Test
    void deveRetornarEnderecoQuandoCepExiste() {
        CorreiosAPI correiosAPI = mock(CorreiosAPI.class);
        Endereco enderecoEsperado = new Endereco();
        enderecoEsperado.setBairro("Centro");
        enderecoEsperado.setUf("SP");
        enderecoEsperado.setLogradouro("Avenida Paulista");

        when(correiosAPI.buscaCep("01000-000")).thenReturn(enderecoEsperado);

        CorreiosAPIServico servico = new CorreiosAPIServico(correiosAPI);

        Endereco resultado = servico.buscar("01000-000");

        assertSame(enderecoEsperado, resultado);
        assertEquals("Centro", resultado.getBairro());
        assertEquals("SP", resultado.getUf());
        assertEquals("Avenida Paulista", resultado.getLogradouro());
        verify(correiosAPI).buscaCep("01000-000");
    }

    @Test
    void deveRetornarEnderecoPadraoQuandoCepNaoExiste() {
        CorreiosAPI correiosAPI = mock(CorreiosAPI.class);
        when(correiosAPI.buscaCep("00000-000")).thenReturn(null);

        CorreiosAPIServico servico = new CorreiosAPIServico(correiosAPI);

        Endereco resultado = servico.buscar("00000-000");

        assertNotNull(resultado);
        assertEquals("BAIRRO NAO ENCONTRADO", resultado.getBairro());
        assertEquals("UF NÃO ENCONTRADO", resultado.getUf());
        assertEquals("LOGRADOURO NÃO ENCONTRADO", resultado.getLogradouro());
        verify(correiosAPI).buscaCep("00000-000");
    }
}
