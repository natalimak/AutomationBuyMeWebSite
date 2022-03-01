package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
/**
 * The DriverSingleton class create driver instance
 * @author  Natali Makvits
 * @version 1.0
 * @since   01-Feb-2022
 */
public class DriverSingleton {
    private static WebDriver driver;
    public static String DATABASE_NAME;
    public static String SERVER;
    public static String PORT;
    public static String USER_NAME;
    public static String PASSWORD;
    public static Connection con;
    public static String type ="";


    static {
        try {
            if (!createConnection()){
                try {
                    type = BasePage.getData("browserType");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            else {
                try {
                    type = BasePage.getTableContent(DriverSingleton.con,"BROWSER");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * This method will create DB connection with credentials
     * @return method will return 1/0 if succeeded or not
     * @see BasePage#getData
     * @exception Exception On error.
     * @see Exception
     */
    private static boolean createConnection() throws Exception {
        try {
            DATABASE_NAME = BasePage.getData("DBName");
            SERVER = BasePage.getData("DBServer");
            PORT = BasePage.getData("DBPort");
            USER_NAME = BasePage.getData("DBUserName");
            PASSWORD = BasePage.getData("DBPassword");
            con = DriverManager.getConnection("jdbc:mysql://"+SERVER+":"+PORT, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * This method will call to create/return driver instance
     * @return method will return a driver (or new or exist)
     * @see #createBrowser()
     * @exception Exception On error.
     * @see Exception
     */
    public static WebDriver getDriverInstance() throws Exception {
        createBrowser();
        return driver;
    }

    /**
     * This method will create/return driver instance (or Chrome or FF, dependent on XML file)
     * @see BasePage#getData
     * @exception Exception On error.
     * @see Exception
     */
     private static void createBrowser() throws Exception {
        if(driver == null){
            //createTable(con);
           if(type.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver", BasePage.getData
                        ("chromeDriverPath"));
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds
                        (Long.parseLong(BasePage.getData("timeOut"))));

            }else if(type.equals("FF")){
                System.setProperty("webdriver.firefox.driver",BasePage.getData("FFDriverPath"));
                driver = new FirefoxDriver();
            }
        }
    }

}
