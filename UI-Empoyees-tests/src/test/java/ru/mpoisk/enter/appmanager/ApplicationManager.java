package ru.mpoisk.enter.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.mpoisk.enter.model.ObjectData;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    public Robot robot;
    public WebDriverWait wait;
    public ChromeOptions options;
    public StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    public static void click(int x, int y) throws AWTException {
      Robot bot = new Robot();
      bot.mouseMove(x, y);
      bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
      bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void submitObjectCreation() {
      driver.findElement(By.name("Submit")).click();
    }

    public void fillObjectForm(ObjectData objectData) throws InterruptedException, AWTException {
      driver.findElement(By.id("Info_Name")).sendKeys(objectData.getName());
      Thread.sleep(1000);
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Адрес'])[2]/following::i[1]")).click();
      Thread.sleep(1000);
      click(900, 520);
      Thread.sleep(1000);
      driver.findElement(By.id("Info_Comment")).sendKeys(objectData.getComment());

    }

    public void createObjectButtonClick() throws InterruptedException {
      driver.findElement(By.xpath("//*[@id=\"panel\"]/section/header/ul/li[7]/button")).click();
      Thread.sleep(1000);
    }

    public void goToObjectPage() throws InterruptedException {
      driver.findElement(By.id("node_Employees_defaulte_Objects_Index_GET_Objects_")).click();
      Thread.sleep(2000);
    }

    public void login(String username, String password) {
      driver.get("https://enter.mpoisk.ru/login/e");
      driver.findElement(By.id("Login")).sendKeys(username);
      driver.findElement(By.id("Password")).click();
      driver.findElement(By.id("Password")).sendKeys(password);
      driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
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

    public void submitDeletingObject() {
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Нет'])[1]/following::div[1]")).click();
    }

    public void deleteFirstObject() {
      driver.findElement(By.xpath("//*[@id=\"listcontainer\"]/div[2]/div/div[1]/div/table/tbody/tr/td[8]/ul/li[2]/button")).click();
    }

    public void selectFirstObject() {
      driver.findElement(By.xpath("//*[@id=\"listcontainer\"]/div[2]/div/div[1]/div/table/tbody/tr/td[1]/input")).click();
    }

    public void init() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        robot = new Robot();
        options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login("automationtest", "testautomation");
    }

    public void stop() {
        driver.quit();
    }
}
