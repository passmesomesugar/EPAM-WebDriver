package com.mycompany.app.cloudgoogle_pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleCalculatorPage extends AbstractCloudGooglePage {
    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    WebElement computeEngine;
    @FindBy(xpath = "//input[contains(@ng-model,'quantity')]")
    WebElement numberOfInstances;

    public CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleCalculatorPage activateComputeEngine() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        waitForVisibility(computeEngine);
        computeEngine.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputNumberOfInstances() {
        waitForVisibility(numberOfInstances);
        numberOfInstances.sendKeys("4");
        return this;
    }

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
