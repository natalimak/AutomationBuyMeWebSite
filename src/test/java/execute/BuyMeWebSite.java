package execute;

import Screens.LoginPage;
import Screens.PickBusiness;
import Screens.SearchPresent;
import Screens.SendAndReceiverInfo;
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
 * run sanity test website (www.buyme.co.il) .
 *
 * @author  Natali Makvits
 * @version 1.0
 * @since   01-Feb-2022
 */
public class BuyMeWebSite {
    private static ExtentReports extent;
    public static ExtentTest test;

    @BeforeClass
    public static void runOnceBeforeClass() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("BuyMe web site sanity test", "Create user->login->search for present->order a present");
        test.log(Status.INFO,"@Before test");
           }

    @Test (priority = 1)
    public static void RegistrationAndLogin() throws Exception {
        test.log(Status.INFO,"Registration and login Test-Started");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.log(Status.PASS,"Registration and login Test");
    }

    @Test (priority = 2)
    public static void HomeScreen() throws Exception { //throws InterruptedException - delete
        test.log(Status.INFO,"Home Screen Test - Started");
        SearchPresent SearchPresent = new SearchPresent();
        SearchPresent.SPresent();
        test.log(Status.PASS,"Home Screen Test");
  }

   @Test (priority = 3)
    public static void PickBusiness() throws Exception {
        test.log(Status.INFO,"Pick Business Screen Test - Started");
        PickBusiness PickBusiness = new PickBusiness();
        PickBusiness.PBusiness();
        test.log(Status.PASS,"Pick Business Screen Test");

   }

   @Test (priority = 4)
    public static void SendReceivInformScreen() throws Exception {
         test.log(Status.INFO,"Send And Receive Information Screen Test - Started");
         SendAndReceiverInfo SendAndReceiverInfo = new SendAndReceiverInfo();
         SendAndReceiverInfo.SRInfo();
         test.log(Status.PASS,"Send And Receive Information Screen Test");
    }

    @AfterClass
    public static void afterClass(){
        test.log(Status.INFO,"@AfterClass - Started");
        quit(); //kill driver
        extent.flush(); //create report
        test.log(Status.PASS,"@AfterClass");

    }
}
