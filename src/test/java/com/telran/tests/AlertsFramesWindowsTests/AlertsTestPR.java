package com.telran.tests.AlertsFramesWindowsTests;

import com.telran.pages.data.LoginData;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AlertsTestPR extends TestBasePR {

    @Test
    void alertTestOKPR()  {
        page.navigate("https://demoqa.com/alerts");

        page.onDialog(dialog -> dialog.accept());

        page.locator("#confirmButton").click();

        assertThat(page.locator("#confirmResult")).containsText("Ok");

    }

    @Test
    void alertTestDissmissPR()  {
        page.navigate("https://demoqa.com/alerts");

        page.onDialog(dialog -> dialog.dismiss());

        page.locator("#confirmButton").click();

        assertThat(page.locator("#confirmResult")).containsText("Cancel");

    }

    @Test
    void promptTestDissmissPR()  {
        page.navigate("https://demoqa.com/alerts");

        page.onDialog(dialog -> dialog.accept("tttttt"));

        page.locator("#promtButton").click();

        assertThat(page.locator("#promptResult")).containsText("tttttt");

    }
}
