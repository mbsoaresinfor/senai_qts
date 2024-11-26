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
public class SeleniumTest {
    
      static WebDriver driver = null;
   private String ENDERECO_SERVIDOR = "http://localhost//";
      
      private static String namePaginaPrincipal ;
    public SeleniumTest() {
    }
    
    
   // @BeforeAll
    public static void setUp() {
         System.
         setProperty("webdriver.chrome.driver", 
	                "C:\\chromedriver_win64\\chromedriver.exe");
	    driver = new ChromeDriver();

        //driver.get("C:\\Users\\fatec.senai\\Documents\\qts\\src\\main\\java\\sistema\\login.html");
    
        //namePaginaPrincipal = driver.getWindowHandle();
    }
    
    
    
   // @Test
    public void testTituloPaginaLogin(){
    	// arrange
    	driver.get(ENDERECO_SERVIDOR + "login.html");      
    	String tituloEsperado ="Pagina de Login"; 
        
    	// act, assert
    	Assertions.assertEquals(tituloEsperado,
    			driver.getTitle());
    }
    
   // @DisplayName("Teste que valida um login de sucesso")
   // @Test
    public void testLoginSucesso(){
        driver.get(ENDERECO_SERVIDOR + "login.html");
        
        WebElement campoNome = driver.findElement(By.id("nome"));
         WebElement campoSenha = driver.findElement(By.id("senha"));
         WebElement submit = driver.findElement(By.id("submit"));
         campoNome.sendKeys("teste");
         campoSenha.sendKeys("123");
         submit.click();
         String codigProximaPagina =  driver.getPageSource();
         Assertions
         .assertTrue(codigProximaPagina
        		 .contains("Bem vindo usuario teste"));
    }
    
    
   // @Test
    public void testLoginInvalido(){
        driver.get(ENDERECO_SERVIDOR + "login.html");

        WebElement campoNome = driver.findElement(By.id("nome"));
        WebElement campoSenha = driver.findElement(By.id("senha"));
         WebElement submit = driver.findElement(By.id("submit"));
         campoNome.sendKeys("usuario_invalido");
         campoSenha.sendKeys("senha_invalido");
         submit.click();
       
         Alert alert = driver.switchTo().alert();
         Assertions
         .assertTrue(alert.getText().equals("usuario ou senha invalida"));
         alert.accept();       
        
        
    }
    
   
    //@AfterAll
    public static void tearDown() {
        driver.quit();
    }
    
}
