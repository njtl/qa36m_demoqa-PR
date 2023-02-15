package com.telran.tests.WidgetsTests;

import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.pages.Widgets.MenuPage;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openWidgets();
        new SideMenu(driver).openMenu();
    }

    @Test
    public void checkSubSubMenu() {
        Assert.assertTrue( new MenuPage(driver).openSubSubMenu().getSubSubItemText().contains("Item 1") );
    }
}
