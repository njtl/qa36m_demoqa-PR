package com.telran.tests.ElementsTest;

import com.telran.pages.BookStore.LoginPage;
import com.telran.pages.Elements.TextBoxPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.pages.data.LoginData;
import com.telran.pages.data.TextBoxData;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TextBoxTest extends TestBase {

    // Pre-conditions: Text Box page is opened from the home page and side menu
    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openTextBox();
    }

    // Title: Check that div with 'output' displays correct data from the form input fields
    @Test
    public void simpleFormSubmit() throws IOException, UnsupportedFlavorException {

        // Step 1: Fill in the full name input with John Doe value
        // Step 2: Fill in the email input with john@doe.com
        // Step 3: Fill in the current address with "10318, Germany, Berlin, Marksburgstrasse 1," data
        // Step 4: Copy value from the Current Address text area to Permanent Address textarea
        // Step 5: Submit the form
        new TextBoxPage(driver).fillAndSubmitForm();
        // Expected results: All data from steps1-4 is presented in the output div.
        Assert.assertTrue( new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.FULLNAME) );
        Assert.assertTrue( new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.ADDRESS) );
        Assert.assertTrue( new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.EMAIL) );
        Assert.assertEquals( new TextBoxPage(driver).getPermanentAddress(), TextBoxData.ADDRESS);
    }
}
