package ui.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    public static final String BASE_URL = "http://automationpractice.com/index.php";

    //I don't know your project's approach but this xpath check not only text
    // but also location of the element. Yes, it can be smaller
    @FindBy(xpath = "//div[@class='nav']//div[@class='header_user_info']" +
            "/a[contains(text(),'Sign in') and @title='Log in to your customer account']")
    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public AuthenticationPage goToAuthenticationPage() {
        logger.info(DEFAULT_LOGGER_MESSAGE);
        signInButton.click();
        waitForPageLoaded();
        return new AuthenticationPage(driver);
    }

    @Step
    public boolean singInButtonIsPresent() {
        logger.info(DEFAULT_LOGGER_MESSAGE);
        return signInButton.isDisplayed();
    }

    @Override
    public MainPage openPage() {
        logger.info(DEFAULT_LOGGER_MESSAGE);
        driver.navigate().to(BASE_URL);
        waitForPageLoaded();
        return this;
    }

}
