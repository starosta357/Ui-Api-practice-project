package ui.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    public static final String BASE_URL = "http://automationpractice.com/index.php?controller=my-account";

    @FindBy(xpath = "//div[@class='nav']//div[@class='header_user_info']" +
            "/a[contains(text(),'Sign out') and @title='Log me out']")
    private WebElement signOutButton;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public MainPage signOut() {
        logger.info(DEFAULT_LOGGER_MESSAGE);

        signOutButton.click();
        waitForPageLoaded();
        return new MainPage(driver);
    }

    @Override
    public MyAccountPage openPage() {
        logger.info(DEFAULT_LOGGER_MESSAGE);
        driver.navigate().to(BASE_URL);
        waitForPageLoaded();
        return this;
    }

}
