package ru.mpoisk.enter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class SessionHelper extends HelperBase{

    public SessionHelper(ChromeDriver driver) {
        super(driver);

    }

    public void login(String username, String password) {
        type(By.id("Login"), username);
        type(By.id("Password"), password);
        click(By.xpath("//button[@type=\"submit\"]"));
    }

}
