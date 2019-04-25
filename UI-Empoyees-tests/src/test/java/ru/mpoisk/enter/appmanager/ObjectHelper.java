package ru.mpoisk.enter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mpoisk.enter.model.ObjectData;

import java.awt.*;

public class ObjectHelper {

    private  ChromeDriver driver;

    public ObjectHelper(ChromeDriver driver) {
        this.driver=driver;

    }

    public void submitObjectCreation() {
      driver.findElement(By.name("Submit")).click();
    }

    public void fillObjectForm(ObjectData objectData) throws InterruptedException, AWTException {
      driver.findElement(By.id("Info_Name")).click();
      driver.findElement(By.id("Info_Name")).clear();
      driver.findElement(By.id("Info_Name")).sendKeys(objectData.getName());
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Адрес'])[2]/following::i[1]")).click();
      NavigationHelper.wt(2);
      NavigationHelper.robotClick(900, 520);
      Thread.sleep(1000);
      driver.findElement(By.id("Info_Comment")).click();
      driver.findElement(By.id("Info_Comment")).clear();
      driver.findElement(By.id("Info_Comment")).sendKeys(objectData.getComment());

    }

    public void createObjectButtonClick() throws InterruptedException {
      driver.findElement(By.xpath("//*[@id=\"panel\"]/section/header/ul/li[7]/button")).click();
      Thread.sleep(1000);
    }

    public void deleteFirstObject() {
      driver.findElement(By.xpath("//*[@id=\"listcontainer\"]/div[2]/div/div[1]/div/table/tbody/tr/td[8]/ul/li[2]/button")).click();
    }

    public void selectFirstObject() {
      driver.findElement(By.xpath("//*[@id=\"listcontainer\"]/div[2]/div/div[1]/div/table/tbody/tr/td[1]/input")).click();
    }

    public void submitDeletingObject() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Нет'])[1]/following::div[1]")).click();
    }


}
