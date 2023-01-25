package com.telran.tests;

import com.telran.pages.LoginPage;
import com.telran.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookStoreLoginTest extends TestBase {

    //imaksimov2
    //!m@ksimoV2

    @Test
    public void positiveAuthTest() {
        new LoginPage(driver).login("imaksimov2", "!m@ksimoV2");
        Assert.assertEquals(new ProfilePage(driver).getUserNameValue(), "imaksimov2");
    }
}
