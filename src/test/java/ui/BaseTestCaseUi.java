package ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ui.driver.DriverSingleton;
import ui.util.TestListener;

@Listeners({TestListener.class})
public abstract class BaseTestCaseUi {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
