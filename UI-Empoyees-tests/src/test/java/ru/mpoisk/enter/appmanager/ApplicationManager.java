package ru.mpoisk.enter.appmanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;


    public WebDriverWait wait;
    public ChromeOptions options;
    public StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    private ObjectHelper objectHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private String browser;

  public ApplicationManager(String browser) {

    this.browser = browser;
  }

  public ObjectHelper getObjectHelper() {
        return objectHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }


    public void init() {
      //  System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
      //  options = new ChromeOptions();
      //  options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
     } else if (browser.equals(BrowserType.FIREFOX)) {
          driver = new FirefoxDriver();
       } else if (browser.equals(BrowserType.EDGE)) {
          driver = new EdgeDriver();
        }

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




}
