package com.telran.tests.BookStoreTests;

import com.microsoft.playwright.*;
import com.telran.pages.data.LoginData;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.*;

import java.awt.*;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookStoreLoginPlaywright extends TestBasePR {

    @Test
    void loginTestPR() throws InterruptedException {
        page.navigate("https://demoqa.com/login");
        page.locator("input[id=\"userName\"]").click();
        page.locator("input[id=\"userName\"]").fill(LoginData.USERNAME);
        page.locator("input[id=\"password\"]").click();
        page.locator("input[id=\"password\"]").fill(LoginData.PASSWORD);

        page.locator("button[id=\"login\"]").click();

        assertThat(page.locator("label[id='userName-value']")).containsText(LoginData.USERNAME);
        //Thread.sleep(10000);
    }
}
