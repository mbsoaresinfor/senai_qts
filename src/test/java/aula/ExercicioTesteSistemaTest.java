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
public class ExercicioTesteSistemaTest {
    
      static WebDriver driver = null;
      
      private static String namePaginaPrincipal ;
    public ExercicioTesteSistemaTest() {
    }
    
    @BeforeAll
    public static void setUp() {
    	WebDriverManager.chromedriver().setup();
	        
        
         driver = new ChromeDriver();

    }
    
    
    
    @Test
    public void testTituloPaginaLogin(){
    	// arrange
    	driver.get("http://localhost/exercicio1.html");      
    	String tituloExperado ="Exercicio"; 
        
    	// act,
    	String resultado = driver.getTitle();
    	
    	// assert
    	Assertions.assertEquals(tituloExperado,resultado);
    }
    
     @Test
    public void testBodyPagina(){
    	// arrange
     	driver.get("http://localhost/exercicio1.html");      
     	String paginaEsperada ="Este e um exercicio Selenium."; 
         
     	// act,
     	String resultado = driver.getPageSource();
     	
     	// assert
     	Assertions.assertTrue(resultado.contains(paginaEsperada));
    }
    
    @Disabled 
    @Test
    public void testTExtoButton(){
    	// arrange
    	driver.get("http://localhost/exercicio1.html");
        String resultadoEsperado = "botao test";
        WebElement button = driver.findElement(By.id("button"));
         
        // assert
       Assertions.assertEquals(resultadoEsperado,button.getText());
        
    }
    
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
    
}
