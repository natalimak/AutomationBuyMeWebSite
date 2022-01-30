package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance() throws Exception {
        if(driver == null){
            String type = BasePage.getData("browserType");
            if(type.equals("Chrome")){
                System.setProperty("webdriver.chrome.driver", BasePage.getData("chromeDriverPath"));//Constants.CHROMEDRIVER_PATH);
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.valueOf(BasePage.getData("timeOut"))));

            }else if(type.equals("FF")){
                System.setProperty("webdriver.firefox.driver",BasePage.getData("FFDriverPath"));
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

}
