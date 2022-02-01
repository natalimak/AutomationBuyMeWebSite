package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.BasePage;
import java.time.Duration;
import static tools.Constants.*;
/**
 * The PickBusiness class is Choice Business process after login.
 *      1) assert that user login to website.
 *      2) Pick Business.
 *      3) Enter Price in Business screen.
 *      3) choice Next to Send screen.
 * @author  Natali Makvits
 * @version 1.0
 * @since   01-Feb-2022
 */
public class PickBusiness extends BasePage {
    private WebDriver driver;
    private static WebDriverWait wait;

    /**
     * This constructor initialises the web driver for the PickBusiness class instance
     * @exception Exception On input error.
     * @see Exception
     */
    public PickBusiness() throws Exception {
        driver = getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    /**
     * This method will call for PickBusiness process.
     */
    public void PBusiness(){
        assertURL();
        pickBusiness();
        enterPrice();
        choice();
    }
    /**
     * This method will assert URL`s (current and expected - by search categories)
     * @see tools.Constants
     */
    private void assertURL(){
        Assert.assertEquals(driver.getCurrentUrl(), SEARCHURL_LOCATOR); //assert Search URL
    }
    /**
     * This method will call to other method for click on Business
     * @see #clickElement(By)
     * @see tools.Constants
     */
    private void pickBusiness() {
        clickElement(By.cssSelector(BUSINESS_LOCATOR));
    }
    /**
     * This method will call to other method for insert present amount
     * @see #sendKeysToElement(By, String)
     * @see tools.Constants
     */
    private void enterPrice() {
        sendKeysToElement(By.cssSelector(PRESENTPRICE_LOCATOR),PRESENAMOUNT);
    }

    /**
     * This method will call to other method for click on Choice button
     * @see #clickElement(By)
     * @see tools.Constants
     */
    private void choice() {
        clickElement(By.cssSelector(CHOICEBUTTON_LOCATOR));
    }
}
