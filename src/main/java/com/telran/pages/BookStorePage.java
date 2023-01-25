package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class BookStorePage extends PageBase {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]")
    WebElement loginPageLink;

    public LoginPage openLoginPage() {
        clickWithJSExecutor(loginPageLink, 0, 200);
        this.wait(500);
        return new LoginPage(driver);
    }



    @FindBy(id="searchBox")
    WebElement searchBox;

    public void searchBook(String web) {
        type(searchBox, web);
        wait(500);
    }

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[2]/div/span/a")
    WebElement firstBook;

    public String getFirstBookTitle() {
        return firstBook.getText();
    }
}
