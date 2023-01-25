package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div/div[6]")
    WebElement bookStoreAppLink;

    public BookStorePage openBookStoreApp(){
        clickWithJSExecutor(bookStoreAppLink, 0, 300);

        return new BookStorePage(driver);
    }
}
