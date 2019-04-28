package ru.mpoisk.enter.tests;

import org.testng.annotations.Test;
import ru.mpoisk.enter.model.ObjectGroupData;


public class CreateObjectGroup extends TestBase{

  @Test
  public void testCreateObjectGroup() throws Exception {

    app.getNavigationHelper().goToObjectPage();
    app.getObjectHelper().clickGroupsButton();
    app.getObjectHelper().createObjectGroupButtonClick();
    app.getObjectHelper().fillObjectGroupForm(new ObjectGroupData("Группа" + Math.random()));
    app.getObjectHelper().saveObjectGroup();

  }
}
