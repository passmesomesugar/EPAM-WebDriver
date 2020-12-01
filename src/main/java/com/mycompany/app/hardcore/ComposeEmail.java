package com.mycompany.app.hardcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class ComposeEmail extends AbstractCloudGooglePage {
    public static String tempEmail;
    public static Double priceInReceivedEMail;

    public ComposeEmail(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='email']")
    private WebElement copyTemporaryEmailAddress;
    //
    @FindBy(xpath = "//*[@id='color']")
    private WebElement nightMode;
    //
    @FindBy(xpath = "//div[contains(text(), \"Google Cloud Sales\")]")
    private WebElement letterFromCalculator;
    //
    @FindBy(xpath = "*//h3[contains(text(), 'USD')]")
    private WebElement priceInReceivedEmailElement;
    //
    @FindBy(xpath = "//iframe")
    private WebElement iFrame;
    //
    @FindBy(xpath = "//table//h3[contains(text(),\"USD\")]")
    private WebElement totalEstimatedCostPerMonth;

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

    public ComposeEmail openLetter() {
        waitAndClick(letterFromCalculator);
        return this;
    }

    public void getPriceInReceivedEMail() {
        waitForVisibility(iFrame);
        driver.switchTo().frame(0);
        waitForVisibility(totalEstimatedCostPerMonth);
        priceInReceivedEMail = Double.parseDouble(totalEstimatedCostPerMonth
                .getText().replaceAll("[^0-9.]", ""));
    }
}
