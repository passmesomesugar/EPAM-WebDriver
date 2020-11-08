package pageobjectmodel.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPastebinPage {
    private WebDriver driver;

    protected abstract AbstractPastebinPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPastebinPage(WebDriver driver) {
        this.driver = driver;
    }
}
