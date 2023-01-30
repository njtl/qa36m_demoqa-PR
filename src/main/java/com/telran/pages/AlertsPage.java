package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends PageBase {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="alertButton")
    WebElement alertButton;

    public AlertsPage clickOnSimpleAlert() {
        click(alertButton);
        wait(1000);
        driver.switchTo().alert().accept();
        return new AlertsPage(driver);
    }
}
