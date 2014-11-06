package br.com.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestePedidoPayPal {
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
  public void testePedidoPayPal() throws Exception {
    driver.get(baseUrl + "/RestaurantesJSF/login.jsf");
    driver.findElement(By.id("formLogin:id_email")).clear();
    driver.findElement(By.id("formLogin:id_email")).sendKeys("anderson@email.com");
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
    driver.findElement(By.id("formPedido:login_paypal")).clear();
    driver.findElement(By.id("formPedido:login_paypal")).sendKeys("anderson@paypal.com");
    driver.findElement(By.id("formPedido:senha_paypal")).clear();
    driver.findElement(By.id("formPedido:senha_paypal")).sendKeys("123");
    driver.findElement(By.id("formPedido:confirmarPedidoPayPal")).click();
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

