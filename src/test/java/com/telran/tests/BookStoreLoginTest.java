package com.telran.tests;

import com.telran.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreLoginTest extends TestBase {

    //imaksimov2
    //!m@ksimoV2

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).openBookStoreApp();
        new BookStorePage(driver).openLoginPage();
    }

    @Test
    public void positiveAuthTest() {
        new LoginPage(driver).login("imaksimov2", "!m@ksimoV2");
        Assert.assertEquals(new ProfilePage(driver).getUserNameValue(), "imaksimov2");
    }

    @Test
    public void negativeAuthTest(){
        new LoginPage(driver).login("qwmklad", "mkalsd");
        String error = "Invalid username or password";
        Assert.assertTrue(new LoginPage(driver).getErrorMessage().contains(error));
    }

    @Test
    public void logOutTest(){
        new LoginPage(driver).login("imaksimov2", "!m@ksimoV2");
        new SideMenu(driver).openLoginPage();
        new LoginPage(driver).logOut();
        Assert.assertTrue(new LoginPage(driver).getWelcomeMessage().contains("Login in Book Store"));
    }
}
