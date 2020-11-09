package pageobjectmodel.test;

import com.mycompany.app.hurtmeplenty.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HurtMePlentyTest {
    private WebDriver driver;
    private final int TIMEOUT_TWENTY = 20;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT_TWENTY, SECONDS);
        driver.manage().timeouts().implicitlyWait(TIMEOUT_TWENTY, SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "'Hurt me plenty' task test")
    public void openPage() {
        CloudGoogleCalculatorPage homePage = new CloudGoogleHomePage(driver)
                .startPage()
                .cloudSearchPage()
                .activateComputeEngine()
                .inputNumberOfInstances()
                .inputOS()
                .inputMachineClass()
                .inputInstanceType()
                .inputGPU()
                ;
    }

    @AfterMethod(alwaysRun = true)
    public void kickBrowser() {
//        driver.quit();
//        driver = null;
    }
}
