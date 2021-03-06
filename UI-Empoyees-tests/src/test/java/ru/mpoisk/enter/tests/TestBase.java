package ru.mpoisk.enter.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.mpoisk.enter.appmanager.ApplicationManager;

import static org.testng.Assert.fail;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        app.stop();
        String verificationErrorString = app.verificationErrors.toString();
      if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
      }
    }

}
