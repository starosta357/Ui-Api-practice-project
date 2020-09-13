package ui.page;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    protected static final int WAIT_TIMEOUT = 3;
    protected static final String DEFAULT_LOGGER_MESSAGE = "step is executing";
    protected Logger logger = LogManager.getRootLogger();
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step
    protected abstract BasePage openPage();

    public void waitForPageLoaded() {
        new WebDriverWait(driver, WAIT_TIMEOUT).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    @Step
    public String getUrl() {
        return this.driver.getCurrentUrl();
    }

}
