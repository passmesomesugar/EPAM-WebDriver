package pageobjectmodel.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjectmodel.page.PastebinHomePage;

public class ICanWinTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "First test,testing test unit")
    public void createPasteBtnTest() {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver)
                .openPage()
                .pasteNewPaste("Hell from WD")
                .setExpirationPeriod("1 Day")
                .nameNewPaste("helloweb")
                .createNewPaste();
    }

    @AfterMethod(alwaysRun = true)
    public void kickBrowser() {
        driver.quit();
        driver = null;
    }
}
