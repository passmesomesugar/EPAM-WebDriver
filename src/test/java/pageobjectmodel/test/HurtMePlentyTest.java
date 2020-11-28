package pageobjectmodel.test;

import com.mycompany.app.hurtmeplenty.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class HurtMePlentyTest {
    private WebDriver driver;
    private final int TIMEOUT_TWENTY = 20;

    @BeforeTest(alwaysRun = true)
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
                .inputSeries()
                .inputSeriesN1()
                .inputInstanceType()
                .inputGPU()
                .inputSSD()
                .inputLocation()
                .inputCommitedUsage()
                .addToEstimate();
    }

    @Test(dependsOnMethods = "openPage")
    public void checkMachineClass() {
        WebElement testMachineClass = driver.findElement(By.xpath("//md-list-item/div[contains(text(),'VM class')]"));
        Assert.assertTrue(testMachineClass.getText().contains("regular"), "Machine class displayed wrong");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkInstanceType() {
        WebElement testInstanceType = driver.findElement(By.xpath("//md-list-item/div[contains(text(),'Instance type')]"));
        Assert.assertTrue(testInstanceType.getText().contains("n1-standard-8"), "Instance Type displayed wrong");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkRegion() {
        WebElement testRegion = driver.findElement(By.xpath("//md-list-item/div[contains(text(),'Region')]"));
        Assert.assertTrue(testRegion.getText().contains("Iowa"), "Region Type displayed wrong");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkSSD() {
        WebElement testSSD = driver.findElement(By.xpath("//md-list-item/div[contains(text(),'SSD')]"));
        Assert.assertTrue(testSSD.getText().contains("2x375"), "SSD Type displayed wrong");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkCommitmentTerm() {
        WebElement testTerm = driver.findElement(By.xpath("//md-list-item/div[contains(text(),'Commitment term')]"));
        Assert.assertTrue(testTerm.getText().contains("1"), "Commitment term shows wrong");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkEstimateCost() {
        WebElement testCost = driver.findElement(By.xpath("//md-content[@id='compute']//b"));
        Assert.assertTrue(testCost.getText().contains("5,413.06"), "Cost displayed wrong");
    }

    @AfterTest(alwaysRun = true)
    public void kickBrowser() {
//        driver.quit();
//        driver = null;
    }
}
