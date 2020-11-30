package com.mycompany.app.hardcore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
//    public ComposeEmail openIncomingEmail() {
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//        openMailElement.click();
//        return this;
//    }

    public ComposeEmail openLetter() {
        waitAndClick(letterFromCalculator);
        return this;
    }

    public void getPriceInReceivedEMail() {
        waitForVisibility(iFrame);
        driver.switchTo().frame(0);
        waitForVisibility(totalEstimatedCostPerMonth);
//        return Double.parseDouble(totalEstimatedCostPerMonth
//                .getText().replaceAll("[^0-9.]", ""));
        priceInReceivedEMail = Double.parseDouble(totalEstimatedCostPerMonth
                .getText().replaceAll("[^0-9.]", ""));
    }
//    public ComposeEmail getPriceFromReceivedEmail() {
//        WebElement priceInEmail = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'USD')]")));
//        String priceInEmailString = priceInEmail
//                .getText()
//                .replace("USD ", "")
//                .replaceAll("[^0-9.]", "");
//        System.out.println("priceInEmailString: " + priceInEmailString);
//        priceInReceivedEMail = Double.parseDouble(priceInEmailString);
//        System.out.println("priceInReceivedEMail: " + priceInReceivedEMail);
//        return this;
//    }
}
