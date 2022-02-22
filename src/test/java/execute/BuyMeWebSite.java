package execute;

import screens.LoginPage;
import screens.PickBusiness;
import screens.SearchPresent;
import screens.SendAndReceiverInfo;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static tools.BasePage.quit;

/**
 * The BuyMeWebSite program an application that
 * run sanity test website (www.buyme.co.il)
 * @author  Natali Makvits
 * @version 1.0
 * @since   01-Feb-2022
 */
public class BuyMeWebSite {
    private static ExtentReports extent;
    public static ExtentTest test;

    /**
     * This BeforeClass (runOnceBeforeClass) initialises the web driver,ExtentReports
     * @see ExtentSparkReporter
     */
    @BeforeClass
    public static void runOnceBeforeClass() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("BuyMe web site sanity test",
                "Create user->login->search for present->order a present");
        test.log(Status.INFO,"BuyMeWebSite Version: 1.00");

        test.log(Status.INFO,"@Before test");
           }

    /**
     * This RegistrationAndLogin test dispatch Login\new registration process.
     * New rows will be added to test report
     * @see @loginPage
     * @exception Exception On input error.
     * @see Exception
     */
    @Test (priority = 1)
    public static void RegistrationAndLogin() throws Exception {
        test.log(Status.INFO,"Registration and login Test-Started");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.log(Status.PASS,"Registration and login Test");
    }

    /**
     * This HomeScreen test dispatch Search for present process.
     * New rows will be added to test report
     * @see @SearchPresent
     * @exception Exception On input error.
     * @see Exception
     */

    @Test (priority = 2)
    public static void HomeScreen() throws Exception { //throws InterruptedException - delete
        test.log(Status.INFO,"Home Screen Test - Started");
        SearchPresent SearchPresent = new SearchPresent();
        SearchPresent.SPresent();
        test.log(Status.PASS,"Home Screen Test");
  }

    /**
     * This PickBusiness test dispatch Pick Business process.
     * New rows will be added to test report
     * @see @PickBusiness
     * @exception Exception On input error.
     * @see Exception
     */
   @Test (priority = 3)
    public static void PickBusiness() throws Exception {
        test.log(Status.INFO,"Pick Business Screen Test - Started");
        PickBusiness PickBusiness = new PickBusiness();
        PickBusiness.PBusiness();
        test.log(Status.PASS,"Pick Business Screen Test");
   }

    /**
     * This SendReceivInformScreen test dispatch "Fill details in Send Receive form Screen" process.
     * New rows will be added to test report
     * @see @SendAndReceiverInfo
     * @exception Exception On input error.
     * @see Exception
     */
   @Test (priority = 4)
    public static void SendReceivInformScreen() throws Exception {
         test.log(Status.INFO,"Send And Receive Information Screen Test - Started");
         SendAndReceiverInfo SendAndReceiverInfo = new SendAndReceiverInfo();
         SendAndReceiverInfo.SRInfo();
         test.log(Status.PASS,"Send And Receive Information Screen Test");
    }

    /**
     * This AfterClass kill web driver, create ExtentReports+ add 2 rows in report
     * @see ExtentSparkReporter
     */
    @AfterClass
    public static void afterClass(){
        test.log(Status.INFO,"@AfterClass - Started");
        quit(); //kill driver
        extent.flush(); //create report
        test.log(Status.PASS,"@AfterClass");

    }
}
