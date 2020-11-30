package pageobjectmodel.test;

import com.mycompany.app.hardcore.CloudGoogleCalculatorPage;
import com.mycompany.app.hardcore.CloudGoogleHomePage;
import com.mycompany.app.hardcore.ComposeEmail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HardcoreTest {
    public WebDriver driver;
    private final int TIMEOUT_TWENTY = 20;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT_TWENTY, SECONDS);
        driver.manage().timeouts().implicitlyWait(TIMEOUT_TWENTY, SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "Hardcore task test")
    public void openPage() {
        CloudGoogleCalculatorPage cloudGoogleCalculatorPage = new CloudGoogleHomePage(driver)
                .startPage()
                .cloudSearchPage()
                .activateComputeEngine()
                .inputNumberOfInstances()
                .inputOS()
                .inputMachineClass()
                .inputSeries()
                .inputSeriesN1()
                .inputInstanceType()
                .inputGPU()
                .inputSSD()
                .inputLocation()
                .inputCommitedUsage()
                .addToEstimate()
                .emailEstimate()
                .openNewTab();
        //
        ComposeEmail mailService = new ComposeEmail(driver)
                .getToTempMailServiceHomePage()
                .turnTheNightModeOn()
                .copyTemporaryEmail();
        //
        cloudGoogleCalculatorPage
                .inputEmailAddress()
                .sendEmail()
                .getPriceFromCalculator()
        ;
        mailService
                .openIncomingEmail();
                //.getPriceFromReceivedEmail();
    }
//    @Test(dependsOnMethods = "openPage")
//    public void assureSamePrice() {
//        Assert.assertEquals(ComposeEmail.priceInReceivedEMail, CloudGoogleCalculatorPage.priceOnCalcPage, "Prices received in email and generated on calc page are same");
//    }

    @AfterTest(alwaysRun = true)
    public void kickBrowser() {
//        driver.quit();
//        driver = null;
    }
}
