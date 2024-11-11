package aula;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author marcelo.soares
 */
public class SeleniumTestAula14 {
    
      static WebDriver driver = null;
   private String ENDERECO_SERVIDOR = "http://localhost//";
      
      private static String namePaginaPrincipal ;
    public SeleniumTestAula14() {
    }
    
    
    @BeforeAll
    public static void setUp() {
         System.
         setProperty("webdriver.chrome.driver", 
	                "C:\\chromedriver_win64\\chromedriver.exe");
	    driver = new ChromeDriver();

        //driver.get("C:\\Users\\fatec.senai\\Documents\\qts\\src\\main\\java\\sistema\\login.html");
    
        //namePaginaPrincipal = driver.getWindowHandle();
    }
    
    
    
    @Test
    public void testTituloPagina(){
    	// arrange
    	driver.get(ENDERECO_SERVIDOR + "aula14.html");      
    	String tituloEsperado ="Exercicios"; 
        
    	// act, assert
    	Assertions.assertEquals(tituloEsperado,
    			driver.getTitle());
    	
    	// abcdefg
    	// cd
    }
    
    @Test
    public void testConteudoPagina(){
    	// arrange
    	driver.get(ENDERECO_SERVIDOR + "aula14.html");      
    	String tituloEsperado ="conteudo da pagina"; 
        
    	// act, assert
    	Assertions.assertTrue(
    			driver.getPageSource()
    			.contains(tituloEsperado));
    }
    
    @DisplayName("Teste o label do botao")
    @Test
    public void testLabelBotao(){
        driver.get(ENDERECO_SERVIDOR + "aula14.html");        
        WebElement botao = driver.findElement(By.id("botao"));
        
        System.out.println(botao.getText()); 
        
         Assertions
         .assertFalse(botao.getText().equals("botao teste"));
    }
    
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
    
}
