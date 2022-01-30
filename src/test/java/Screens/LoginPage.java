package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tools.BasePage;

import static tools.Constants.*;

public class LoginPage extends BasePage {
    private WebDriver driver;

    public LoginPage() throws Exception {
        driver = getDriver();
   }

    public void login() throws Exception {
        openWebSite();
        pressRegistration();
        newReg();
        enterCredentials();
        assertCredentials();
        pressLogin();
    }

    private void openWebSite() throws Exception {
        driver=getDriver();
        driver.get(BasePage.getData("URL"));
    }
    private void pressRegistration() {
        clickElement(By.cssSelector(REGISTRATION_LOCATOR));
    }
    private void newReg() {
        clickElement(By.cssSelector(NEWREG_LOCATOR));
    }
    private void enterCredentials(){
        sendKeysToElement(By.id(USERNAME_LOCATOR), NAME); //insert username
        sendKeysToElement(By.id(EMAIL_LOCATOR), ADRESS); //insert email
        sendKeysToElement(By.id(PASSWORD_LOCATOR), PASS); //insert password
        sendKeysToElement(By.id(PASSAGAIN_LOCATOR), PASS); //insert password again
    }
    private void assertCredentials(){
        Assert.assertEquals(driver.findElement(By.id(USERNAME_LOCATOR)).getAttribute("value"),
                NAME); //assert USERNAME value
        Assert.assertEquals(driver.findElement(By.id(EMAIL_LOCATOR)).getAttribute("value"),
                ADRESS); //assert EMAIL value
        Assert.assertEquals(driver.findElement(By.id(PASSWORD_LOCATOR)).getAttribute("value"),
                PASS); //assert PASSWORD value
        Assert.assertEquals(driver.findElement(By.id(PASSAGAIN_LOCATOR)).getAttribute("value"),
                PASS); //assert PASSWORD AGAIN FIELD value
    }
    private void pressLogin(){
        clickElement(By.cssSelector(REGBUTTON_LOCATOR));
    }


}
