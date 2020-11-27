package com.mycompany.app.hardcore;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        return this;
    }
}
