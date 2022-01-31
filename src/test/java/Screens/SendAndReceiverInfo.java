package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.BasePage;

import java.time.Duration;

import static tools.Constants.*;

public class SendAndReceiverInfo extends BasePage {
    private WebDriver driver;
    private static WebDriverWait wait;

    public SendAndReceiverInfo() throws Exception {
        driver = getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public void SRInfo() throws InterruptedException {
        driver.get("https://buyme.co.il/money/1736681?price=250"); //delete ofter tests
Thread.sleep(1000);
        ToOther(TO_OTHER_BUTTON_LOCATOR); //press 'To Other' Button
        EnterRecName(RECEIVERNAME_LOCATOR,RECEIVER);
        PickAnEvent(PICKEVENT_LOCATOR, EVENT_LOCATOR);
        EnterBless(BLESSING_LOCATOR,BLESSING);
        Thread.sleep(2000);
        UploadPic(UPLOADFILE_LOCATOR,FILETOUPLOAD);
        PressNext(NEXTBUTTON_LOCATOR);
        PressNow(NOWCHECKBOX_LOCATOR);
        PickPhone(SMS_LOCATOR,RECPHONE_LOCATOR,RECPHONENUMBER);
        EnterSenderName(SENDERNAME_LOCATOR ,SENDERNAME, SENDERPHONE_LOCATOR,SENDERPHONE);
        Payment(SUMBITBUTTON_LOCATOR);

    }
        private void ToOther(String locator){
            clickElement(By.className(locator));
}
        private void EnterRecName(String locator,String recName){
            sendKeysToElement(By.cssSelector(locator),recName);
            Assert.assertEquals(driver.findElement(By.cssSelector(RECEIVERNAME_LOCATOR)).getAttribute("value"),
                    RECEIVER); //assert Receiver Name
    }

        private void PickAnEvent(String locator,String event) throws InterruptedException {
            dropDownElement(locator,event);

    }
        private void EnterBless(String locator,String blessing){
            clear(By.cssSelector(locator));
            sendKeysToElement(By.cssSelector(locator),blessing);
        }

        private void UploadPic(String locator, String filePath){
         sendKeysToElement(By.cssSelector(locator),filePath);
    }
        private void PressNext(String locator){
            clickElement(By.cssSelector(locator));

    }
        private void PressNow(String locator){
            clickElement(By.cssSelector(locator));
    }
        private void PickPhone(String smsLocator,String numberLocator, String phoneNam){
            clickElement(By.cssSelector(smsLocator)); //Press SMS button
            sendKeysToElement(By.cssSelector(numberLocator),phoneNam); //fill Phone number of receiver

        }
        private void EnterSenderName(String senderNameLocator, String senderName,String senderPhoneLocator, String senderPhone){
            clear(By.cssSelector(senderNameLocator));

            sendKeysToElement(By.cssSelector(senderNameLocator),senderName); //fill Sender Name
            sendKeysToElement(By.cssSelector(senderPhoneLocator),senderPhone);// fill Sender Phone Number
            Assert.assertEquals(driver.findElement(By.cssSelector(SENDERNAME_LOCATOR)).getAttribute("value"),
                    SENDERNAME); //assert Sender Name
        }

        private void Payment(String sendButtonLocator){
            clickElement(By.cssSelector(sendButtonLocator)); //Press Next to Payment button
    }
}
