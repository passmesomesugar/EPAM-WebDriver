package com.mycompany.app.icanwin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PastebinHomePage extends AbstractPastebinPage {
    @FindBy(xpath = "//textarea[@name='PostForm[text]']")
    private WebElement newPasteTextArea;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PastebinHomePage pasteNewPaste(String pasteBinString) {
        newPasteTextArea.sendKeys(pasteBinString);
        return this;
    }

    public PastebinHomePage setExpirationPeriod(String expirationPeriod) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[2]/div/span"));
        element.click();
        String expirationPeriodXPath = "//li[text()='" + expirationPeriod + "']";
        WebElement element2 = driver.findElement(By.xpath(expirationPeriodXPath));
        element2.click();
        return this;
    }

    public PastebinHomePage nameNewPaste(String pasteBinNameString) {
        WebElement nameElement = driver.findElement(By.xpath("//*[@id=\"postform-name\"]"));
        nameElement.sendKeys(pasteBinNameString);
        return this;
    }

    public PastebinHomePage createNewPaste() {
        WebElement createPasteBtn = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button"));
        createPasteBtn.click();
        return this;
    }
}
