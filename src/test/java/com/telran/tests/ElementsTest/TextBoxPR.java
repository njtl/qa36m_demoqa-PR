package com.telran.tests.ElementsTest;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TextBoxPR extends TestBasePR {

//    @org.testng.annotations.Test
//    public void simpleFormSubmit() throws IOException, UnsupportedFlavorException {
//
//        // Step 1: Fill in the full name input with John Doe value
//        // Step 2: Fill in the email input with john@doe.com
//        // Step 3: Fill in the current address with "10318, Germany, Berlin, Marksburgstrasse 1," data
//        // Step 4: Copy value from the Current Address text area to Permanent Address textarea
//        // Step 5: Submit the form
//        new TextBoxPage(driver).fillAndSubmitForm();
//        // Expected results: All data from steps1-4 is presented in the output div.
//        Assert.assertTrue( new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.FULLNAME) );
//        Assert.assertTrue( new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.ADDRESS) );
//        Assert.assertTrue( new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.EMAIL) );
//        Assert.assertEquals( new TextBoxPage(driver).getPermanentAddress(), TextBoxData.ADDRESS);
//    }


    @Test
    public void simpleFormSubmit() {
        page.navigate("https://demoqa.com/text-box");

        page.getByPlaceholder("Full Name").fill("John Doe");
        page.getByPlaceholder("name@example.com").fill("john@doe.com");
        page.getByPlaceholder("Current Address").fill("10318, Germany, Berlin, Marksburgstrasse 1");
        page.locator("#permanentAddress").fill("10318, Germany, Berlin, Marksburgstrasse 1");
        //page.getByText("Submit").click();

        page.getByRole(AriaRole.BUTTON,
                        new Page.GetByRoleOptions().setName(
                                Pattern.compile("Submit", Pattern.CASE_INSENSITIVE)))
                .click();

        assertThat(page.locator("#name")).containsText("John Doe");
        assertThat(page.locator("#email")).containsText("john@doe.com");
        assertThat(page.locator("#output #currentAddress")).containsText("10318, Germany, Berlin, Marksburgstrasse 1");
        assertThat(page.locator("#output #permanentAddress")).containsText("10318, Germany, Berlin, Marksburgstrasse 1");



    }
}
