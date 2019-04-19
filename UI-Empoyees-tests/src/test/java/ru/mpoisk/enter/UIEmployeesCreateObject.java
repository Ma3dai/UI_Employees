package ru.mpoisk.enter;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;


public class UIEmployeesCreateObject {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\fit\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUIEmployeesCreateObject() throws Exception {
    driver.get("https://enter.mpoisk.ru/");
    driver.findElement(By.id("Login")).clear();
    driver.findElement(By.id("Login")).sendKeys("automationtest");
    driver.findElement(By.id("Password")).click();
    driver.findElement(By.id("Password")).click();
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("testautomation");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Пароль:'])[1]/following::button[1]")).click();
    driver.findElement(By.id("node_Employees_defaulte_Objects_Index_GET_Objects_")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Задать радиус'])[1]/following::button[1]")).click();
    driver.findElement(By.id("Info_Name")).clear();
    driver.findElement(By.id("Info_Name")).sendKeys("Тестовый объект 1");
    driver.findElement(By.id("addressField")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("addressField")).clear();
    driver.findElement(By.id("addressField")).sendKeys("Россия, Москва, улица Исаковского");
    driver.findElement(By.id("popupPanel")).submit();
    driver.findElement(By.id("Info_Comment")).click();
    driver.findElement(By.id("Info_Comment")).clear();
    driver.findElement(By.id("Info_Comment")).sendKeys("Какой-то комментарий");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Информация'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Родительская группа'])[1]/following::label[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Фотография'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Иконка'])[2]/following::i[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Иконка'])[1]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Объект'])[2]/following::div[1]")).click();
    driver.findElement(By.id("Radius_Radius")).clear();
    driver.findElement(By.id("Radius_Radius")).sendKeys("200");
    driver.findElement(By.name("Submit")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Присвоить группу'])[1]/following::i[2]")).click();
    driver.findElement(By.name("query")).clear();
    driver.findElement(By.name("query")).sendKeys("тестовый объект 1");
    driver.findElement(By.id("panel")).submit();
  }

  @AfterClass(alwaysRun = true)
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
