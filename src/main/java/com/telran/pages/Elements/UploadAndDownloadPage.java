package com.telran.pages.Elements;

import com.telran.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadAndDownloadPage extends PageBase {
    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="downloadButton")
    WebElement downloadButton;

    @FindBy(id="uploadFile")
    WebElement uploadFile;

    public boolean verifyDownload() {
        // Clicked -> files is download -> check file exists

        String path = "/users/ilya/downloads/sampleFile.jpeg";
        File f = new File(path);

        if (f.exists()) {
            f.delete();
        }

        click(downloadButton);
        wait(4000);

        if (f.exists()) {
            f.delete();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public UploadAndDownloadPage selectFile() {
        uploadFile.sendKeys("/users/ilya/downloads/sampleFile.jpeg");
        return this;
    }

    @FindBy(id="uploadedFilePath")
    WebElement uploadedFilePath


    public boolean checkFileIsSelected() {
        return uploadedFilePath.isDisplayed();
    }
}
