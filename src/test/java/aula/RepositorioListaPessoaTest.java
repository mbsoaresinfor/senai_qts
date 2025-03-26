package aula;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RepositorioListaPessoaTest {

	private RepositorioListaPessoa repositorio = new RepositorioListaPessoa();
	
	@BeforeAll
	public static void executaAntesdeTodosMetodos() {
		System.out.println("********** executaAntesdeTodosMetodos");
	}
	
	@AfterAll
	public static void executaDepoisdeTodosMetodos() {
		System.out.println("********** executaDepoisdeTodosMetodos");
	}
	
	@BeforeEach
	public void executaAntesCadaMetodo() {
		System.out.println("executaAntesCadaMetodo");
	}
	
	@AfterEach
	public void executaDepoisCadaMetodo() {
		System.out.println("executaDepoisCadaMetodo");
	}
	
	@DisplayName("Deve salvar na lista e retornar verdadeiro.")
	@Test
	public void testSalvarPessoa0() {
		// arrange		
		Pessoa pessoa = new Pessoa();

		// ack
		boolean resultado = repositorio.salvarPessoa(pessoa);
		
		// assertion
		Assertions.assertTrue(resultado);
		Assertions.assertTrue(repositorio.lista.size() > 0);
		
	}
	
	@DisplayName("Nao deve salvar na lista e deve retornar false.")
	@Test
	public void testSalvarPessoa2() {
		// arrange		
		Pessoa pessoa = null;

		// ack
		boolean resultado = repositorio.salvarPessoa(pessoa);
		
		// assertion
		Assertions.assertFalse(resultado);
		Assertions.assertTrue(repositorio.lista.size() == 0);
		
	}
	
	@DisplayName("Deve retornar somente o primeiro nome da pessoa")
	@Test
	public void testListarPrimeiroPessoas() {
		// arrange		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("maria da silva");
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("jose cardoso");		
		repositorio.salvarPessoa(pessoa1);
		repositorio.salvarPessoa(pessoa2);
		String resultadoEsperado = "maria\njose\n";
		
		// ack
		String resultado = repositorio.listarPrimeiroPessoas();
		// maria
		// jose
		
		// assertion
		Assertions.assertEquals(resultadoEsperado, resultado);

		
	}

	
}

