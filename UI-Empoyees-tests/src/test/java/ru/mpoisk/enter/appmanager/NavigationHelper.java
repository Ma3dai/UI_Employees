package ru.mpoisk.enter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.InputEvent;

public class NavigationHelper {
    private ChromeDriver driver;

    public NavigationHelper(ChromeDriver driver) {
        this.driver=driver;
    }

    public static void robotClick(int x, int y) throws AWTException {
      Robot bot = new Robot();
      bot.mouseMove(x, y);
      bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
      bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void goToObjectPage() throws InterruptedException {
      driver.findElement(By.id("node_Employees_defaulte_Objects_Index_GET_Objects_")).click();
      Thread.sleep(2000);
    }

    public static void wt(long seconds) throws InterruptedException {
        long waitingTime = seconds*1000;
        Thread.sleep(waitingTime);
    }
}
