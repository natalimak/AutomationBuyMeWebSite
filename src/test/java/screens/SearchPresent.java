package screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.BasePage;
import java.time.Duration;
import static tools.Constants.*;

/**
 * The SearchPresent Search present in main screen by price, region, category.
 * and validation if user login to the site.
 * @author  Natali Makvits
 * @version 1.0
 * @since   01-Feb-2022
 */
public class SearchPresent extends BasePage {
    private WebDriver driver;
    private static WebDriverWait wait;
/**
* This constructor initialises the web driver for the SearchPresent class instance
* @exception Exception On input error.
* @see Exception
*/
    public SearchPresent() throws Exception {
        driver = getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /**
     * This method will call for full Search Present process.
     *@exception InterruptedException On input error.
     *@see InterruptedException
     */
    public void SPresent() throws InterruptedException {
       checkMainScreen();

       pickPrice(PICKPRICE_LOCATOR, SEARCHPRICE_LOCATOR);
       pickRegion(PICKREGION_LOCATOR, SEARCHREGION_LOCATOR);
       pickCategory(PICKCATEGORY_LOCATOR, SEARCHCATEGORY_LOCATOR);
       pressSearch();
    }

    /**
     * This method will wait for screen after right login and receive main screen with login account
     * @see tools.Constants
     */
    private void checkMainScreen(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MYACCOUNT_LOCATOR)));
    }


    /**
     * This method will select price from dropdown
     * @param priceLocator - main price dropdown locator
     * @param price - child in dropdown
     * @see tools.Constants
     * @see #dropDownElement
     * @exception InterruptedException On input error.
     * @see InterruptedException
     */
    private void pickPrice(String priceLocator,String price) throws InterruptedException {
        dropDownElement(priceLocator,price); //insert price in search area
    }

    /**
     * This method will select region from dropdown
     * @param regionLocator - main region dropdown locator
     * @param region  - child in dropdown
     * @see tools.Constants
     * @see #dropDownElement
     * @exception InterruptedException On input error.
     * @see InterruptedException
     */
        private void pickRegion(String regionLocator,String region) throws InterruptedException {
        dropDownElement(regionLocator,region);
    }

    /**
     * This method will select category from dropdown
     * @param categoryLocator - main category dropdown locator
     * @param category  - child in dropdown
     * @see tools.Constants
     * @see #dropDownElement
     */
        private void pickCategory(String categoryLocator,String category) throws InterruptedException {
        dropDownElement(categoryLocator,category);
    }

    /**
     * This method will call to other method for click on Search Button
     * @see #clickElement(By)
     * @see tools.Constants
     */
    private void pressSearch(){ //press Search Button
        clickElement(By.cssSelector(SEARCH_LOCATOR));
    }
}
