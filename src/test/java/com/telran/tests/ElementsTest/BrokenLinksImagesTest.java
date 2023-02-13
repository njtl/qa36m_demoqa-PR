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
        Assert.assertEquals( new BrokenLinksImagesPage(driver).checkNumberBrokenImages(), 0 );
    }

    // Title: Check page for broken links (status code of the target link is >= 400)
    @Test
    public void checkBrokenLinks() {
        Assert.assertEquals( new BrokenLinksImagesPage(driver).checkNumberBrokenLinks(), 0 );
    }

    // href="#FirstArticle"
}
