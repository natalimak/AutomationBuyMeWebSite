package execute;

import Screens.PickBusiness;
import Screens.SendAndReceiverInfo;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BuyMeWebSite {
    /*private static ExtentReports extent= new ExtentReports();
    private static ExtentTest test = extent.createTest("MyFirstTest", "Sample description");*/
    @BeforeClass
    public static void runOnceBeforeClass() {

    }
/*  @Test (priority = 1)
    public static void RegistrationAndLogin() throws Exception {
       LoginPage loginPage = new LoginPage();
       loginPage.login();
    }*/
  /* @Test (priority = 2)
    public static void HomeScreen() throws InterruptedException { //throws InterruptedException - delete
        SearchPresent SearchPresent = new SearchPresent();
        SearchPresent.SPresent();
    }*/
  /* @Test (priority = 3)
    public static void PickBusiness() throws Exception {
        PickBusiness PickBusiness = new PickBusiness();
        PickBusiness.PBusiness();
    }*/
    @Test (priority = 4)
    public static void SendReceivInformScreen() throws Exception {
         SendAndReceiverInfo SendAndReceiverInfo = new SendAndReceiverInfo();
         SendAndReceiverInfo.SRInfo();
    }
}
