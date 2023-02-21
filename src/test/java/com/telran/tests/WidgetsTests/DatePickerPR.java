package com.telran.tests.WidgetsTests;

import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DatePickerPR extends TestBasePR {

    @Test
    public void datePickerTomorrowTest() {
        page.navigate("https://demoqa.com/date-picker");

        page.locator("#datePickerMonthYearInput").click();

        LocalDateTime todayDate = LocalDateTime.now();
        LocalDateTime tomorrowDate = todayDate.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String tomorrowFormated = tomorrowDate.format(formatter);

        page.locator("//div[contains(@class, 'today')]/following-sibling::div[1]").click();
        assertThat(page.locator("#datePickerMonthYearInput")).hasValue(tomorrowFormated);
    }
}
