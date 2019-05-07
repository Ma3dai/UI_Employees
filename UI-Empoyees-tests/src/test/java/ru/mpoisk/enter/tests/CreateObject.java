package ru.mpoisk.enter.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mpoisk.enter.model.ObjectData;


public class CreateObject extends TestBase {


  @Test
  public void testCreateObject() throws Exception {

    app.getNavigationHelper().goToObjectPage();
    int before = app.getObjectHelper().getObjectCount();
    app.getObjectHelper().createObject(new ObjectData("Тестовый объект " + Math.random(), "йа комментег", "True Group"));
    Thread.sleep(1000);
    int after = app.getObjectHelper().getObjectCount();
    Assert.assertEquals(after, before + 1);
  }
}
