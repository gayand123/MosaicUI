package com.mosaic.test.storeFrontModule;

import com.mosaic.pages.storeFrontModule.HomeOffersPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageOffersTest extends TestBase {

    @BeforeClass
    public void storefrontUserLogin() throws InterruptedException {
        setupPreRequisites(DomainConstants.browserMode);
        storeFrontUserLogin();
    }

    @Test
    public void validateOfferDetailsInHomePage() throws InterruptedException {
        HomeOffersPage homeOffersPage = PageFactory.initElements(driver, HomeOffersPage.class);
        Assert.assertEquals(homeOffersPage.getHomePageOfferCountAndCheckViewAllButton(),true);
        Assert.assertEquals(homeOffersPage.checkUnAvailabilityOfExpiredTag(DomainConstants.expiredTag),true);
        homeOffersPage.checkDatesOrder();
        Assert.assertEquals(homeOffersPage.isCheckEqualityOfNames(),true);
        homeOffersPage.closeSideDrawer();
        Thread.sleep(2000);
        Assert.assertEquals(homeOffersPage.isGoToLoyaltyPageByClickingViewAllOrRewardIcon(),true);
    }
    @AfterClass
    public void closeBrowser(){
//        driver.close();
    }

}
