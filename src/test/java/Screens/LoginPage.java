package Screens;

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
        pressRegistration();
        newReg();
        enterCredentials(email);
        assertCredentials(email);
        pressLogin();
    }
    /**
     * This method will open web browser
     * @exception Exception On input error.
     * @see Exception
     */
    private void openWebSite() throws Exception {
        driver=getDriver();
        driver.get(BasePage.getData("URL"));
    }
    /**
     * This method will call to other method for click on registration/login button
     * @see #clickElement(By)
     */
    private void pressRegistration() {
        clickElement(By.cssSelector(REGISTRATION_LOCATOR));
    }

    /**
     * This method will call to other method for click on registration link
     * @see #clickElement(By)
     */
    private void newReg() {
        clickElement(By.cssSelector(NEWREG_LOCATOR));
    }

    /**
     * This method will call to other method for click on registration link
     *          All parameters of locators and text in fields getting from #tools.Constants
     * @param email generated random email for creating new user.
     * @see #sendKeysToElement(By, String)
     * @see tools.Constants
     */
    private void enterCredentials(String email){
        sendKeysToElement(By.id(USERNAME_LOCATOR), NAME); //insert username
        sendKeysToElement(By.id(EMAIL_LOCATOR), email); //insert email
        sendKeysToElement(By.id(PASSWORD_LOCATOR), PASS); //insert password
        sendKeysToElement(By.id(PASSAGAIN_LOCATOR), PASS); //insert password again
    }

    /**
     * This method will assert data in all text fields
     *          All parameters of locators and text in fields getting from #tools.Constants
     * @param email for creating new user.
     * @see tools.Constants
     */
    private void assertCredentials(String email){
        Assert.assertEquals(driver.findElement(By.id(USERNAME_LOCATOR)).getAttribute("value"),
                NAME); //assert USERNAME value
        Assert.assertEquals(driver.findElement(By.id(EMAIL_LOCATOR)).getAttribute("value"),
                email); //assert EMAIL value
        Assert.assertEquals(driver.findElement(By.id(PASSWORD_LOCATOR)).getAttribute("value"),
                PASS); //assert PASSWORD value
        Assert.assertEquals(driver.findElement(By.id(PASSAGAIN_LOCATOR)).getAttribute("value"),
                PASS); //assert PASSWORD AGAIN FIELD value
    }
    /**
     * This method will call to other method for click on
     *              login button in end of registration process
     * @see #clickElement(By)
     */
    private void pressLogin(){
        clickElement(By.cssSelector(REGBUTTON_LOCATOR));
    }


}
