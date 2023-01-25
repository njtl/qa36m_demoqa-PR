package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath="//*[@id=\"submit\"]")
    WebElement logOutButton;

    public LoginPage logout() {
        click(logOutButton);
        return new LoginPage(driver);
    }

    @FindBy(id="userName-value")
    WebElement userNameValue;

    public String getUserNameValue() {
        return userNameValue.getText();
    }
}
