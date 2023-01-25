package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenu extends PageBase {
    public SideMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement loginPageLink;

    public LoginPage openLoginPage() {
        clickWithJSExecutor(loginPageLink, 0, 200);
        wait(500);
        return new LoginPage(driver);
    }
}
