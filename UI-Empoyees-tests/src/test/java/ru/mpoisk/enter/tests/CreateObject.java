package ru.mpoisk.enter.tests;


import org.testng.annotations.*;
import ru.mpoisk.enter.model.ObjectData;


public class CreateObject extends TestBase {


  @Test
  public void testCreateObject() throws Exception {
    app.getNavigationHelper().goToObjectPage();
    app.getObjectHelper().createObjectButtonClick();
    app.getObjectHelper().fillObjectForm(new ObjectData("Тестовый объект " + Math.random(), "Йа комментег"));
    app.getObjectHelper().submitObjectCreation();
  }
}
