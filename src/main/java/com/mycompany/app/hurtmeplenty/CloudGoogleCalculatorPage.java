package com.mycompany.app.hurtmeplenty;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

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
    //
    @FindBy(xpath = "//md-select[@placeholder='Series']")
    private WebElement seriesElement;
    //
    //@FindBy(xpath = "//md-option[@value=\"n2d\"]")
    //@FindBy(xpath = "//md-option[@value='\"n1\"']")
    @FindBy(xpath = "//md-option[@value='n1']")
    //@FindBy(xpath = "//*[@id=\"select_option_186\"]")
    //@FindBy(xpath = "//*[@id='select_option_186']")
    private WebElement seriesN1;
    //
    @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
    private WebElement machineType;
    // @FindBy(xpath = "//span/*[@class='md-text ng-binding' and contains(text(),'e2-standard-8 (vCPUs: 8, RAM: 32GB)')]")
    // @FindBy(xpath = "//*[@id='select_value_label_58']")
    // @FindBy(xpath = "//*[@id='select_value_label_58']/span/*")
    // @FindBy(xpath = "//*[@id=\"select_option_234\"]/div[1]/text()")
    //@FindBy(xpath = "//*[@id=\"select_option_236\"]/div[1]")
    //@FindBy(xpath = "//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]") //doesnt work ~ strange
    //@FindBy(xpath = "//*[@id=\"select_option_470\"]")
    @FindBy(xpath = "//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]") //doesnt work ~ strange
    private WebElement optionMachineType;
    //
    //
    //
    //
    @FindBy(xpath = "//*[contains(@ng-model,'GPU')]")
    private WebElement addGPU;
    //
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    //
    @FindBy(xpath = "//div[normalize-space()='1']/parent::md-option")
    //@FindBy(xpath = "//*[@id=\"select_option_359\"]")
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
        click(machineClass);
        //machineClass.click();
        click(regularMachine);
        //regularMachine.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputSeries() {
        waitForVisibility(seriesElement);
        //click(seriesElement); doesnt work
        seriesElement.click(); //works
//        seriesElement.sendKeys(Keys.ENTER); //works
        return this;
    }

    public CloudGoogleCalculatorPage inputSeriesN1() {
        // click(seriesN1); doesnt work with '//md-option[@value='"n1"']'
        // seriesN1.click(); doesnt work with '//md-option[@value='"n1"']'
        // '//*[@id="select_option_186"]' picks 'N2' series,instead of 'N1'
        // '//*[@id='select_option_186']' picks 'N2' series,instead of 'N1'
        // '//md-option[@value='"n1"']' doesnt click anything
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
        // inputNumberOfGPU.sendKeys(Keys.ENTER);
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

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
    }
}