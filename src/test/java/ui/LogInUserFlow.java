package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.model.User;
import ui.page.MainPage;
import ui.page.MyAccountPage;
import ui.util.UserCreator;

public class LogInUserFlow extends BaseTestCaseUi {

    @Test
    public void checkLogInForPredefinedUser() {
        User user = UserCreator.withCredentialsFromProperty();

        String actualUrl = new MainPage(driver)
                .openPage()
                .goToAuthenticationPage()
                .enterToTheExistAccount(user)
                .getUrl();

        Assert.assertEquals(actualUrl, MyAccountPage.BASE_URL,
                "After log in " + MyAccountPage.BASE_URL + " must be open");
    }

}
