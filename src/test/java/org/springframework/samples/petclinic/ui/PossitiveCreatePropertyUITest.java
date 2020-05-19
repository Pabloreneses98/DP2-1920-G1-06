package org.springframework.samples.petclinic.ui;


import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PossitiveCreatePropertyUITest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeEach
  public void setUp() throws Exception {
    String pathToGeckoDriver = "C:\\Users\\enriq\\OneDrive\\Escritorio";
    System.setProperty("webdriver.chrome.driver", pathToGeckoDriver + "\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void testPossitiveCreatePropertyUI() throws Exception {
    driver.get("http://localhost:8090/");
    driver.findElement(By.xpath("//a[contains(@href, '/login')]")).click();
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    driver.findElement(By.id("username")).sendKeys("owner1");
    driver.findElement(By.id("password")).clear();
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
    }
    driver.findElement(By.id("password")).sendKeys("1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='main-navbar']/ul/li[2]/a/span[2]")).click();
    driver.findElement(By.xpath("//a[contains(@href, '/properties/new')]")).click();
    driver.findElement(By.id("address")).click();
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("Calle larga");
    driver.findElement(By.id("city")).clear();
    driver.findElement(By.id("city")).sendKeys("Sevilla");
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("Casa luminosa con parada de bus cercana");
    driver.findElement(By.id("surface")).clear();
    driver.findElement(By.id("surface")).sendKeys("80");
    driver.findElement(By.id("totalRooms")).clear();
    driver.findElement(By.id("totalRooms")).sendKeys("3");
    driver.findElement(By.name("propertyType")).click();
    new Select(driver.findElement(By.name("propertyType"))).selectByVisibleText("Flat");
    driver.findElement(By.name("propertyType")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @AfterEach
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