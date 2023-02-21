package com.telran.tests.ElementsTest;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SliderTestPR extends TestBasePR {

    @Test
    public void moveSliderKeyboard(){
        page.navigate("https://demoqa.com/slider");

        Locator slider = page.locator("#sliderContainer > div.col-9 > span > input");

        slider.focus();

        while ( Integer.valueOf( slider.getAttribute("value")) < 40 )
        {
            slider.press("ArrowRight");
        }

        assertThat( page.locator("#sliderContainer > div.col-9 > span > input") ).hasValue("40");
    }

    @Test
    public void moveSliderMouseClick(){
        page.navigate("https://demoqa.com/slider");

        Locator slider = page.locator("#sliderContainer > div.col-9 > span > input");

        BoundingBox box = slider.boundingBox();

        page.mouse().click(box.x + box.width / 100 * 40, box.y + box.height / 2);

        assertThat( page.locator("#sliderContainer > div.col-9 > span > input") ).hasValue("40");
    }


}
