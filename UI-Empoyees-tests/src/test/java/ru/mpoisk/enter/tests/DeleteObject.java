package ru.mpoisk.enter.tests;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.mpoisk.enter.model.ObjectData;

public class DeleteObject extends TestBase {

  @Test
  public void testDeleteObject() throws Exception {
    app.getNavigationHelper().goToObjectPage();
    int before = app.getObjectHelper().getObjectCount();
    try { app.getObjectHelper().deleteFirstObject();
    }
    catch (NoSuchElementException ex) {
      app.getObjectHelper().createObject(new ObjectData("Тестовый объект " + Math.random(), "йа комментег", "True Group"));
      app.getObjectHelper().deleteFirstObject();
    }
    app.getObjectHelper().submitDeletingObject();
    Thread.sleep(1000);
    int after = app.getObjectHelper().getObjectCount();
    Assert.assertEquals(after, before - 1);
  }
}
