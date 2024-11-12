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
public class SeleniumTestAula15 {
    
      static WebDriver driver = null;
   private String ENDERECO_SERVIDOR = "http://localhost//";
    
    @BeforeAll
    public static void setUp() {
         System.
         setProperty("webdriver.chrome.driver", 
	                "C:\\chromedriver_win64\\chromedriver.exe");
	    driver = new ChromeDriver();

    }
   
    
    @DisplayName("Deve somar corretamente.")
    @Test
    public void testSomar(){
    	// arrange
    	driver.get(ENDERECO_SERVIDOR + "exercicio1.html");      
    	String resultadoEsperado ="Resultado da soma: 30"; 
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	WebElement a = driver.findElement(By.id("a"));
    	WebElement b = driver.findElement(By.id("b"));
    	WebElement botao = driver.findElement(By.id("botao_somar"));
    	a.sendKeys("15");
    	b.sendKeys("15");
    	botao.click();
    	
    	// act, assert
    	Assertions.assertEquals(resultadoEsperado, 
    			resultado.getText());
    }
    
    @DisplayName("Deve multiplicar corretamente.")
    @Test
    public void testMultiplicacao(){
    	// arrange
    	driver.get(ENDERECO_SERVIDOR + "exercicio1.html");      
    	String resultadoEsperado ="Resultado da mutiplicacao: 25"; 
    	WebElement resultado = driver.findElement(By.id("resultado"));
    	WebElement a = driver.findElement(By.id("a"));
    	WebElement b = driver.findElement(By.id("b"));
    	WebElement botao = driver.findElement(By.id("botao_multiplicar"));
    	a.sendKeys("5");
    	b.sendKeys("5");
    	botao.click();
    	
    	// act, assert
    	Assertions.assertEquals(resultadoEsperado, 
    			resultado.getText());
    }
    
    @DisplayName("teste de campos não Preenchidos")
    @Test
    public void testNaoPreencherCampos(){
    	// arrange
    	driver.get(ENDERECO_SERVIDOR + "exercicio1.html");      
    	String resultadoEsperado ="preencha todos os campos";
    	WebElement a = driver.findElement(By.id("a"));
    	WebElement b = driver.findElement(By.id("b"));
    	WebElement botao = driver.findElement(By.id("botao_multiplicar"));
    	a.sendKeys("");
    	b.sendKeys("5");
    	botao.click();
    	Alert alert = driver.switchTo().alert();
    	
    	// act, assert
    	Assertions.assertEquals(resultadoEsperado, 
    			alert.getText());
    	 alert.accept();   
    }
    
    @DisplayName("teste Campos com Caracteres Invalidos")
    @Test
    public void testCamposcomCaracteresInvalidos(){
    	// arrange
    	driver.get(ENDERECO_SERVIDOR + "exercicio1.html");      
    	String resultadoEsperado ="digite somente numeros";
    	WebElement a = driver.findElement(By.id("a"));
    	WebElement b = driver.findElement(By.id("b"));
    	WebElement botao = driver.findElement(By.id("botao_multiplicar"));
    	a.sendKeys("ab");
    	b.sendKeys("5");
    	botao.click();
    	Alert alert = driver.switchTo().alert();
    	
    	// act, assert
    	Assertions.assertEquals(resultadoEsperado, 
    			alert.getText());
    	 alert.accept();   
    }
    
//    @DisplayName("Teste o label do botao")
//    @Test
//    public void testLabelBotao(){
//        driver.get(ENDERECO_SERVIDOR + "aula14.html");        
//        WebElement botao = driver.findElement(By.id("botao"));
//        
//        System.out.println(botao.getText()); 
//        
//         Assertions
//         .assertFalse(botao.getText().equals("botao teste"));
//    }
    
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
    
}
