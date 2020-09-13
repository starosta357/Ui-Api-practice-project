package ui.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.model.User;

public class AuthenticationPage extends BasePage {

    public static final String BASE_URL = "http://automationpractice.com/index.php?controller=authentication";

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public MyAccountPage enterToTheExistAccount(User user) {
        logger.info(DEFAULT_LOGGER_MESSAGE);

        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        submitLoginButton.click();
        waitForPageLoaded();
        return new MyAccountPage(driver);
    }

    @Override
    public AuthenticationPage openPage() {
        logger.info(DEFAULT_LOGGER_MESSAGE);
        driver.navigate().to(BASE_URL);
        waitForPageLoaded();
        return this;
    }

}
