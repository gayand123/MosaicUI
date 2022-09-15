package com.mosaic.test.adminModule;

import com.mosaic.datalayer.TestDataProvider;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.pages.adminModule.AdminOfferPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminOfferTest extends TestBase {
    @BeforeClass
    public void loginAdminUser() throws InterruptedException {
        userLogin();
    }

    @Test(priority = 1)
    public void verifyCreateSignUpOfferWithValideData() throws InterruptedException, FindFailed {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName("AutomationSignUpOffer1");
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate("09/01/2022");
        adminOfferPage.enterPromoCode(DomainConstants.promoCode);
        Thread.sleep(2000);
        adminOfferPage.clickBrowseImage(properties.getProperty("filePath"), properties.getProperty("correctImagePath"));

        adminOfferPage.clickUploadImage();
        Thread.sleep(5000);
        adminOfferPage.selectOfferTypeGroup("Discount");
        adminOfferPage.selectOfferType("SignUp");
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferExpireDays(), "30");
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmount();
        adminOfferPage.enterMinimumOrderAmount();
        adminOfferPage.clickSaveOffer();
    }

    @Test(priority = 2)
    public void verifyCreateOrderTotalOfferWithValideData() throws InterruptedException, FindFailed {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName("AutomationSignUpOffer2");
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate("09/01/2022");
        adminOfferPage.enterPromoCode(DomainConstants.promoCode);
        adminOfferPage.clickBrowseImage();
        adminOfferPage.selectOfferTypeGroup("Discount");
        adminOfferPage.selectOfferType("OrderTotal");
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferExpireDays(), "30");
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmount();
        adminOfferPage.enterMinimumOrderAmount();
        adminOfferPage.clickSaveOffer();

    }

    @Test(priority = 3)
    public void verifyCreateBirthDayOfferWithValideData() throws InterruptedException, FindFailed {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName("AutomationSignUpOffer3");
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate("09/01/2022");
        adminOfferPage.enterPromoCode(DomainConstants.promoCode);
        adminOfferPage.clickBrowseImage();
        adminOfferPage.selectOfferTypeGroup("Discount");
        adminOfferPage.selectOfferType("BirthDay");
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferExpireDays(), "30");
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmount();
        adminOfferPage.enterMinimumOrderAmount();
        adminOfferPage.clickSaveOffer();

    }

    @Test(priority = 4)
    public void verifyCreateSignUpOfferWithInValideData() throws InterruptedException, FindFailed {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName("AutomationSignUpOffer4");
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate("09/01/2022");
        adminOfferPage.enterPromoCode(DomainConstants.promoCode);
        adminOfferPage.clickBrowseImage();
        adminOfferPage.selectOfferTypeGroup("Discount");
        adminOfferPage.selectOfferType("SignUp");
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferExpireDays(), "30");
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmount();
        adminOfferPage.enterMinimumOrderAmount();
        adminOfferPage.clickSaveOffer();
        Assert.assertEquals(adminOfferPage.getOfferSavingErrorMessage(), "Given Offer name is already exist for this merchant. Given Offer Name:AutomationSignUpOffer");

    }

    @Test(priority = 5)
    public void verifyCloseCreateOfferForm() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        Thread.sleep(2000);
        adminOfferPage.clickCloseOfferCreation();
        Assert.assertEquals(adminOfferPage.isCreateOfferButtonVisible(), true);
    }

    @Test(priority = 6)
    public void verifyMandetoryfieldsInOfferCreation() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.clickSaveOffer();
        Assert.assertEquals(adminOfferPage.getReuiredErrorMessageInOfferName(), "This field is required");
        Assert.assertEquals(adminOfferPage.getReuiredErrorMessageInOfferStartDate(), "This field is required");
        Assert.assertEquals(adminOfferPage.getReuiredErrorMessageInOfferTypeGroup(), "This field is required");

    }

    @Test(priority = 7)
    public void verifyOfferEndDateGreaterThanOfferStartDate() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName("AutomationSignUpOffer5");
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate("09/01/2022");
        Assert.assertEquals(adminOfferPage.getEndDateGreaterThanStartDateOfferErrorMessage(), "End Date field should be greater than start Date");
    }

    @Test(dataProvider = "optionalFieldInOfferCreation", dataProviderClass = TestDataProvider.class,priority = 8)
    public void verifyOptionalFieldsInCreateOffer(String endDate, String promoCode) throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName("AutomationSignUpOffer6");
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate(endDate);
        adminOfferPage.enterPromoCode(promoCode);
        adminOfferPage.selectOfferTypeGroup("Discount");
        adminOfferPage.selectOfferType("SignUp");
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferExpireDays(), "30");
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmount();
        adminOfferPage.enterMinimumOrderAmount();
        adminOfferPage.clickSaveOffer();
    }

    @Test(dataProvider = "ImageSizeInOfferCreation", dataProviderClass = TestDataProvider.class,priority = 9)
    public void verifyUploadImageSizeInOffer(String offerImage,String errorMessage) throws InterruptedException, FindFailed {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName("AutomationSignUpOffer7");
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate("09/01/2022");
        adminOfferPage.enterPromoCode(DomainConstants.promoCode);
        Thread.sleep(2000);
        adminOfferPage.clickBrowseImage(properties.getProperty("filePath"), offerImage);
        Thread.sleep(5000);
        Assert.assertEquals(adminOfferPage.smallImageErrorMessage(), errorMessage);
        adminOfferPage.clickCloseOfferForm();
    }

}
