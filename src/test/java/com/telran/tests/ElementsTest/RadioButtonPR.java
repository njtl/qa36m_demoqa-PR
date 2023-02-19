package com.telran.tests.ElementsTest;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RadioButtonPR extends TestBasePR {

    @Test
    public void selectRadioButtonsPR() {
        page.navigate("https://demoqa.com/radio-button");
        //page.getByLabel("Yes").check();

        page.locator("#yesRadio").check( new Locator.CheckOptions().setForce(true) );
        assertThat(page.locator(".col-12.mt-4.col-md-6 .mt-3")).containsText("Yes");

    }
}
