package com.mosaic.test.adminModule;

import com.mosaic.datalayer.TestDataProvider;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.pages.adminModule.AdminOfferPage;
import com.mosaic.pages.storeFrontModule.HomeOffersPage;
import com.mosaic.pages.storeFrontModule.StorefrontLoginPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AdminOfferTest extends TestBase {

    @BeforeClass
    public void loginAdminUser() throws InterruptedException {
        userLogin();
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
    }

    @Test(priority = 1)
    public void verifyCreateSignUpOfferWithValideData() throws InterruptedException, FindFailed {
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName();
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDateAsFutureDate();
        adminOfferPage.enterPromoCode();
        Thread.sleep(2000);
        adminOfferPage.clickBrowseImage(properties.getProperty("filePath"), properties.getProperty("correctImagePath"));
        Thread.sleep(4000);
        adminOfferPage.clickUploadImage();
        Thread.sleep(5000);
        adminOfferPage.selectOfferTypeGroup(DomainConstants.offerTypeGroupDiscount);
        adminOfferPage.selectOfferType(DomainConstants.offerTypeSignUp);
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferExpireDays(), DomainConstants.offerExpireDays);
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmount();
        adminOfferPage.enterMinimumOrderAmount();
        adminOfferPage.clickSaveOffer();
    }

    @Test(priority = 2)
    public void verifyCreateOrderTotalOfferWithValideData() throws InterruptedException, FindFailed {
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName();
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDateAsFutureDate();
        adminOfferPage.enterPromoCode();;
        Thread.sleep(2000);
        adminOfferPage.clickBrowseImage(properties.getProperty("filePath"), properties.getProperty("correctImagePath"));
        Thread.sleep(4000);
        adminOfferPage.clickUploadImage();
        Thread.sleep(5000);
        adminOfferPage.selectOfferTypeGroup(DomainConstants.offerTypeGroupDiscount);
        adminOfferPage.selectOfferType(DomainConstants.offerTypeOrderTotal);
        Thread.sleep(2000);
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmountForOrderTotalAndBirthday();
        adminOfferPage.enterMinimumOrderAmountForOrderTotalAndBirthday();
        adminOfferPage.clickSaveOffer();

    }

    @Test(priority = 3)
    public void verifyCreateBirthDayOfferWithValideData() throws InterruptedException, FindFailed {
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName();
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDateAsFutureDate();
        adminOfferPage.enterPromoCode();;
        Thread.sleep(2000);
        adminOfferPage.clickBrowseImage(properties.getProperty("filePath"), properties.getProperty("correctImagePath"));
        Thread.sleep(4000);
        adminOfferPage.clickUploadImage();
        Thread.sleep(5000);
        adminOfferPage.selectOfferTypeGroup(DomainConstants.offerTypeGroupDiscount);
        adminOfferPage.selectOfferType(DomainConstants.offerTypeBirthday);
        Thread.sleep(2000);
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmountForOrderTotalAndBirthday();
        adminOfferPage.enterMinimumOrderAmountForOrderTotalAndBirthday();
        adminOfferPage.clickSaveOffer();

    }

    @Test(priority = 4)
    public void verifyCreateSignUpOfferWithInValideData() throws InterruptedException, FindFailed {
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        Thread.sleep(2000);
        String offerName = adminOfferPage.getFirstOfferName();
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName(offerName);
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDateAsFutureDate();
        adminOfferPage.enterPromoCode();
        Thread.sleep(2000);
        adminOfferPage.clickBrowseImage(properties.getProperty("filePath"), properties.getProperty("correctImagePath"));
        Thread.sleep(4000);
        adminOfferPage.clickUploadImage();
        Thread.sleep(5000);
        adminOfferPage.selectOfferTypeGroup(DomainConstants.offerTypeGroupDiscount);
        adminOfferPage.selectOfferType(DomainConstants.offerTypeSignUp);
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferExpireDays(), DomainConstants.offerExpireDays);
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmount();
        adminOfferPage.enterMinimumOrderAmount();
        adminOfferPage.clickSaveOffer();
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferSavingErrorMessage(), DomainConstants.offerNameAlreadyExistMsg+offerName);
        Thread.sleep(2000);
        adminOfferPage.clickCloseOfferCreation();

    }

    @Test(priority = 5)
    public void verifyCloseCreateOfferForm() throws InterruptedException {
        Thread.sleep(2000);
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        adminOfferPage.clickCreatebtnOffer();
        Thread.sleep(2000);
        adminOfferPage.clickCloseOfferCreation();
        Assert.assertEquals(adminOfferPage.isCreateOfferButtonVisible(), true);
    }

    @Test(priority = 6)
    public void verifyMandetoryfieldsInOfferCreation() throws InterruptedException {
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        Thread.sleep(3000);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.clickSaveOffer();
        Assert.assertEquals(adminOfferPage.getReuiredErrorMessageInOfferName(), DomainConstants.fieldsRequiredMsg);
        Assert.assertEquals(adminOfferPage.getReuiredErrorMessageInOfferStartDate(), DomainConstants.fieldsRequiredMsg);
        Assert.assertEquals(adminOfferPage.getReuiredErrorMessageInOfferTypeGroup(), DomainConstants.fieldsRequiredMsg);
        Thread.sleep(2000);
        adminOfferPage.clickCloseOfferCreation();
    }

    @Test(priority = 7)
    public void verifyOfferEndDateGreaterThanOfferStartDate() throws InterruptedException {
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        Thread.sleep(2000);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName();
        adminOfferPage.enterStartDateAsFutureDate();
        adminOfferPage.enterEndDateAsTomorrowDate();
        Assert.assertEquals(adminOfferPage.getEndDateGreaterThanStartDateOfferErrorMessage(), DomainConstants.endDateShouldGraterThanStartDateErrorMsg);
        Thread.sleep(2000);
        adminOfferPage.clickCloseOfferCreation();
    }

    @Test(dataProvider = "optionalFieldInOfferCreation", dataProviderClass = TestDataProvider.class,priority = 8)
    public void verifyOptionalFieldsInCreateOffer(String endDate, String promoCode) throws InterruptedException {
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        Thread.sleep(2000);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName();
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDate(endDate);
        adminOfferPage.enterPromoCode(promoCode);
        adminOfferPage.selectOfferTypeGroup(DomainConstants.offerTypeGroupDiscount);
        adminOfferPage.selectOfferType(DomainConstants.offerTypeSignUp);
        Thread.sleep(2000);
        Assert.assertEquals(adminOfferPage.getOfferExpireDays(), DomainConstants.offerExpireDays);
        adminOfferPage.clickPercentageDiscount();
        adminOfferPage.enterDiscountAmount();
        adminOfferPage.enterMinimumOrderAmount();
        adminOfferPage.clickSaveOffer();
        Thread.sleep(2000);
        adminOfferPage.clickCloseOfferCreation();
    }

    @Test(dataProvider = "ImageSizeInOfferCreation", dataProviderClass = TestDataProvider.class,priority = 9, enabled = false)
    public void verifyUploadImageSizeInOffer(String offerImage,String errorMessage) throws InterruptedException, FindFailed {
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        Thread.sleep(2000);
        adminOfferPage.clickCreatebtnOffer();
        adminOfferPage.clickDropDownBtnStoreLocation();
        adminOfferPage.clickCheckBoxAllStoreLocation();
        Thread.sleep(2000);
        adminOfferPage.clickPromoCode();
        Thread.sleep(2000);
        adminOfferPage.enterOfferName();
        adminOfferPage.enterStartDate();
        adminOfferPage.enterEndDateAsFutureDate();
        adminOfferPage.enterPromoCode();
        Thread.sleep(2000);
        adminOfferPage.clickBrowseSmallImage();
//        Thread.sleep(5000);
        adminOfferPage.clickUploadImage();
        Thread.sleep(5000);
        Assert.assertEquals(adminOfferPage.smallImageErrorMessage(), errorMessage);
        adminOfferPage.clickCloseOfferForm();
        Thread.sleep(2000);
        adminOfferPage.clickCloseOfferCreation();
    }

    @Test(priority = 10)
    public void gettingSignUpAndOrderTotalOffers() throws InterruptedException, ParseException {
        AdminOfferPage adminOfferPage = PageFactory.initElements(driver, AdminOfferPage.class);
        Thread.sleep(2000);
        List<String> offerNames =  adminOfferPage.gettingActiveSignUpAndOrderTotalOffers(DomainConstants.resultPerPage10);
        StorefrontLoginPage storefrontLoginPage = PageFactory.initElements(driver, StorefrontLoginPage.class);
        storefrontLoginPage.navigateToLandingPage(properties.getProperty("storeFrontBaseURL"),0);
        storefrontLoginPage.clickValidateAgeButton();
        Thread.sleep(2000);
        List<String> guestUserOfferName = storefrontLoginPage.getGuestUserOfferNames();
        Assert.assertEquals(guestUserOfferName.stream().anyMatch(element -> offerNames.contains(element)),true);
        Assert.assertEquals(storefrontLoginPage.checkTextContainsInsideOffers(),true);
        Thread.sleep(2000);
        Assert.assertEquals(storefrontLoginPage.verifySignUpToViewMoreButtonFunctionality(),DomainConstants.signInMsg);
        Thread.sleep(2000);
        storefrontLoginPage.closeSignInPanel();

    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }

}
