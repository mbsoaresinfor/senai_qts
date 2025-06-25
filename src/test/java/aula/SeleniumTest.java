package aula;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 *
 * @author marcelo.soares
 * Exemplo de teste de sistemas
 */
public class SeleniumTest {
    
      static WebDriver driver = null;
      
      private static String namePaginaPrincipal ;
    public SeleniumTest() {
    }
    
  //  @BeforeAll
    public static void setUp() {
//         System.setProperty("webdriver.chrome.driver", 
//	                "C:\\chromedriver-win64\\chromedriver.exe");
	        
    	WebDriverManager.chromedriver().setup();
        
         driver = new ChromeDriver();

    }
    
    
    
    //@Test
    public void testTituloPaginaLogin(){
    	// arrange
    	driver.get("http://localhost/login.html");      
    	String tituloExperado ="Pagina de Login"; 
        
    	// act,
    	String resultado = driver.getTitle();
    	
    	// assert
    	Assertions.assertEquals(tituloExperado,resultado);
    }
    
    // @Test
    public void testLoginSucesso(){
        driver.get("http://localhost/login.html");
        
        WebElement campoNome = driver.findElement(By.id("nome"));
         WebElement campoSenha = driver.findElement(By.id("senha"));
         WebElement submit = driver.findElement(By.id("submit"));
         campoNome.sendKeys("teste");
         campoSenha.sendKeys("123");
         submit.click();
         String codigProximaPagina =  driver.getPageSource();
         Assertions.assertTrue(codigProximaPagina.contains("Bem vindo usuario teste"));
    }
    
   // @Test
    public void testLoginError(){
        driver.get("http://localhost/login.html");

        WebElement campoNome = driver.findElement(By.id("nome"));
        WebElement campoSenha = driver.findElement(By.id("senha"));
         WebElement submit = driver.findElement(By.id("submit"));
         campoNome.sendKeys("usuario_invalido");
         campoSenha.sendKeys("senha_invalido");
         submit.click();
       
         Alert alert = driver.switchTo().alert();
         Assertions.assertTrue(alert.getText().equals("usuario ou senha invalida"));
         alert.accept();
         
        
        
    }
    
    //@AfterAll
    public static void tearDown() {
        driver.quit();
    }
    
}
