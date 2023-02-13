package com.telran.tests.InteractionsTests;

import com.telran.pages.HomePage;
import com.telran.pages.Interactions.DroppablePage;
import com.telran.pages.SideMenu;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DroppableTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openIntercations();
        new SideMenu(driver).openDroppablePage();
    }

    @Test
    public void dragHereTest() {
        Assert.assertTrue( new DroppablePage(driver).testDroppableHere().getDroppedResult().contains("Dropped!") );
    }

    @Test
    public void dragByOffsetElement()
    {
        Assert.assertTrue( new DroppablePage(driver).testDroppableByOffset().getDroppedResult().contains("Dropped!") );
    }

}
