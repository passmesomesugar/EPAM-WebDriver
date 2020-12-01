package com.mycompany.app.hardcore;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CloudGoogleCalculatorPage extends AbstractCloudGooglePage {
    public CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public static Double priceOnCalcPage;
    static ArrayList<String> tabs;
    //
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
    //
    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesElement;
    //
    @FindBy(xpath = "//md-option[@value='n1']")
    private WebElement seriesN1;
    //
    @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
    private WebElement machineType;
    //
    @FindBy(xpath = "//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]") //doesnt work ~ strange
    private WebElement optionMachineType;
    //
    @FindBy(xpath = "//*[contains(@ng-model,'GPU')]")
    private WebElement addGPU;
    //
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    //
    @FindBy(xpath = "//div[normalize-space()='1']/parent::md-option")
    private WebElement inputNumberOfGPU;
    //
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement GPUtype;
    //
    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement inputTypeOfGPU;
    //
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSD;
    //
    @FindBy(xpath = "//div[normalize-space()='2x375 GB']/parent::md-option")
    private WebElement typeLocalSSD;
    //
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement location;
    //
    @FindBy(xpath = "//md-select-menu[@class='md-overflow']/descendant::div[contains(text(), 'Iowa')]/parent::md-option")
    private WebElement typeLocation;
    //
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsage;
    //
    @FindBy(xpath = "//md-select-menu[contains(@style, 'transform-origin')]//div[text()='1 Year']/parent::md-option")
    private WebElement typeCommittedUsage;
    //
    @FindBy(xpath = "//*[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimate;
    //
    @FindBy(xpath = "//*[contains(text(),'Email Estimate')]")
    private WebElement emailEstimateElement;
    //
    @FindBy(xpath = "//*[@id='email']")
    private WebElement temporaryEmailCopyAddress;
    //
    @FindBy(xpath = "//*[@id='color']")
    private WebElement nightMode;
    //
    @FindBy(xpath = "//input[@type='email']")
    WebElement buttonInputMail;
    //
    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement buttonSendEmail;

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
        click(machineClass);
        click(regularMachine);
        return this;
    }

    public CloudGoogleCalculatorPage inputSeries() {
        waitForVisibility(seriesElement);
        seriesElement.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputSeriesN1() {
        waitForVisibility(seriesN1);
        seriesN1.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputInstanceType() {
        waitForVisibility(machineType);
        machineType.click();
        waitForVisibility(optionMachineType);
        optionMachineType.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputGPU() {
        waitForVisibility(addGPU);
        addGPU.click();
        waitForVisibility(numberOfGPUs);
        numberOfGPUs.click();
        waitForVisibility(inputNumberOfGPU);
        inputNumberOfGPU.click();
        click(inputNumberOfGPU);
        waitForVisibility(GPUtype);
        GPUtype.click();
        waitForVisibility(inputTypeOfGPU);
        inputTypeOfGPU.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputSSD() {
        waitForVisibility(localSSD);
        localSSD.click();
        waitForVisibility(typeLocalSSD);
        typeLocalSSD.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputLocation() {
        waitForVisibility(location);
        location.click();
        waitForVisibility(typeLocation);
        typeLocation.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputCommitedUsage() {
        waitForVisibility(committedUsage);
        committedUsage.click();
        waitForVisibility(typeCommittedUsage);
        typeCommittedUsage.click();
        return this;
    }

    public CloudGoogleCalculatorPage addToEstimate() {
        waitForVisibility(addToEstimate);
        addToEstimate.click();
        return this;
    }

    public CloudGoogleCalculatorPage emailEstimate() {
        emailEstimateElement.click();
        return this;
    }

    public CloudGoogleCalculatorPage openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }

    public void moveToEmail() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public CloudGoogleCalculatorPage inputEmailAddress() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        buttonInputMail.sendKeys(Keys.CONTROL + "v");
        return this;
    }

    public CloudGoogleCalculatorPage sendEmail() {
        buttonSendEmail.click();
        return this;
    }

    public CloudGoogleCalculatorPage getPriceFromCalculator() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        WebElement priceCalculator = new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]")));
        String priceString = priceCalculator
                .getText()
                .replace("1 month", "")
                .replaceAll("[^0-9.]", "");
        priceOnCalcPage = Double.parseDouble(priceString);
        return this;
    }

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitAndClick(WebElement element) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}