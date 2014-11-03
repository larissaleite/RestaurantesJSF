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

public class TestePedido {
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
  public void testE() throws Exception {
    driver.get(baseUrl + "/RestaurantesJSF/login.jsf");
    driver.findElement(By.id("formLogin:id_email")).clear();
    driver.findElement(By.id("formLogin:id_email")).sendKeys("larissa@email.com");
    driver.findElement(By.id("formLogin:id_senha")).clear();
    driver.findElement(By.id("formLogin:id_senha")).sendKeys("123");
    driver.findElement(By.name("formLogin:entrarLogin")).click();
    new Select(driver.findElement(By.name("formPrato:j_idt6:0:j_idt9"))).selectByVisibleText("2");
    driver.findElement(By.name("formPrato:j_idt6:0:j_idt12")).click();
    driver.findElement(By.name("formPrato:j_idt6:5:j_idt12")).click();
    new Select(driver.findElement(By.name("formPrato:j_idt6:6:j_idt9"))).selectByVisibleText("3");
    driver.findElement(By.name("formPrato:j_idt6:6:j_idt12")).click();
    driver.findElement(By.linkText("Meu pedido")).click();
    driver.findElement(By.linkText("Finalizar pedido")).click();
    driver.findElement(By.id("formPedido:nome")).clear();
    driver.findElement(By.id("formPedido:nome")).sendKeys("Larissa Leite");
    driver.findElement(By.id("formPedido:numero")).clear();
    driver.findElement(By.id("formPedido:numero")).sendKeys("23320294");
    driver.findElement(By.id("formPedido:codigoSeguranca")).clear();
    driver.findElement(By.id("formPedido:codigoSeguranca")).sendKeys("222");
    driver.findElement(By.id("formPedido:dataVencimento")).clear();
    driver.findElement(By.id("formPedido:dataVencimento")).sendKeys("2015-12-12");
    driver.findElement(By.name("formPedido:confirmarPedido")).click();
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
