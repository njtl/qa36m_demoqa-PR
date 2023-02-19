package com.telran.tests.ElementsTest;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;
import static org.testng.AssertJUnit.*;


public class UploadAndDownloadPR extends TestBasePR  {

    @Test
    public void downloadTest() {
        page.navigate("https://demoqa.com/upload-download");
        // wait for download to start
        Download download = page.waitForDownload(() -> {
            page.locator("#downloadButton").click();
        });
        // wait for download to complete
        Path path = download.path();

        System.out.println(download.path());
        assertEquals( "sampleFile.jpeg", download.suggestedFilename() );
        //download.saveAs(Paths.get("/path/to/save/download/at.txt"));
    }
}
