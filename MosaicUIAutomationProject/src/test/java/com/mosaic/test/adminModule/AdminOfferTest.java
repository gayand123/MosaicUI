package com.mosaic.test.adminModule;

import com.mosaic.datalayer.TestDataProvider;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.pages.adminModule.AdminOfferPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminOfferTest extends TestBase {
    @BeforeClass
    public void loginAdminUser() throws InterruptedException {
        userLogin();
    }

    @Test
    public void verifyCreateSignUpOfferWithValideData() throws InterruptedException {
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
        adminOfferPage.enterOfferName("AutomationSignUpOffer");
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate("09/01/2022");
        adminOfferPage.enterPromoCode(DomainConstants.promoCode);
        Thread.sleep(2000);
        adminOfferPage.clickBrowseImage();
        adminOfferPage.clickUploadImage();
        adminOfferPage.selectOfferTypeGroup("Discount");
        adminOfferPage.selectOfferType("SignUp");
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferExpireDays(), "30");
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmount();
        adminOfferPage.enterMinimumOrderAmount();
        adminOfferPage.clickSaveOffer();
    }

    @Test
    public void verifyCreateOrderTotalOfferWithValideData() throws InterruptedException {
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
        adminOfferPage.enterOfferName("AutomationSignUpOffer");
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

    @Test
    public void verifyCreateBirthDayOfferWithValideData() throws InterruptedException {
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
        adminOfferPage.enterOfferName("AutomationSignUpOffer");
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

    @Test
    public void verifyCreateSignUpOfferWithInValideData() throws InterruptedException {
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
        adminOfferPage.enterOfferName("AutomationSignUpOffer");
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

    @Test
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

    @Test
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

    @Test
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
        adminOfferPage.enterOfferName("AutomationSignUpOffer222");
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate("09/01/2022");
        Assert.assertEquals(adminOfferPage.getEndDateGreaterThanStartDateOfferErrorMessage(), "End Date field should be greater than start Date");
    }
    @Test (dataProvider = "optionalFieldInOfferCreation", dataProviderClass = TestDataProvider.class)
    public void verifyOptionalFieldsInCreateOffer(String endDate,String promoCode) throws InterruptedException {
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
        adminOfferPage.enterOfferName("AutomationSignUpOffer");
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

}
