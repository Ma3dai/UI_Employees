package ru.mpoisk.enter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class SessionHelper {
private ChromeDriver driver;


    public SessionHelper(ChromeDriver driver) {
        this.driver=driver;
    }

    public void login(String username, String password) {

        driver.findElement(By.id("Login")).sendKeys(username);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
    }

}
