package com.mycompany.app.cloudgoogle_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractCloudGooglePage {
    protected WebDriver driver;
    public static final String HOMEPAGE_URL = "https://cloud.google.com/";

    protected AbstractCloudGooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
