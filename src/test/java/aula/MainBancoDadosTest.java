package aula;
/*
 * 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


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
    public void testInserirPessoaSucesso(){
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
    public void testInserirPessoaError1(){
    	// arrange
    	Pessoa pessoa = new Pessoa();     	
    	
    	// configura o mock
    	when(bancoDadosMock.insertPessoa(pessoa)).thenReturn(-1);
        pessoa.setIdade(60);
        pessoa.setNome("joao");
        
        // act
        boolean resultado = mainBancoDados.inserirPessoa(pessoa);
        
        // assert
        assertFalse(resultado);
        
    }
    
    @Test
    public void testInserirPessoaError2(){
    	// arrange
    	Pessoa pessoa = null;     	
        
        // act
        boolean resultado = mainBancoDados.inserirPessoa(pessoa);
        
        // assert
        assertFalse(resultado);
        
    }
    
    @Test
    public void testListPessoasErro() {
    	// arrange
    	when(bancoDadosMock.listPessoa()).thenReturn(new ArrayList<Pessoa>());
    	
    	// ack
    	boolean resultado = mainBancoDados.listarPessoas();
    	
    	// assert
    	assertFalse(resultado);
    }
    
    @Test
    public void testListPessoasSucesso() {
    	// arrange
    	Pessoa p1= new Pessoa();
    	p1.setNome("marcelo");
    	Pessoa p2= new Pessoa();
    	p2.setNome("maria");
    	ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
    	lista.add(p1);
    	lista.add(p2);
    	when(bancoDadosMock.listPessoa()).thenReturn(lista);
    	
    	// ack
    	boolean resultado = mainBancoDados.listarPessoas();
    	
    	// assert
    	assertTrue(resultado);
    }
    
    @Test
    public void testeDeletarSucesso() {
    	// arrange
    	when(bancoDadosMock.deletePessoa(anyInt())).thenReturn(true);
    	
    	String resultadoEsperado = "sucesso";
    	// ack
    	String resultado =  mainBancoDados.deletar(new Random().nextInt());
    	
    	// assertion
    	Assertions.assertEquals(resultadoEsperado, resultado);
    }
    
    @Test
    public void testeDeletarError() {
    	// arrange
    	when(bancoDadosMock.deletePessoa(-1)).thenReturn(false);
    	
    	String resultadoEsperado = "error";
    	// ack
    	String resultado =  mainBancoDados.deletar(-1);
    	
    	// assertion
    	Assertions.assertEquals(resultadoEsperado, resultado);
    }
   
}
