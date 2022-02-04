package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tools.BasePage;
import java.time.Duration;
import static tools.Constants.*;
/**
 * The SendAndReceiverInfo fill all fields for present order
 * @author  Natali Makvits
 * @version 1.0
 * @since   01-Feb-2022
 */
public class SendAndReceiverInfo extends BasePage {
    private WebDriver driver;
    private static WebDriverWait wait;

    /**
     * This constructor initialises the web driver for the SendAndReceiverInfo class instance
     * @exception Exception On input error.
     * @see Exception
     */
    public SendAndReceiverInfo() throws Exception {
        driver = getDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    /**
     * This method will call for full Send Present process.
     *@exception InterruptedException On input error.
     *@see InterruptedException
     */
    public void SRInfo() throws InterruptedException {

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

    /**
     * This method will call to other method for click on Other button\link
     * @param locator - locator of Other button\link
     * @see #clickElement(By)
     * @see tools.Constants
     */
        private void ToOther(String locator){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
            clickElement(By.className(locator));
}

    /**
     * This method will call to other method for insert name of Receiver and check name
     * @param locator - locator of Other button\link
     * @param recName - Receiver name
     * @see #clickElement(By)
     * @see tools.Constants
     */
        private void EnterRecName(String locator,String recName){
            sendKeysToElement(By.cssSelector(locator),recName);
            Assert.assertEquals(driver.findElement(By.cssSelector(RECEIVERNAME_LOCATOR)).getAttribute("value"),
                    RECEIVER);
    }

    /**
     * This method will select event from dropdown
     * @param locator - main present dropdown locator
     * @param event  - child in dropdown
     * @see tools.Constants
     * @see #dropDownElement
     * @exception InterruptedException On input error.
     * @see InterruptedException
     */
        private void PickAnEvent(String locator,String event) throws InterruptedException {
            dropDownElement(locator,event);

    }

    /**
     * This method will call to other method for clear and insert bless
     * @param locator -bless locator
     * @param blessing - bless text
     * @see #clear(By)
     * @see #sendKeysToElement(By, String)
     * @see tools.Constants
     */
        private void EnterBless(String locator,String blessing){
            clear(By.cssSelector(locator));
            sendKeysToElement(By.cssSelector(locator),blessing);
        }

    /**
     * This method will call to other method for attach file to present
     * @param locator -file upload locator
     * @param filePath - file Path for attach
     * @see #sendKeysToElement(By, String)
     * @see tools.Constants
     */
        private void UploadPic(String locator, String filePath){
         sendKeysToElement(By.cssSelector(locator),filePath);
    }

    /**
     * This method will call to other method for click on Next button\link
     * @param locator -  Next button\link locator
     * @see #clickElement(By)
     * @see tools.Constants
     */
        private void PressNext(String locator){
            clickElement(By.cssSelector(locator));

    }

    /**
     * This method will call to other method for click on Now button\link
     * @param locator -  Now button\link locator
     * @see #clickElement(By)
     * @see tools.Constants
     */
        private void PressNow(String locator){
            clickElement(By.cssSelector(locator));
    }

    /**
     * This method will call to other method for click on SMS button\link and insert PhoneNumber
     * @param smsLocator -  SMS button\link locator
     * @param numberLocator - PhoneNumber locator
     * @param phoneNam - Phone Number of receiver
     * @see #clickElement(By)
     * @see #sendKeysToElement
     * @see tools.Constants
     */
        private void PickPhone(String smsLocator,String numberLocator, String phoneNam){
            clickElement(By.cssSelector(smsLocator)); //Press SMS button
            sendKeysToElement(By.cssSelector(numberLocator),phoneNam); //fill Phone number of receiver
        }

    /**
     * This method will call to other method for click on enter data of Sender (name and Phone number).
     * and check insert data.
     * @param senderNameLocator - sender Name filed locator
     * @param senderName - sender name
     * @param senderPhoneLocator -sender phone filed locator
     * @param senderPhone - Phone Number of sender
     * @see #clear(By)
     * @see #clickElement(By)
     * @see #sendKeysToElement
     * @see tools.Constants
     */
        private void EnterSenderName(String senderNameLocator,
                                     String senderName,String senderPhoneLocator, String senderPhone){
            clear(By.cssSelector(senderNameLocator));

            sendKeysToElement(By.cssSelector(senderNameLocator),senderName); //fill Sender Name
            sendKeysToElement(By.cssSelector(senderPhoneLocator),senderPhone);// fill Sender Phone Number
            Assert.assertEquals(driver.findElement(By.cssSelector(SENDERNAME_LOCATOR)).
                            getAttribute("value"),
                    SENDERNAME); //assert Sender Name
        }

    /**
     * This method will call to other method for click on Send button\link
     * @param sendButtonLocator -  Send button\link locator
     * @see #clickElement(By)
     * @see tools.Constants
     */
        private void Payment(String sendButtonLocator){
            clickElement(By.cssSelector(sendButtonLocator)); //Press Next to Payment button
    }
}
