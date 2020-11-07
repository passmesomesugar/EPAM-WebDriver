package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICanWinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void createPasteBtnTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com/");
        driver.manage().window().maximize();
//
        WebElement pasteBin = driver.findElement(By.xpath("//*[@id=\"postform-text\"]"));
        pasteBin.sendKeys("Hello from WD");
//
        WebElement element = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[2]/div/span"));
        element.click();
        WebElement element2 = driver.findElement(By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"));
        element2.click();
//
        WebElement titleElement = driver.findElement(By.xpath("//*[@id=\"postform-name\"]"));
        titleElement.sendKeys("helloweb");
//
        WebElement createPasteBtn = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button"));
        createPasteBtn.click();
        //Assert.assertTrue();
    }

    @AfterMethod(alwaysRun = true)
    public void kickBrowser() {
        driver.quit();
        driver = null;
    }
}
