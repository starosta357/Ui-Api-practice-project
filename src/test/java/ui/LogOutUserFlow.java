package ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.model.User;
import ui.page.MainPage;
import ui.util.UserCreator;

public class LogOutUserFlow extends BaseTestCaseUi {

    @Test
    public void checkLogOutForPredefinedUser() {
        User user = UserCreator.withCredentialsFromProperty();

        boolean isUserSingOut = new MainPage(driver)
                .openPage()
                .goToAuthenticationPage()
                .enterToTheExistAccount(user)
                .signOut()
                .singInButtonIsPresent();

        Assert.assertTrue(isUserSingOut,
                "After the log out action sign in button must be present");
    }

}
