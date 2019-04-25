package ru.mpoisk.enter.tests;

import org.testng.annotations.*;

public class DeleteObject extends TestBase {

  @Test
  public void testDeleteObject() throws Exception {
    app.getNavigationHelper().goToObjectPage();
    app.getObjectHelper().selectFirstObject();
    app.getObjectHelper().deleteFirstObject();
    app.getObjectHelper().submitDeletingObject();
  }
}
