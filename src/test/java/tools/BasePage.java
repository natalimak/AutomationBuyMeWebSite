package tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.w3c.dom.Document;
import org.apache.commons.lang3.RandomStringUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import static execute.BuyMeWebSite.test;
import static tools.DriverSingleton.DATABASE_NAME;
import static tools.DriverSingleton.con;

/**
 * The BasePage class include all sub methods that use BuyMeWebSite
 * @author  Natali Makvits
 * @version 1.01
 * @since   01-March-2022
 */
public class BasePage {
    private static WebDriver driver;

    /**
     * This method will call for a driver instance from singleton
     * @return method will return a driver from singleton (or new or exist)
     * @exception Exception On input error.
     * @see Exception
     */
    public WebDriver getDriver() throws Exception {
        driver = DriverSingleton.getDriverInstance();
        return driver;
    }
    //-----------------locators-------------------

    /**
     * This method will click on link\button by locator
     * @param locator -->  locator of the link\button
     */
    public static void clickElement(By locator) {
        getWebElement(locator).click();
    }

    /**
     * This method will write to field
     * @param locator -  locator of the field
     * @param text - text in the field
     */
    public void sendKeysToElement(By locator, String text) {
        getWebElement(locator).sendKeys(text);
    }

    /**
     * This method will clear the field
     * @param locator --> locator of field for clearing
     */
    public void clear(By locator) {
        getWebElement(locator).clear();
    }

    /**
     * This method will find locator
     * @param locator -  locator
     * @return method will return an element found by provided locator
     */
    private static WebElement getWebElement(By locator) {
        try {
            return driver.findElement(locator);
        }catch (NoSuchElementException e){
            test.info("Fail",
                    MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("pic")).build());
        }
        return driver.findElement(locator);
    }

    /**
     * This method will open "dropdown" and select the one of the rows
     * @param locator --> dropdown locator
     * @param choice --> locator of row for choose
     * @exception InterruptedException On input error.
     * @see InterruptedException
     */
    public void dropDownElement(String locator, String choice) throws InterruptedException {
        Thread.sleep(500);
        clickElement(By.cssSelector(locator));
        Thread.sleep(500);
        clickElement(By.xpath(choice));
    }

    /**
     * This method will make ScreenShot
     * @param ImagesPath --> path for ScreenShot image save
     * @return full ImagesPath with ScreenShot file name
     */
    public static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }


    //---------------------External -----------

    /**
     * This method will open and read XML file
     * @param keyName --> the keyName from XML file
     * @return method will return a value by keyName from XML
     * @exception Exception On input error.
     * @see Exception
     */
    public static String getData (String keyName)throws Exception{
        String xmlFilePath = "src\\test\\java\\utils\\config.xml";
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    /**
     * This method will write to Report.txt file time
     * @param time -->  Timestamp
     */
    private static void writeReportToFile(Timestamp time) throws IOException {
        FileWriter writer = new FileWriter("Report.txt",true);
        writer.write(time + "\n");
        writer.close();
    }

    /**
     * This method will generate a random integer
     * @param length --> the length of the random emails we want to generate
     * @return method will return a random email String
     */
    public static String generateRandomEmail(int length) {
        test.info("Generating a Random email String");
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-";
        String email;
        String temp = RandomStringUtils.random(length, allowedChars);
        email = temp.substring(0, temp.length() - 1) + "@testbuyme.com";
        return email;
    }

    //------------------DB-----------------------
    /**
     * This method will add new row in DB with run info (date and time) or to text file if no DB connection
     * @exception SQLException On input error.
     * @see SQLException
     */
    protected static void addHistory()
            throws SQLException, IOException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (con!=null){
            String statementToExecute = "INSERT INTO " + DATABASE_NAME +
                    ".history (`test_data`) " +
                    "VALUES ('" + timestamp + "');";
            con.createStatement().execute(statementToExecute);
        }
        else {
            writeReportToFile(timestamp);
        }
    }

    /**
     * This method will make ScreenShot
     * @param con - connection to DB
     * @param config_name URL or Browser
     * @return full ImagesPath with ScreenShot file name
     */
    public static String getTableContent(Connection con,String config_name) throws SQLException {
        String statementToExecute = "SELECT * FROM " + DATABASE_NAME + ".config where config_name= '"
                +config_name+"';";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(statementToExecute);
        String name = "";
        while(rs.next()){
            name = rs.getString("config_data");
            rs.close();
            return name;
        }
        rs.close();
        return name;
    }

        /**
         * This method will close internet explore (chrome or FF) season and DB connection
         * @exception SQLException On input error.
         * @see SQLException
         */
    public static void quit() throws SQLException {
        driver.quit();
        if (con!=null)
            con.close();
    }
}
