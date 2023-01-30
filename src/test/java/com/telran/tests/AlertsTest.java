package com.telran.tests;

import com.telran.pages.AlertsPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openAlertsPage();
    }

    @Test
    public void invokeAlert() {
        new AlertsPage(driver).clickOnSimpleAlert();
    }

    @Test
    public void simpleAlert5Secs() {
        new AlertsPage(driver).clickOnSimpleAlertWithTimer();
    }

    @Test
    public void confirmBoxTest() {
        new AlertsPage(driver).clickOnConfirmBox("OK");
        new AlertsPage(driver).clickOnConfirmBox("Cancel");

    }

}
