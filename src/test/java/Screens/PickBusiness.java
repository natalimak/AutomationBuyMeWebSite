package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.BasePage;
import java.time.Duration;
import static tools.Constants.*;

public class PickBusiness extends BasePage {
    private WebDriver driver;
    private static WebDriverWait wait;

    public PickBusiness() throws Exception {
        driver = getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void PBusiness(){

        assertURL();
        pickBusiness();
        enterPrice();
        choice();
    }

    private void assertURL(){
        Assert.assertEquals(driver.getCurrentUrl(), SEARCHURL_LOCATOR); //assert Search URL
        //todo check type of exception
    }
    private void pickBusiness() {
        clickElement(By.cssSelector(BUSINESS_LOCATOR));
    }
    private void enterPrice() {
        sendKeysToElement(By.cssSelector(PRESENTPRICE_LOCATOR),PRESENAMOUNT);
    }
    private void choice() {
        clickElement(By.cssSelector(CHOICEBUTTON_LOCATOR));
    }
}
