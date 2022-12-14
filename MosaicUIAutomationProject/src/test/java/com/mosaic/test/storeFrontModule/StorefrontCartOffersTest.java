package com.mosaic.test.storeFrontModule;

import com.mosaic.pages.storeFrontModule.StorefrontCartOffersPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StorefrontCartOffersTest extends TestBase {

    @BeforeClass
    public void storefrontUserLogin() throws InterruptedException {
        setupPreRequisites(DomainConstants.browserMode);
        storeFrontUserLogin();
    }

    @Test
    public void applyOffers() throws InterruptedException {
        StorefrontCartOffersPage storefrontCartOffersPage = PageFactory.initElements(driver, StorefrontCartOffersPage.class);
        Thread.sleep(3000);
        storefrontCartOffersPage.clickBtnOrderNow();
        Thread.sleep(5000);
        storefrontCartOffersPage.clickBtnSecondOrderNow();
        Thread.sleep(5000);
        storefrontCartOffersPage.clickAvailableProduct();
        Thread.sleep(2000);
        storefrontCartOffersPage.getQualifyOfferCount();
        Thread.sleep(2000);
        storefrontCartOffersPage.clickArrowIcon();
        Thread.sleep(4000);
        storefrontCartOffersPage.getApplyOfferCount();
        Assert.assertEquals(storefrontCartOffersPage.getQualifyOfferCount(),storefrontCartOffersPage.getApplyOfferCount());
        Thread.sleep(4000);
        Assert.assertEquals(storefrontCartOffersPage.getOfferName(DomainConstants.offerName),true);
        Thread.sleep(2000);
        storefrontCartOffersPage.selectOffer();
        storefrontCartOffersPage.getDiscountValueByRemovePercentage();
        storefrontCartOffersPage.clickApplyOffer();
        Thread.sleep(6000);
        Assert.assertEquals(storefrontCartOffersPage.getSystemAppliedDiscount(),storefrontCartOffersPage.getCalculatedDiscount());
        Thread.sleep(2000);
        storefrontCartOffersPage.clickCheckOutButton();
        Thread.sleep(10000);
        storefrontCartOffersPage.clickPayLater();
        Thread.sleep(2000);
        storefrontCartOffersPage.clickDoPayLater();
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }

}
