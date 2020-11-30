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
    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/main/div/div[2]/ul/li/a/div/div[1]/div[2]")
    private WebElement openMailElement;
    //
    @FindBy(xpath = "*//h3[contains(text(), 'USD')]")
    private WebElement priceInReceivedEmailElement;

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

    public ComposeEmail openIncomingEmail() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        openMailElement.click();
        return this;
    }

    public ComposeEmail getPriceFromReceivedEmail() {
        WebElement priceInEmail = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(), 'USD')]")));
        String priceInEmailString = priceInEmail
                .getText()
                .replace("USD ", "")
                .replaceAll("[^0-9.]", "");
        System.out.println("priceInEmailString: " + priceInEmailString);
        priceInReceivedEMail = Double.parseDouble(priceInEmailString);
        System.out.println("priceInReceivedEMail: " + priceInReceivedEMail);
        return this;
    }
}
