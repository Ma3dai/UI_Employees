package ru.mpoisk.enter.appmanager;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private ChromeDriver driver;


    public WebDriverWait wait;
    public ChromeOptions options;
    public StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    private ObjectHelper objectHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;

    public ObjectHelper getObjectHelper() {
        return objectHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }


    public void init() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://enter.mpoisk.ru/login/e");
        objectHelper = new ObjectHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);

        sessionHelper.login("automationtest", "testautomation");
    }


    public void stop() {

        driver.quit();
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
