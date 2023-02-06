package com.telran.tests.AlertsFramesWindowsTests;

import com.telran.pages.AlertsFramesWindowsPages.FramesPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openFramesPage();
    }

    @Test(enabled = false)
    public void ensureNumberOfFrames() {
        Assert.assertEquals(new FramesPage(driver).getFramesNumber(), 2);
    }

    @Test
    public void switchToFrameById(){
        Assert.assertTrue( new FramesPage(driver).switchToFrameById().getH1().contains("sample") );
    }
}
