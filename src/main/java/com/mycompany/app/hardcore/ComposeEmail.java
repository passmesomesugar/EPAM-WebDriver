package com.mycompany.app.hardcore;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ComposeEmail extends AbstractCloudGooglePage {
    public static String tempEmail;

    public ComposeEmail(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='email']")
    private WebElement copyTemporaryEmailAddress;
    //
    @FindBy(xpath = "//*[@id='color']")
    private WebElement nightMode;
    //

    public ComposeEmail getToTempMailServiceHomePage() {
        driver.get("https://mail.tm/ru");
        return this;
    }

    public ComposeEmail turnTheNightModeOn() {
        waitAndClick(nightMode);
        return this;
    }

    public ComposeEmail copyTemporaryEmail() {
        waitAndClick(copyTemporaryEmailAddress);
        return this;
    }
}
