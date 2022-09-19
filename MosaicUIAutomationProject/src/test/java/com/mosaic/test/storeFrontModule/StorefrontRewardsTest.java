package com.mosaic.test.storeFrontModule;

import com.mosaic.functionlayer.CustomerLoyaltyView;
import com.mosaic.pages.storeFrontModule.StorefrontRewardsPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StorefrontRewardsTest extends TestBase {
    Integer customerPoints;
    @BeforeClass
    public void storefrontUserLogin() throws InterruptedException {
  storeFrontUserLogin();
    }

  /*  @Test()
    public void comparePointBalanceWithAdminUsingValidCredentials() throws InterruptedException {
        setupPreRequisites(DomainConstants.browserMode);
        storeFrontUserLogin();
        StorefrontRewardsPage storefrontRewardsPage = PageFactory.initElements(driver, StorefrontRewardsPage.class);
        storefrontRewardsPage.clickButtonAvator();
        Thread.sleep(2000);
        storefrontRewardsPage.clickBtnRewards();
        Thread.sleep(2000);
        storefrontRewardsPage.getPointBalance();
        Assert.assertEquals(storefrontRewardsPage.getPointBalance(),customerPoints);
    }
*/
    @Test
    public void checkPointBalanceWithValidCredentials() throws InterruptedException {
        StorefrontRewardsPage storefrontRewardsPage = PageFactory.initElements(driver, StorefrontRewardsPage.class);
        storefrontRewardsPage.clickButtonAvator();
        Thread.sleep(2000);
        storefrontRewardsPage.clickBtnRewards();
        Thread.sleep(2000);
        storefrontRewardsPage.clickPointBalanceArrow();
        Thread.sleep(2000);
        storefrontRewardsPage.calculatePointBalance();
        Assert.assertEquals(Integer.parseInt(storefrontRewardsPage.getPointBalance()),storefrontRewardsPage.calculatePointBalance());
        storefrontRewardsPage.clickClosePointHistory();
    }

    @Test
    public void checkDateOrderWithValidCredentials() throws Exception {
        StorefrontRewardsPage storefrontRewardsPage = PageFactory.initElements(driver, StorefrontRewardsPage.class);
        storefrontRewardsPage.clickButtonAvator();
        Thread.sleep(2000);
        storefrontRewardsPage.clickBtnRewards();
        Thread.sleep(2000);
        storefrontRewardsPage.clickPointBalanceArrow();
        Thread.sleep(2000);
        storefrontRewardsPage.checkingDateOrder();
        Assert.assertEquals(storefrontRewardsPage.checkingDateOrder(),true);
        storefrontRewardsPage.clickClosePointHistory();
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
