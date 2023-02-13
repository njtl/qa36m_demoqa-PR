package com.telran.tests.ElementsTest;

import com.telran.pages.Elements.BrokenLinksImagesPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openBrokenLinksImages();
    }

    // Title: Check page for broken images (not displayed, non-existent source)
    @Test
    public void checkBrokenImages() {
        Assert.assertTrue( new BrokenLinksImagesPage(driver).checkNoBrokenImages()==0 );
    }

}
