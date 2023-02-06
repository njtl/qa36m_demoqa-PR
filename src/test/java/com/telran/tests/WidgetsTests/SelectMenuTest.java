package com.telran.tests.WidgetsTests;

import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.pages.Widgets.SelectMenuPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicTreeUI;

public class SelectMenuTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openSelectMenu();
    }

    @Test
    public void fillInTwoSelectFields() {
        Assert.assertTrue( new SelectMenuPage(driver).choseFromSelectValue().getSelectValueText().contains("Group 1") );
        Assert.assertTrue( new SelectMenuPage(driver).choseFromSelectOne().getSelectOneText().contains("Prof.") );
    }
}
