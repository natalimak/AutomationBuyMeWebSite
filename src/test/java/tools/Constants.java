package tools;

public class Constants {

// new USER
    public static final String NAME = "Join121";
    public static final String PASS = "Pass1234";

//New Search constants
    public static final String SEARCHPRICE_LOCATOR ="//*[contains(text(),'199')]";
    public static final String SEARCHREGION_LOCATOR ="//*[contains(text(),'מרכז')]";
    public static final String SEARCHCATEGORY_LOCATOR ="//*[contains(text(),'בריחה')]";
    public static final String SEARCHURL_LOCATOR ="https://buyme.co.il/search?budget=2&category=63&region=11";

//Sender And Receiver Information screen-constants
    public static final String PRESENAMOUNT="250"; //present amount
    public static final String RECEIVER="IgorMyLove"; //Receiver name
    public static final String
            EVENT_LOCATOR ="//*[@gtm=\"eventType\"]/div/div[2]/ul/li[11]"; //Present type (wedding)
    public static final String BLESSING ="אהוב שלי, שיהיה רק במזל טוב לנו";
    public static final String FILETOUPLOAD ="C:\\Users\\Administrator\\IdeaProjects\\AutomationBuyMeWebSite\\src\\test\\java\\utils\\wedding-3.jpg";
    public static final String RECPHONENUMBER ="0548007001";
    public static final String SENDERNAME="Natali";
    public static final String SENDERPHONE="0541111222";

//---------------------Locators----------------------------//

    // web site main screen
    public static final String REGISTRATION_LOCATOR = "#ember985 > div > ul:first-of-type > li:nth-of-type(3) > a > span";
    public static final String NEWREG_LOCATOR = "#ember944 > div > div:first-of-type > div > div > div:nth-of-type(3) > div:first-of-type > span";
    //New User Registration screen
    public static final String USERNAME_LOCATOR ="ember1697";
    public static final String EMAIL_LOCATOR ="ember1704";
    public static final String PASSWORD_LOCATOR ="valPass";
    public static final String PASSAGAIN_LOCATOR ="ember1718";
    public static final String REGBUTTON_LOCATOR = "span[class='label'";
    //Home Screen
    public static final String MYACCOUNT_LOCATOR = "ember1761";
    public static final String PICKPRICE_LOCATOR = "form.form label:nth-child(1)";
    public static final String PICKREGION_LOCATOR = "form.form label:nth-child(2)";
    public static final String PICKCATEGORY_LOCATOR = "form.form label:nth-child(3)";

    public static final String SEARCH_LOCATOR = "#ember1180";

    //Pick Business screen
    public static final String BUSINESS_LOCATOR ="ul.bm-product-cards div:nth-child(2)";
    public static final String PRESENTPRICE_LOCATOR ="input[data-parsley-type=\"number\"]";
    public static final String CHOICEBUTTON_LOCATOR = "div[class='mx-12 money-btn'";


    //Sender and Receiver Information screen
    public static final String TO_OTHER_BUTTON_LOCATOR ="button-forSomeone";
    public static final String RECEIVERNAME_LOCATOR ="input[data-parsley-required-message*='הזוכה']";
    public static final String PICKEVENT_LOCATOR ="span[title*='לאיזה אירוע']";
    public static final String
                BLESSING_LOCATOR ="[data-parsley-group=voucher-greeting]"; //Blessing Locator
    public static final String
            UPLOADFILE_LOCATOR ="input[accept*=image]";  //Upload file button Locator
    public static final String NEXTBUTTON_LOCATOR ="button[gtm='המשך']";
    public static final String NOWCHECKBOX_LOCATOR = "div[gtm='עכשיו'";
    public static final String SMS_LOCATOR ="svg[gtm='method-sms'";
    public static final String RECPHONE_LOCATOR ="input[id='sms'";
    public static final String SENDERNAME_LOCATOR ="input[placeholder*='שולח'";
    public static final String SENDERPHONE_LOCATOR ="input[placeholder*='מספר'";
    public static final String SUMBITBUTTON_LOCATOR = "button[type=submit";
}
