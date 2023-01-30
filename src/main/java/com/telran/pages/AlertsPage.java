package com.telran.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        return this;
    }

    @FindBy(id="timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage clickOnSimpleAlertWithTimer() {
        click(timerAlertButton);

        wait(500);
        //driver.switchTo().alert().accept();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(myAlert.getText());
        myAlert.accept();

        return this;
    }

    @FindBy(id="confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnConfirmBox(String action) {
        click(confirmButton);
        wait(1000);
        if (action == "OK") {
            driver.switchTo().alert().accept();
        }

        if (action == "Cancel") {
            driver.switchTo().alert().dismiss();
        }

        return this;
    }
}
