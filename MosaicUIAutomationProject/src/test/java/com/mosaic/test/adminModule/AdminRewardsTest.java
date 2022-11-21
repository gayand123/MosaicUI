package com.mosaic.test.adminModule;

import com.mosaic.pages.adminModule.AdminLoyaltyPage;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.pages.adminModule.AdminRewardsPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.RetryAnalyzer;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminRewardsTest extends TestBase {

    @BeforeClass
    public void loginAdminUser() throws InterruptedException {
        userLogin();
    }

    @Test
    public void createReward() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        AdminRewardsPage adminRewardsPage = PageFactory.initElements(driver, AdminRewardsPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnLoyalty();
        Thread.sleep(3000);
        adminRewardsPage.clickbtnRewards();
        Thread.sleep(2000);
        adminRewardsPage.clickbtnCreateNewRewards();
        adminRewardsPage.enterRewardName();
        adminRewardsPage.enterRewardDescription(DomainConstants.rewardDescription);
//        adminRewardsPage.selectRedeemableDiscountType("In USD");
        adminRewardsPage.enterThresholdOrderAmount(DomainConstants.thresholdOrderAmount);
        Thread.sleep(2000);
        adminRewardsPage.enterRedeemPoints(DomainConstants.redeemPoints);
        Thread.sleep(2000);
        adminRewardsPage.enterPercentageAmount(DomainConstants.percentageAmount);
        Thread.sleep(2000);
        adminRewardsPage.clickCreateRewardButton();



//        Assert.assertEquals(adminMenuPage.getTextOfRedeemPoints(),"Redeem Points");
//        AdminLoyaltyPage adminLoyaltyPage = PageFactory.initElements(driver, AdminLoyaltyPage.class);
//        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemPointsAvailableAndClickable(),false);
//        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountPercentageAvailableAndClickable(),false);
//        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountAvailableAndClickable(),false);

    }

    @Test
    public void calculateRewardsCount() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        AdminRewardsPage adminRewardsPage = PageFactory.initElements(driver, AdminRewardsPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnLoyalty();
        Thread.sleep(3000);
        adminRewardsPage.clickbtnRewards();
        Thread.sleep(2000);
        adminRewardsPage.checkRewardsCount();
    }
}
