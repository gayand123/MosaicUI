package com.mosaic.test.storeFrontModule;

import com.mosaic.pages.storeFrontModule.HomeOffersPage;
import com.mosaic.pages.storeFrontModule.LoyaltyOffersPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoyaltyOffersTest extends TestBase {

    @BeforeClass
    public void storefrontUserLogin() throws InterruptedException {
        setupPreRequisites(DomainConstants.browserMode);
        storeFrontUserLogin();
    }

    @Test
    public void validateOfferDetailsInLoyaltyPage() throws InterruptedException {
        LoyaltyOffersPage loyaltyOffersPage = PageFactory.initElements(driver, LoyaltyOffersPage.class);
        HomeOffersPage homeOffersPage = PageFactory.initElements(driver, HomeOffersPage.class);
        Assert.assertEquals(homeOffersPage.isGoToLoyaltyPageByClickingViewAllOrRewardIcon(),true);
        Thread.sleep(2000);
        Assert.assertEquals(loyaltyOffersPage.isCheckClickabilityOfExpiredOffers(),true);
        Assert.assertEquals(loyaltyOffersPage.isCheckNewOfferCount(),true);
    }
    @AfterClass
    public void closeBrowser(){
//        driver.close();
    }
}
