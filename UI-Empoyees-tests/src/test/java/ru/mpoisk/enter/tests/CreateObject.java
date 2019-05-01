package ru.mpoisk.enter.tests;

import org.testng.annotations.Test;
import ru.mpoisk.enter.model.ObjectData;


public class CreateObject extends TestBase {


  @Test
  public void testCreateObject() throws Exception {
    app.getNavigationHelper().goToObjectPage();
    app.getObjectHelper().createObject(new ObjectData("Тестовый объект " + Math.random(), "йа комментег", "True Group"));
   //app.getObjectHelper().createObjectButtonClick();
   // app.getObjectHelper().fillObjectForm(new ObjectData("Тестовый объект " + Math.random(), "йа комментег", "True Group"));
   // app.getObjectHelper().submitObjectCreation();
  }
}
