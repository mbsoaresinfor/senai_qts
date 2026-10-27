package tu;
/*
 * 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import aula.BancoDados;
import aula.MainBancoDados;
import aula.Pessoa;


/**
 *
 * @author marcelo.soares
 * Exemplo de uso de objetos mocks
 */
public class MainBancoDadosTest {
    
	
    private BancoDados bancoDadosMock;	 
    private MainBancoDados mainBancoDados;
    
    @BeforeEach
    public void init(){
    	bancoDadosMock = Mockito.mock(BancoDados.class);
    	mainBancoDados = new MainBancoDados(bancoDadosMock);
    }
    
    @BeforeEach
    public void beforeEach() {
    	
    }
    
    @Test
    public void testInserirPessoa(){
    	// arrange
    	Pessoa pessoa = new Pessoa();     	
    	
    	// configura o mock
    	when(bancoDadosMock.insertPessoa(pessoa)).thenReturn(1);
        pessoa.setIdade(60);
        pessoa.setNome("joao");
        
        // act
        boolean resultado = mainBancoDados.inserirPessoa(pessoa);
        
        // assert
        assertTrue(resultado);
        
    }
    
    @Test
    public void testInserirPessoaCaminhoInfeliz(){
    	// arrange
    	Pessoa pessoa = new Pessoa();     	
    	
    	// configura o mock
    	when(bancoDadosMock.insertPessoa(pessoa)).thenReturn(0);
        pessoa.setIdade(60);
        pessoa.setNome("joao");
        
        // act
        boolean resultado = mainBancoDados.inserirPessoa(pessoa);
        
        // assert
        assertFalse(resultado);
        
    }
    
    @Test
    public void testInserirPessoaNull(){
    	// arrange
    	
        // act
        boolean resultado = mainBancoDados
        		.inserirPessoa(null);
        
        // assert
        assertFalse(resultado);
        
    }
    
    @Test
    public void testListPessoa(){
    	// arrange
    	ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
    	Pessoa pessoa = new Pessoa();  
    	lista.add(pessoa);
    	
    	// configura o mock
    	when(bancoDadosMock.listPessoa())
    	.thenReturn(lista);
        pessoa.setIdade(60);
        pessoa.setNome("joao");
        
        // act
        boolean resultado = mainBancoDados.listarPessoas();
        
        // assert
        assertTrue(resultado);
        
    }
    
    @Test
    public void testListPessoaVazia(){
    	// arrange
    	ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
    	
    
    	
    	// configura o mock
    	when(bancoDadosMock.listPessoa())
    	.thenReturn(lista);
        
        // act
        boolean resultado = mainBancoDados.listarPessoas();
        
        // assert
        assertFalse(resultado);
        
    }
    
   
}
