package com.mycompany.app.hurtmeplenty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public abstract class AbstractCloudGooglePage {
    protected WebDriver driver;
    public static final String HOMEPAGE_URL = "https://cloud.google.com/";

    protected AbstractCloudGooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
