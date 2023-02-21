package com.telran.tests.WidgetsTests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SelectMenuTestPR extends TestBasePR {

    @Test
    public void fillInTwoSelectFields() {
        page.navigate("https://demoqa.com/select-menu");
        page.locator("//*[@id='withOptGroup']/div").click();
        page.locator("#react-select-2-input").fill("Group 1, option 1");
        page.keyboard().press("Enter");
        assertThat(page.locator(".css-1hwfws3 .css-1uccc91-singleValue")).containsText("Group 1, option 1");
    }

    @Test
    public void fillInTwoSelectFieldsByClick() {
        page.navigate("https://demoqa.com/select-menu");
        page.locator("//*[@id='withOptGroup']/div").click();
        page.getByText("Group 1, option 1", new Page.GetByTextOptions().setExact(true)).click();
        page.keyboard().press("Enter");
        assertThat(page.locator(".css-1hwfws3 .css-1uccc91-singleValue")).containsText("Group 1, option 1");
    }



    @Test
    public void oldStyleSelectMenu() throws InterruptedException {
        page.navigate("https://demoqa.com/select-menu");

        page.locator("#oldSelectMenu").selectOption("1");
        assertThat( page.locator("#oldSelectMenu") ).hasValue("1");

        page.locator("#oldSelectMenu").selectOption(new SelectOption().setLabel("Green"));
        assertThat( page.locator("#oldSelectMenu") ).hasValue("2");

        page.locator("#cars").selectOption(new String[] {"volvo", "saab"});
        assertThat( page.locator("#cars") ).hasValue("volvo");
        assertThat( page.locator("#cars") ).hasValues( new String[]{"volvo", "saab"} );
    }
}
