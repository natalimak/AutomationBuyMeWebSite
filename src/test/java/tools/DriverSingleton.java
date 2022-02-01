package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
/**
 * The DriverSingleton class create driver instance
 * @author  Natali Makvits
 * @version 1.0
 * @since   01-Feb-2022
 */
public class DriverSingleton {
    private static WebDriver driver;

    /**
     * This method will create/return driver instance (or Chrome or FF, dependent on XML file)
     * @return method will return a driver (or new or exist)
     * @see @getData
     * @exception Exception On error.
     * @see Exception
     */
    public static WebDriver getDriverInstance() throws Exception {
        if(driver == null){
            String type = BasePage.getData("browserType");
            if(type.equals("Chrome")){
                System.setProperty("webdriver.chrome.driver", BasePage.getData
                        ("chromeDriverPath"));//Constants.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds
                        (Long.valueOf(BasePage.getData("timeOut"))));

            }else if(type.equals("FF")){
                System.setProperty("webdriver.firefox.driver",BasePage.getData("FFDriverPath"));
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

}
