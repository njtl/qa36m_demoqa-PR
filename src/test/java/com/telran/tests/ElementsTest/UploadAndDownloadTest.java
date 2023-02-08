package com.telran.tests.ElementsTest;

import com.telran.pages.Elements.UploadAndDownloadPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class UploadAndDownloadTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openUploadandDownloadPage();
    }

    // Title: File is downloaded after Download button is clicked
    @Test
    public void clickOnDownloadButton() {
        // Step 1: Click on Download button
        // Expected result: File is downloaded locally
        Assert.assertTrue( new UploadAndDownloadPage(driver).verifyDownload() );
    }

    @Test
    public void selectFileToUpload() throws IOException {
        // Step 1: Click on Download button
        // Expected result: File is downloaded locally
        Assert.assertTrue( new UploadAndDownloadPage(driver).selectFile().checkFileIsSelected() );
    }

}
