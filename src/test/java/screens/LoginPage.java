package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tools.BasePage;
import static tools.Constants.*;

/**
 * The LoginPage class is login process to BuyMe website,
 *      that include all sub methods that use for login and create user.
 *      1) open website
 *      2) registration in site
 *      3) check credentials in fields text
 *      3) login
 * @author  Natali Makvits
 * @version 1.0
 * @since   01-Feb-2022
 */
public class LoginPage extends BasePage {
    private WebDriver driver;

    /**
     * This constructor initialises the web driver for the LoginPage class instance
     * @exception Exception On input error.
     * @see Exception
     */
    public LoginPage() throws Exception {
        driver = getDriver();
   }
    /**
     * This method will call for Registration and login process
     * @exception Exception On input error.
     * @see Exception
     */
    public void login() throws Exception {
        String email=generateRandomEmail(10);
        openWebSite();
        pressRegistration(REGISTRATION_LOCATOR);
        newReg(NEWREG_LOCATOR);
        enterCredentials(email);
        assertCredentials(email);
        pressLogin(REGBUTTON_LOCATOR);
    }
    /**
     * This method will open web browser
     * @exception Exception On input error.
     * @see Exception
     */
    public void openWebSite() throws Exception {
        driver=getDriver();
        driver.get(BasePage.getData("URL"));
        driver.manage().window().maximize();
    }
    /**
     * This method will call other method for click on registration/login button
     * @param locator -registration button locator
     * @see #clickElement(By)
     */
    public void pressRegistration(String locator) {
        clickElement(By.cssSelector(locator));
    }

    /**
     * This method will call to other method for click on registration link
     * @param locator - login button locator
     * @see #clickElement(By)
     */
    private void newReg(String locator) {
        clickElement(By.cssSelector(locator));
    }

    /**
     * This method will call other method for click on registration link
     *          All parameters of locators and text in fields getting from #tools.Constants
     * @param email generated random email for creating new user.
     * @see #sendKeysToElement(By, String)
     * @see tools.Constants
     */
    private void enterCredentials(String email){
        sendKeysToElement(By.cssSelector(USERNAME_LOCATOR), NAME); //insert username
        sendKeysToElement(By.cssSelector(EMAIL_LOCATOR), email); //insert email
        sendKeysToElement(By.cssSelector(PASSWORD_LOCATOR), PASS); //insert password
        sendKeysToElement(By.cssSelector(PASSAGAIN_LOCATOR), PASS); //insert password again
    }

    /**
     * This method will assert data in all text fields
     *          All parameters of locators and text in fields getting from #tools.Constants
     * @param email for creating new user.
     * @see tools.Constants
     */
    private void assertCredentials(String email){
        Assert.assertEquals(driver.findElement(By.cssSelector(USERNAME_LOCATOR)).getAttribute("value"),
                NAME); //assert USERNAME value
        Assert.assertEquals(driver.findElement(By.cssSelector(EMAIL_LOCATOR)).getAttribute("value"),
                email); //assert EMAIL value
        Assert.assertEquals(driver.findElement(By.cssSelector(PASSWORD_LOCATOR)).getAttribute("value"),
                PASS); //assert PASSWORD value
        Assert.assertEquals(driver.findElement(By.cssSelector(PASSAGAIN_LOCATOR)).getAttribute("value"),
                PASS); //assert PASSWORD AGAIN FIELD value
    }
    /**
     * This method will call to other method for click on
     *              login button in end of registration process
     * @param locator -login button locator
     * @see #clickElement(By)
     */
    public void pressLogin(String locator){
        clickElement(By.cssSelector(locator));
    }


}
