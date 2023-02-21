package com.telran.tests.InteractionsTests;

import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class DroppableTestPR extends TestBasePR {

    @Test
    public void droppable() {
        page.navigate("https://demoqa.com/droppable");

        page.locator("#draggable").dragTo(page.locator("#droppableExample-tabpane-simple #droppable"));
        assertThat( page.locator("#droppableExample-tabpane-simple #droppable") ).containsText("Dropped!");
    }
}
