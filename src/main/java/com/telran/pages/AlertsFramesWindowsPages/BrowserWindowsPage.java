package com.telran.pages.AlertsFramesWindowsPages;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends PageBase {

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="tabButton")
    WebElement newTabButton;

    @FindBy(id="windowButton")
    WebElement newWindowButton;

    @FindBy(id="messageWindowButton")
    WebElement newMessageWindowButton;

    public BrowserWindowsPage openNewTab() {
        click(newTabButton);
        //String thisWindow = driver.getWindowHandle();
        List<String> allWindows = new ArrayList<>(driver.getWindowHandles());
        String tabName = allWindows.get(1);
        driver.switchTo().window(tabName);
        return this;
    }

    @FindBy(id="sampleHeading")
    WebElement newPageHeading;

    public String getNewPageHeading(){
        return newPageHeading.getText();
    }
}
