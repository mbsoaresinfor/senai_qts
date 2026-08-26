package aula;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  @author marcelo.soares
 *  Exemplo de teste de integração
 */
public class BancoDadosIntegracaoTest {

	private static BancoDados banco;
    
    @BeforeAll
    public static void init(){
        banco = new BancoDados();
        System.out.println("init");
    }
    
    @BeforeEach
    public void limpeza() {
    	banco.limparBanco();
    	System.out.println("limpeza");
    }
    
    @AfterAll
    public static void fim() {
    	System.out.println("fim");
    }
    
    @AfterEach
    public void fimMetodo() {
    	System.out.println("fimMetodo");
    }
    
    
    @Test
    public void testInsert(){
    	// arrange
        Pessoa pessoa = new Pessoa();
        pessoa.setIdade(60);
        pessoa.setNome("joao");
        // ack
        banco.insertPessoa(pessoa);
        // assert
        int id = pessoa.getId();
        assertNotNull(banco.buscaPessoa(id));
    }
    
    @Test
    public void testListPessoa(){
    	// arrange
        Pessoa pessoa = new Pessoa();
        pessoa.setIdade(60);
        pessoa.setNome("joao");
        banco.insertPessoa(pessoa);
        // ack
        List<Pessoa> lista =  banco.listPessoa();
        // assert
       
        assertTrue(lista.size() > 0);
        assertEquals("joao", lista.get(0).getNome());
    }
    
    @Test
    public void testDeletaPessoa(){
    	// arrange
        Pessoa pessoa = new Pessoa();
        pessoa.setIdade(60);
        pessoa.setNome("joao");
        banco.insertPessoa(pessoa);
        // ack
         banco.deletePessoa(pessoa.getId());
        // assert
       
        assertTrue(banco.listPessoa().size() == 0);
        assertNull(banco.buscaPessoa(pessoa.getId()));
    }
}
