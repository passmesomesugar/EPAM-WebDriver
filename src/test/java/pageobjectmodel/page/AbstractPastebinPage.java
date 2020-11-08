package pageobjectmodel.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPastebinPage {
    protected WebDriver driver;

    protected abstract AbstractPastebinPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPastebinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
