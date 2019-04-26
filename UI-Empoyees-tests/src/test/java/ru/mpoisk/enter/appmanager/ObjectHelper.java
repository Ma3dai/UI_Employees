package ru.mpoisk.enter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.mpoisk.enter.model.ObjectData;

import java.awt.*;

public class ObjectHelper extends HelperBase{

    public ObjectHelper(ChromeDriver driver) {
        super(driver);

    }

    public void submitObjectCreation() {
      click(By.name("Submit"));
    }

    public void fillObjectForm(ObjectData objectData) throws InterruptedException, AWTException {
        type(By.id("Info_Name"), objectData.getName());
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Адрес'])[2]/following::i[1]"));
        NavigationHelper.wt(1);
      NavigationHelper.robotClick(900, 520);
      Thread.sleep(1000);
        type(By.id("Info_Comment"), objectData.getComment());

    }

    public void createObjectButtonClick() throws InterruptedException {
        click(By.xpath("//*[@id=\"panel\"]/section/header/ul/li[7]/button"));
        Thread.sleep(1000);
    }

    public void deleteFirstObject() {
        click(By.xpath("//*[@id=\"listcontainer\"]/div[2]/div/div[1]/div/table/tbody/tr/td[8]/ul/li[2]/button"));
    }

    public void selectFirstObject() {
        click(By.xpath("//*[@id=\"listcontainer\"]/div[2]/div/div[1]/div/table/tbody/tr/td[1]/input"));
    }

    public void submitDeletingObject() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Нет'])[1]/following::div[1]"));
    }


}
