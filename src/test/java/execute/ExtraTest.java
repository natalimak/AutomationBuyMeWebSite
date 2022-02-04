package execute;

import screens.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tools.BasePage;
import tools.DriverSingleton;

/**
 * The ExtraTest class include 2 tests.
 * 1-check error message on Login Without Credentials.
 * 2-make ScreenShot of bottom in Gift Screen
 * @author  Natali Makvits
 * @version 1.0
 * @since   01-Feb-2022
 */
import static tools.Constants.*;

public class ExtraTest {
    private static WebDriver driver;

    /**
     * This BeforeClass (runOnceBeforeClass) initialises the web driver
     * @exception Exception On input error.
     * @see Exception
     */
    @BeforeClass
    public static void runOnceBeforeClass() throws Exception {
        driver = DriverSingleton.getDriverInstance();
    }

    /**
     * This LoginWithoutCredentials_Test check error message on Login Without Credentials
     * @see tools.Constants
     * @see @loginPage.openWebSite
     * @see @loginPage.pressRegistration
     * @see @loginPage.pressLogin
     * @exception Exception On input error.
     * @see Exception
     */
    @Test(priority = 1)
    public static void LoginWithoutCredentials_Test() throws Exception {

        LoginPage loginPage = new LoginPage();
        loginPage.openWebSite();
        loginPage.pressRegistration(REGISTRATION_LOCATOR);
        loginPage.pressLogin(LOGIN_LOCATOR);

        //assert Error message when no mail is required
        Assert.assertEquals(driver.findElement(By.cssSelector(NOMAIL_LOCATOR)).getText(),
                "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה");

        //assert Error message when no password is required
        Assert.assertEquals(driver.findElement(By.cssSelector(NOPASSWORD_LOCATOR)).getText(),
                "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה");
    }

    /**
     * This ScreenShot_GiftScreen_Test make ScreenShot of bottom in Gift Screen
     * @see tools.Constants
     * @see @loginPage.openWebSite
     * @see @BasePage.takeScreenShot
     * @exception Exception On input error.
     * @see Exception
     */
    @Test(priority = 2)
    public static void ScreenShot_GiftScreen_Test() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.openWebSite();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        BasePage.takeScreenShot("bottom");
    }
}
