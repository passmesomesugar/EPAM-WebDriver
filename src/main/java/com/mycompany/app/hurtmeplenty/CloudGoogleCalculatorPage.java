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
    //@FindBy(xpath = "//md-option[@value=\"n1\"]")
    //@FindBy(xpath = "//md-option[@value='n1']")
    @FindBy(xpath = "//*[@id=\"select_option_186\"]")
    private WebElement seriesN1;
    //
    @FindBy(xpath = "//md-select[@placeholder=\"Instance type\"]")
    private WebElement machineType;
    // @FindBy(xpath = "//span/*[@class='md-text ng-binding' and contains(text(),'e2-standard-8 (vCPUs: 8, RAM: 32GB)')]")
    // @FindBy(xpath = "//*[@id='select_value_label_58']")
    // @FindBy(xpath = "//*[@id='select_value_label_58']/span/*")
    // @FindBy(xpath = "//*[@id=\"select_option_234\"]/div[1]/text()")
    //@FindBy(xpath = "//*[@id=\"select_option_236\"]/div[1]")
    @FindBy(xpath = "//md-option[@value=\"CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8\"]")
    private WebElement optionMachineType;
    //
    //
    //
    //
    @FindBy(xpath = "//*[contains(@ng-model,'GPU')]")
    private WebElement GPU;
    //
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    //
    //@FindBy(xpath = "//div[normalize-space()='4']/parent::md-option")
    @FindBy(xpath = "//*[@id=\"select_option_359\"]")
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
    @FindBy(xpath = "//div[normalize-space()='24x375 GB']/parent::md-option")
    private WebElement typeLocalSSD;
    //
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement location;
    //
    @FindBy(xpath = "//md-select-menu[@class='md-overflow']/descendant::div[contains(text(), 'Oregon')]/parent::md-option")
    private WebElement typeLocation;
    //
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsage;
    //
    @FindBy(xpath = "//md-select-menu[contains(@style, 'transform-origin')]//div[text()='1 Year']/parent::md-option")
    private WebElement typeCommittedUsage;
//

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
    //Select seriesDropdown= new Select(driver.findElement(By.name()))

    public CloudGoogleCalculatorPage inputSeries() {
        seriesElement.click();
        seriesN1.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputInstanceType() {
        machineType.click();
        optionMachineType.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputGPU() {
        GPU.click();
        numberOfGPUs.click();
        inputNumberOfGPU.click();
        inputNumberOfGPU.sendKeys(Keys.ENTER);
//        GPUtype.click();
//        inputTypeOfGPU.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputSD() {
        localSSD.click();
        typeLocalSSD.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputLocation() {
        location.click();
        typeLocation.click();
        return this;
    }

    public CloudGoogleCalculatorPage inputCommitedUsage() {
        committedUsage.click();
        typeCommittedUsage.click();
        return this;
    }

    public void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
    }
}
