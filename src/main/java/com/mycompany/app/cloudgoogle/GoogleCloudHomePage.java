package com.mycompany.app.cloudgoogle;

import com.mycompany.app.icanwin.AbstractPastebinPage;
import org.openqa.selenium.WebDriver;

public class GoogleCloudHomePage extends AbstractGoogleCloudPage {
    protected GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPastebinPage openPage() {
        return null;
    }
}
