package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName")
    WebElement username;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login")
    WebElement loginButton;

    public ProfilePage login(String uName, String uPass){
        type(username, uName);
        type(password, uPass);
        click(loginButton);
        return new ProfilePage(driver);
    }

    @FindBy(id="name")
    WebElement errorMsg;
    public String getErrorMessage() {
        return errorMsg.getText();
    }
}
