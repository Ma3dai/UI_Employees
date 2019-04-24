package ru.mpoisk.enter.tests;

import org.testng.annotations.*;

public class DeleteObject extends TestBase {

  @Test
  public void testDeleteObject() throws Exception {
    app.goToObjectPage();
    app.selectFirstObject();
    app.deleteFirstObject();
    app.submitDeletingObject();
  }
}
