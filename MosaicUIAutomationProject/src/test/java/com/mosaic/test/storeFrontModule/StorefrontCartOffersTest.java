package com.mosaic.test.storeFrontModule;

import com.mosaic.pages.storeFrontModule.StorefrontCartOffersPage;
import com.mosaic.pages.storeFrontModule.StorefrontRewardsPage;
import com.mosaic.util.TestBase;
import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StorefrontCartOffersTest extends TestBase {

    @BeforeClass
    public void storefrontUserLogin() throws InterruptedException {
        storeFrontUserLogin();
    }

    @Test
    public void applyOffers() throws InterruptedException {
        StorefrontCartOffersPage storefrontCartOffersPage = PageFactory.initElements(driver, StorefrontCartOffersPage.class);
        storefrontCartOffersPage.clickBtnOrderNow();
        Thread.sleep(5000);
        storefrontCartOffersPage.clickBtnSecondOrderNow();
        Thread.sleep(5000);
        storefrontCartOffersPage.clickAddProduct();
        Thread.sleep(3000);
        storefrontCartOffersPage.clickAddToCart();
        Thread.sleep(2000);
        storefrontCartOffersPage.clickProceedToCheckout();
        Thread.sleep(4000);
        storefrontCartOffersPage.getQualifyOfferCount();
        storefrontCartOffersPage.clickArrowIcon();
        Thread.sleep(4000);
        storefrontCartOffersPage.getApplyOfferCount();
        Assert.assertEquals(storefrontCartOffersPage.getQualifyOfferCount(),storefrontCartOffersPage.getApplyOfferCount());
        Thread.sleep(4000);
        Assert.assertEquals(storefrontCartOffersPage.getOfferName("Tier 01"),true);
        Thread.sleep(2000);
        storefrontCartOffersPage.selectOffer();
        storefrontCartOffersPage.getDiscountValueByRemovePercentage();
        storefrontCartOffersPage.clickApplyOffer();
        Thread.sleep(5000);
        Assert.assertEquals(storefrontCartOffersPage.getSystemAppliedDiscount(),storefrontCartOffersPage.getCalculatedDiscount());
        Thread.sleep(2000);
        storefrontCartOffersPage.clickCheckOutButton();
        Thread.sleep(10000);
        storefrontCartOffersPage.clickPayLater();
        Thread.sleep(2000);
        storefrontCartOffersPage.clickDoPayLater();
    }

}
