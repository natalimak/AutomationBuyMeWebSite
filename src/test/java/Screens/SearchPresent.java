//validation if user login to the site.
// Search present in main screen by price, region, category.
package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.BasePage;

import java.time.Duration;

import static tools.Constants.*;

public class SearchPresent extends BasePage {
    private WebDriver driver;
    private static WebDriverWait wait;

    public SearchPresent() throws Exception {
        driver = getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public void SPresent() throws InterruptedException {
       checkMainScreen();

       pickPrice(PICKPRICE_LOCATOR, SEARCHPRICE_LOCATOR);
       pickRegion(PICKREGION_LOCATOR, SEARCHREGION_LOCATOR);
       pickCategory(PICKCATEGORY_LOCATOR, SEARCHCATEGORY_LOCATOR);
       pressSearch();
    }

    private void checkMainScreen(){  //check right login and receive main screen with login account
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(MYACCOUNT_LOCATOR)));

    }
    private void pickPrice(String priceLocator,String price) throws InterruptedException {
        dropDownElement(priceLocator,price); //insert price in search area
    }
    private void pickRegion(String regionLocator,String region) throws InterruptedException {
        dropDownElement(regionLocator,region); //insert region in search area
    }
    private void pickCategory(String categoryLocator,String category) throws InterruptedException {
        dropDownElement(categoryLocator,category); //insert category in search area
    }
    private void pressSearch(){ //press Search Button
        clickElement(By.cssSelector(SEARCH_LOCATOR));
    }
}
