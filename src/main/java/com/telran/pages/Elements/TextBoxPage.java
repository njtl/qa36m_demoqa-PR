package com.telran.pages.Elements;

import com.telran.pages.PageBase;
import com.telran.pages.data.TextBoxData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

public class TextBoxPage extends PageBase {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName")
    WebElement fullName;

    @FindBy(id="userEmail")
    WebElement email;

    @FindBy(id="currentAddress")
    WebElement currentAddress;



    @FindBy(id="submit")
    WebElement submit;


    public void fillAndSubmitForm() {
        hideAds();

        type(fullName, TextBoxData.FULLNAME);
        type(email, TextBoxData.EMAIL);
        type(currentAddress, TextBoxData.ADDRESS);

        Actions action = new Actions(driver);
        
        Keys cmdCtrl = getCmdCtrl();

        action.keyDown(currentAddress, cmdCtrl).sendKeys("a").keyUp(cmdCtrl).perform();
        action.keyDown(cmdCtrl).sendKeys("c").keyUp(cmdCtrl).perform();
        action.sendKeys(Keys.TAB);
        action.keyDown(cmdCtrl).sendKeys("v").keyUp(cmdCtrl).perform();

        clickWithJSExecutor(submit, 0, 150);
    }

    @FindBy(id="output")
    WebElement output;

    public String checkSubmittedData() {
        return output.getText();
    }

    @FindBy(id="permanentAddress")
    WebElement permanentAddress;

    public String getPermanentAddress() {
        System.out.println("Permanent address is " + permanentAddress.getText());
        return permanentAddress.getText();
    }
}
