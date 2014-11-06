package br.com.test;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestePedidoValeAlimentacao {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testePedidoVale() throws Exception {
	    driver.get(baseUrl + "/RestaurantesJSF/login.jsf");
	    driver.findElement(By.id("formLogin:id_email")).clear();
	    driver.findElement(By.id("formLogin:id_email")).sendKeys("larissa@email.com");
	    driver.findElement(By.id("formLogin:id_senha")).clear();
	    driver.findElement(By.id("formLogin:id_senha")).sendKeys("123");
	    driver.findElement(By.id("formLogin:entrarLogin")).click();
	    new Select(driver.findElement(By.name("formPrato:prato:0:selectPrato"))).selectByVisibleText("2");
	    driver.findElement(By.id("formPrato:prato:0:adicionarPrato")).click();
	    driver.findElement(By.id("formPrato:prato:2:adicionarPrato")).click();
	    driver.findElement(By.cssSelector("span.glyphicon.glyphicon-remove")).click();
	    driver.findElement(By.linkText("Meu pedido")).click();
	    driver.findElement(By.linkText("Finalizar pedido")).click();
	    driver.findElement(By.id("formPedido:opcaoPagamento:1")).click();
	    driver.findElement(By.id("formPedido:numero_vale")).clear();
	    driver.findElement(By.id("formPedido:numero_vale")).sendKeys("2123");
	    driver.findElement(By.id("formPedido:nome_vale")).clear();
	    driver.findElement(By.id("formPedido:nome_vale")).sendKeys("Larissa");
	    driver.findElement(By.id("formPedido:confirmarPedidoVale")).click();
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
