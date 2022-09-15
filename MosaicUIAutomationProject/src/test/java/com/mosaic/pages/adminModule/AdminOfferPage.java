package com.mosaic.pages.adminModule;

import com.mosaic.util.DomainConstants;
import com.mosaic.util.adminModule.ElementsOffers;
import com.mosaic.util.TestBase;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.KeyUpAction;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Screen;


import java.io.File;

public class AdminOfferPage extends TestBase {
    @FindBy(xpath = ElementsOffers.btnCreateOffer)
    private WebElement btnCreateOffer;
    @FindBy(xpath = ElementsOffers.btnDropDownStoreLocation)
    private WebElement btnDropDownStoreLocation;
    @FindBy(xpath = ElementsOffers.checkBoxAllStore)
    private WebElement checkBoxAllStore;

    @FindBy(xpath = ElementsOffers.lblStoreLocation)
    private WebElement lblStoreLocation;
    @FindBy(xpath = ElementsOffers.txtOfferName)
    private WebElement txtOfferName;
    @FindBy(xpath = ElementsOffers.txtPromoCode)
    private WebElement txtPromoCode;

    @FindBy(xpath = ElementsOffers.txtStartDate)
    private WebElement txtStartDate;

    @FindBy(xpath = ElementsOffers.txtEndDate)
    private WebElement txtEndDate;

    @FindBy(xpath = ElementsOffers.btnDropDownOfferTypeGroup)
    private WebElement btnDropDownOfferTypeGroup;

    @FindBy(xpath = ElementsOffers.lblSelectDiscountOffer)
    private WebElement lblSelectDiscountOffer;

    @FindBy(xpath = ElementsOffers.btnDropDownOfferType)
    private WebElement btnDropDownOfferType;

    @FindBy(xpath = ElementsOffers.lblSelectSignUpOffer)
    private WebElement lblSelectSignUpOffer;

    @FindBy(xpath = ElementsOffers.txtOfferExpiredate)
    private WebElement txtOfferExpiredate;

    @FindBy(xpath = ElementsOffers.radioBtnDiscount)
    private WebElement radioBtnDiscount;

    @FindBy(xpath = ElementsOffers.txtDiscountAmount)
    private WebElement txtDiscountAmount;

    @FindBy(xpath = ElementsOffers.txtMinimumOrderAmount)
    private WebElement txtMinimumOrderAmount;

    @FindBy(xpath = ElementsOffers.btnSaveOffer)
    private WebElement btnSaveOffer;

    @FindBy(xpath = ElementsOffers.lblSelectOrderTotalOffer)
    private WebElement lblSelectOrderTotalOffer;
    @FindBy(xpath = ElementsOffers.lblSelectBirthDayOffer)
    private WebElement lblSelectBirthDayOffer;

    @FindBy(xpath = ElementsOffers.lbnDateTimeffer)
    private WebElement lbnDateTimeffer;

    @FindBy(xpath = ElementsOffers.lblOfferSavingErrorMessage)
    private WebElement lblOfferSavingErrorMessage;
    @FindBy(xpath = ElementsOffers.btnCloseCreateOfferPage)
    private WebElement btnCloseCreateOfferPage;
    @FindBy(xpath = ElementsOffers.lblOfferNameRequiredMessage)
    private WebElement lblOfferNameRequiredMessage;

    @FindBy(xpath = ElementsOffers.lblOfferStartDateRequiredMessage)
    private WebElement lblOfferStartDateRequiredMessage;
    @FindBy(xpath = ElementsOffers.lblOfferTypeGroupRequiredMessage)
    private WebElement lblOfferTypeGroupRequiredMessage;
    @FindBy(xpath = ElementsOffers.lblEndDateGreaterThanStartDateOfferErrorMessage)
    private WebElement lblEndateGreaterThanStartDateOfferErrorMessage;
    @FindBy(xpath = ElementsOffers.btnBrowseImage)
    private WebElement btnBrowseImage;
    @FindBy(xpath = ElementsOffers.btnUploadImage)
    private WebElement btnUploadImage;
    @FindBy(xpath = ElementsOffers.lblErrorMessageSmallImage)
    private WebElement lblErrorMessageSmallImage;
    @FindBy(xpath = ElementsOffers.btnCloseOfferCreation)
    private WebElement btnCloseOfferCreation;

    public void clickCreatebtnOffer() {
        waitUntilVisibilityOfElement(By.xpath(ElementsOffers.btnCreateOffer));
        clickOnElement(btnCreateOffer);
    }

    public void clickCloseOfferForm(){
        clickOnElement(btnCloseOfferCreation);
    }
    public void clickDropDownBtnStoreLocation() {
        waitUntilVisibilityOfElement(By.xpath(ElementsOffers.btnDropDownStoreLocation));
        clickOnElement(btnDropDownStoreLocation);
    }

    public void clickCheckBoxAllStoreLocation() {
        waitUntilVisibilityOfElement(By.xpath(ElementsOffers.checkBoxAllStore));
        clickOnElement(checkBoxAllStore);
    }

    public void moveToElement() {
        waitUntilVisibilityOfElement(By.xpath(ElementsOffers.checkBoxAllStore));
        clickOnElement(checkBoxAllStore);
    }

    public void clickPromoCode() {

        moveAndClick(txtPromoCode);
    }

    public void enterOfferName(String offerName) throws InterruptedException {
        moveAndClick(txtOfferName);
        // Thread.sleep(1000);
        txtOfferName.sendKeys(offerName);

    }

    public void enterStartDate() {
        selectValueFromAutoSuggestionListInTextField(txtStartDate, getTodaydate());
    }

    public void enterEndDate(String endDate) {
        selectValueFromAutoSuggestionListInTextField(txtEndDate, endDate);
    }

    public void enterPromoCode(String promocode) {
        // moveAndClick(txtPromoCode);
        clearAndType(txtPromoCode, promocode);
    }

    public void selectOfferTypeGroup(String offerTypeGroup) {
        clickOnElement(btnDropDownOfferTypeGroup);
        if (offerTypeGroup == "Discount") {
            System.out.println("I'm innnn");
            clickOnElement(lblSelectDiscountOffer);
        }
        if (offerTypeGroup == "DateTime") {
            clickOnElement(lbnDateTimeffer);
        }

    }

    public void selectOfferType(String offerTypeName) {
        clickOnElement(btnDropDownOfferType);
        if (offerTypeName == "SignUp") {
            clickOnElement(lblSelectSignUpOffer);

        }
        if (offerTypeName == "OrderTotal") {
            clickOnElement(lblSelectOrderTotalOffer);
        }
        if (offerTypeName == "BirthDay") {
            clickOnElement(lblSelectBirthDayOffer);
        }


    }

    public String getOfferExpireDays() throws InterruptedException {
        scrollDown();
        String expDays = getAttributeValue(txtOfferExpiredate);
        return expDays;
    }

    public void clickPercentageDiscount() {

        clickOnElement(radioBtnDiscount);
    }

    public void enterDiscountAmount() {
        clearAndType(txtDiscountAmount, DomainConstants.discountAmount);
    }

    public void enterMinimumOrderAmount() {
        clearAndType(txtMinimumOrderAmount, DomainConstants.minimumOrderamount);
    }

    public void clickSaveOffer() {
        clickOnElement(btnSaveOffer);
    }

    public String getOfferSavingErrorMessage() {
        String errorMessage = getElementText(lblOfferSavingErrorMessage);
        return errorMessage;
    }

    public void clickCloseOfferCreation() {
        clickOnElement(btnCloseCreateOfferPage);
    }

    public boolean isCreateOfferButtonVisible() {
        waitUntilVisibilityOfElement(By.xpath(ElementsOffers.btnCreateOffer));
        return isElementPresentAndDisplay(btnCreateOffer);
    }

    public String getReuiredErrorMessageInOfferName() {
        return getElementText(lblOfferNameRequiredMessage);
    }


    public String getReuiredErrorMessageInOfferStartDate() {
        return getElementText(lblOfferStartDateRequiredMessage);
    }

    public String getReuiredErrorMessageInOfferTypeGroup() {
        return getElementText(lblOfferTypeGroupRequiredMessage);
    }

    public String getEndDateGreaterThanStartDateOfferErrorMessage() {
        return getElementText(lblEndateGreaterThanStartDateOfferErrorMessage);
    }

    public void clickBrowseImage() throws FindFailed, InterruptedException {
        javaScriptClick(btnBrowseImage);
        Thread.sleep(2000);
        //  File file = new File("images\\NewOffer.PNG");
        //   System.out.println(file.getAbsolutePath());
        //  btnBrowseImage.sendKeys(file.getAbsolutePath());
        Screen screen = new Screen();
        screen.find("D:\\MosaicUIAutomationProject\\MosaicUIAutomationProject\\MosaicUIAutomationProject\\images\\filename.png").click();
        screen.type("D:\\MosaicUIAutomationProject\\MosaicUIAutomationProject\\MosaicUIAutomationProject\\images\\NewOffer.png");
        Thread.sleep(2000);
     //   screen.find("D:\\MosaicUIAutomationProject\\MosaicUIAutomationProject\\MosaicUIAutomationProject\\images\\1662388240258.png");
       // screen.click();
        screen.type(Key.ENTER);

    }
    public void clickBrowseImage(String filePath,String imagePath) throws FindFailed, InterruptedException {
        javaScriptClick(btnBrowseImage);
        Thread.sleep(2000);
        //  File file = new File("images\\NewOffer.PNG");
        //   System.out.println(file.getAbsolutePath());
        //  btnBrowseImage.sendKeys(file.getAbsolutePath());
        Screen screen = new Screen();
        screen.find(filePath).click();
        screen.type(imagePath);
      //  Thread.sleep(2000);
        //   screen.find("D:\\MosaicUIAutomationProject\\MosaicUIAutomationProject\\MosaicUIAutomationProject\\images\\1662388240258.png");
        // screen.click();
        screen.type(Key.ENTER);
        screen.type(Key.ENTER);
    }

    public void clickUploadImage() {

        clickOnElement(btnUploadImage);
    }

    public String smallImageErrorMessage(){
        return getElementText(lblErrorMessageSmallImage);
    }
}


