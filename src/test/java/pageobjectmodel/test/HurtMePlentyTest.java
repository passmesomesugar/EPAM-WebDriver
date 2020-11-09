package pageobjectmodel.test;

import com.mycompany.app.cloudgoogle_pageobjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HurtMePlentyTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "'Hurt me plenty' task test")
    public void openPage() {
        CloudGoogleCalculatorPage homePage = new CloudGoogleHomePage(driver)
                .startPage()
                .cloudSearchPage()
                .activateComputeEngine() 
                .inputNumberOfInstances();
    }

    @AfterMethod(alwaysRun = true)
    public void kickBrowser() {
        //driver.quit();
        //driver = null;
    }
}
