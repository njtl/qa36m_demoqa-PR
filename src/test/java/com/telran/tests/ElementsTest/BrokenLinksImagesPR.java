package com.telran.tests.ElementsTest;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.telran.tests.TestBasePR;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BrokenLinksImagesPR extends TestBasePR {

    @Test
    public void checkLinks()
    {
        page.navigate("https://demoqa.com/broken");
        for (Locator row : page.getByRole(AriaRole.LINK).all()) {
            System.out.println(row.textContent());
            APIResponse response = page.request().get(row.getAttribute("href"));
            assertThat(response).isOK();
        }
    }

    @Test
    public void checkImagesPR() throws URISyntaxException {
        page.navigate("https://demoqa.com/broken");
        for (Locator row : page.getByRole(AriaRole.IMG).all()) {
            System.out.println(row.textContent());
            String src = row.getAttribute("src");
            URI uri = new URI( page.url() );
            if ( !src.startsWith("http") ) src = uri.getScheme() + "://" + uri.getHost()  + src;

            APIResponse response = page.request().get(src);

            assertThat(response).isOK();

            assertTrue(response.headers().get("content-type").contains("image"), "Failed to verify that content-type header contains image");
            assertFalse(row.evaluate("node => node.naturalWidth").equals(0) , "Failed to verify that image naturalWidth > 0");
        }


    }


}
