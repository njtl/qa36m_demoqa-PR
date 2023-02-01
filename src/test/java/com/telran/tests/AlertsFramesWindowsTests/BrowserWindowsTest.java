package com.telran.tests.AlertsFramesWindowsTests;

import com.telran.pages.AlertsFramesWindowsPages.BrowserWindowsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.tests.TestBase;
import org.openqa.selenium.devtools.v85.audits.model.SameSiteCookieIssueDetails;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openBrowserWindowsPage();
    }

    @Test
    public void clickOnNewTabTest() {
        new BrowserWindowsPage(driver).openNewTab();
        Assert.assertTrue( new BrowserWindowsPage(driver).getNewPageHeading().contains("sample") );
    }
}
