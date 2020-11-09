package com.mycompany.app.icanwin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPastebinPage {
    protected WebDriver driver;
    public static final String HOMEPAGE_URL = "https://pastebin.com/";

    protected abstract AbstractPastebinPage openPage();

    protected AbstractPastebinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
