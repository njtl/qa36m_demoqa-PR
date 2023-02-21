package com.telran.tests.WidgetsTests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MenuTestPR extends TestBasePR {

    @Test
    public void checkSubSubMenu(){
        page.navigate("https://demoqa.com/menu");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Main Item 2")).hover();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SUB SUB LIST »")).hover();
        assertThat( page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sub Sub Item 1")) ).isVisible();
    }
}
