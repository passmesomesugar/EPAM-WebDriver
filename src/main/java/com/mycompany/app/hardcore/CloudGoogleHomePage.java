package com.mycompany.app.hardcore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleHomePage extends AbstractCloudGooglePage {
    @FindBy(xpath = "//input[@name='q']")
    WebElement searchBar;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleSearchPage startPage() {
        driver.get(HOMEPAGE_URL);
        searchBar.sendKeys("Google Cloud Platform Pricing Calculator");
        searchBar.sendKeys(Keys.ENTER);
        return new CloudGoogleSearchPage(driver);
    }
}
