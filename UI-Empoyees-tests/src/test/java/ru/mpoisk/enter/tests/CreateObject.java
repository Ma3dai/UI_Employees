package ru.mpoisk.enter.tests;


import org.testng.annotations.*;
import ru.mpoisk.enter.model.ObjectData;


public class CreateObject extends TestBase {


  @Test
  public void testCreateObject() throws Exception {
    app.goToObjectPage();
    app.createObjectButtonClick();
    app.fillObjectForm(new ObjectData("Тестовый объект " + Math.random(), "Йа комментег"));
    app.submitObjectCreation();
  }
}
