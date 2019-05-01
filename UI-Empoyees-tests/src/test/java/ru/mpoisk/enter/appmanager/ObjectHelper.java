package ru.mpoisk.enter.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.mpoisk.enter.model.ObjectData;
import ru.mpoisk.enter.model.ObjectGroupData;

import java.awt.*;

public class ObjectHelper extends HelperBase{

    public ObjectHelper(WebDriver driver) {
        super(driver);

    }

    public void submitObjectCreation() {
      click(By.name("Submit"));
    }

    public void fillObjectForm(ObjectData objectData) throws InterruptedException, AWTException {
        type(By.id("Info_Name"), objectData.getName());
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Адрес'])[2]/following::i[1]"));
        wt(1);
        robotClick(900, 520);
        wt(1);
        type(By.id("Info_Comment"), objectData.getComment());

        // Селект из выпадающего списка по названию группы (возможно стоит переделать по айдишнику)
       new Select(driver.findElement(By.id("Info_GroupID"))).selectByVisibleText(objectData.getGroup());

    }

    public void fillObjectGroupForm(ObjectGroupData objectGroupData) throws InterruptedException, AWTException {
        type(By.id("Name"), objectGroupData.getName());


        // Селект родительской группы
        // new Select(driver.findElement(By.id("GroupID"))).selectByVisibleText("PiggyFerm");

    }

    public void createObjectButtonClick() throws InterruptedException {
        click(By.xpath("//*[@id=\"panel\"]/section/header/ul/li[7]/button"));
        Thread.sleep(1000);
    }

    public void createObjectGroupButtonClick() throws InterruptedException {
        click(By.xpath("//*[@id=\"panel\"]/aside/div/footer/a"));
        Thread.sleep(1000);
    }


    public void clickGroupsButton(){
        click(By.xpath("//*[@id=\"panel\"]/section/header/ul/li[3]/div"));
    }

    public void saveObjectGroup() {
        click(By.name("Submit"));
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


    public void createObject(ObjectData objectData) throws InterruptedException, AWTException {
       createObjectButtonClick();
       fillObjectForm(objectData);
       submitObjectCreation();
    }

    public boolean isThereAnObject() throws NoSuchElementException {
        if (isElementPresent(By.xpath("//*[@id=\"listcontainer\"]/div[2]/div/div[1]/div/table/tbody/tr/td[1]/input")))
        return true;
        return true;
    }
}
