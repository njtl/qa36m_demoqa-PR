package com.telran.tests;

import com.telran.pages.BookStorePage;
import com.telran.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTest extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).openBookStoreApp();
    }


    @Test
    public void searchForBookTest(){
        new BookStorePage(driver).searchBook("Web");
        Assert.assertTrue(new BookStorePage(driver).getFirstBookTitle().contains("Web"));
    }
}
