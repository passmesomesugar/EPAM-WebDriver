package com.mycompany.app.hurtmeplenty;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleCalculatorPage extends AbstractCloudGooglePage {
    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngine;
    //
    @FindBy(xpath = "//input[contains(@ng-model,'quantity')]")
    private WebElement numberOfInstances;
    //
    @FindBy(xpath = "//label[text()='Operating System / Software']/../md-select")
    private WebElement operatingSystem;
    //
    @FindBy(xpath = "//md-option[@value='free']")
    private WebElement optionFreeOS;
    //
    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClass;
    //
    @FindBy(xpath = "//md-select-menu[@style=contains(text(), '')]/descendant::md-option[@value='regular']")
    private WebElement regularMachine;

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

    public CloudGoogleCalculatorPage inputOS() {
        operatingSystem.click();
        optionFreeOS.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputMachineClass() {
        machineClass.click();
        regularMachine.click();
        return this;
    }

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
