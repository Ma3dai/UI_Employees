package ru.mpoisk.enter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.InputEvent;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {

        super(driver);
    }

    public void goToObjectPage() throws InterruptedException {
      click(By.id("node_Employees_defaulte_Objects_Index_GET_Objects_"));
      Thread.sleep(2000);
    }


}
