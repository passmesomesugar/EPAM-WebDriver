package com.mycompany.app.cloudgoogle;

import com.mycompany.app.icanwin.AbstractPastebinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractGoogleCloudPage {
    protected WebDriver driver;
    public static final String HOMEPAGE_URL = "https://cloud.google.com/";

    protected abstract AbstractPastebinPage openPage();

    protected AbstractGoogleCloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
