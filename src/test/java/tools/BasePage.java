package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class BasePage {
    private WebDriver driver;

    public void BasePage(){
    }

    public WebDriver getDriver() throws Exception {
        driver = DriverSingleton.getDriverInstance();
        return driver;
    }
    public void clickElement(By locator) {
        getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    private WebElement getWebElement(By locator) {
        return driver.findElement(locator);
        //todo// add exception and test.fail (N.5)
    }
    public void dropDownElement(String locator, String choice) throws InterruptedException {
        Thread.sleep(2000);
        clickElement(By.cssSelector(locator));
        Thread.sleep(1000);
        clickElement(By.xpath(choice));
    }
    public static String getData (String keyName)throws Exception{
        String xmlFilePath = "src\\test\\java\\utils\\config.xml";
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
    public void clear(By locator) {
        getWebElement(locator).clear();
    }
}
