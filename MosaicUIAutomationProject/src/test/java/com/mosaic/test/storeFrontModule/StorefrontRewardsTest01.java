package com.mosaic.test.storeFrontModule;

import com.mosaic.functionlayer.CustomerLoyaltyView;
import com.mosaic.pages.storeFrontModule.StorefrontRewardsPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.checkerframework.dataflow.qual.TerminatesExecution;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StorefrontRewardsTest01 extends TestBase {
    Integer customerPoints;
    @BeforeClass
    public void storefrontUserLogin() throws InterruptedException {

        CustomerLoyaltyView customerLoyaltyView= new CustomerLoyaltyView();
        customerPoints = customerLoyaltyView.getCustomerLoyaltyPoints();
        System.out.println(  "points"+   customerPoints);
        System.out.println("I am in ");
        //  storeFrontUserLogin();
    }

    @Test()
    public void comparePointBalanceWithAdminUsingValidCredentials() throws InterruptedException {
        setupPreRequisites(DomainConstants.browserMode);
        storeFrontUserLogin();
        StorefrontRewardsPage storefrontRewardsPage = PageFactory.initElements(driver, StorefrontRewardsPage.class);
        Thread.sleep(2000);
        storefrontRewardsPage.clickButtonAvator();
        Thread.sleep(2000);
        storefrontRewardsPage.clickBtnRewards();
        Thread.sleep(2000);
        storefrontRewardsPage.getPointBalance();
        Assert.assertEquals(storefrontRewardsPage.getPointBalance(),customerPoints);
    }

    @Test
    public void checkAvailabilityOfPointBalanceBar() throws InterruptedException {
        setupPreRequisites(DomainConstants.browserMode);
        storeFrontUserLogin();
        StorefrontRewardsPage storefrontRewardsPage = PageFactory.initElements(driver, StorefrontRewardsPage.class);
        storefrontRewardsPage.clickButtonAvator();
        Thread.sleep(2000);
        storefrontRewardsPage.clickBtnRewards();
        Thread.sleep(2000);
        storefrontRewardsPage.getPointBalance();
        Assert.assertEquals(storefrontRewardsPage.isPointBalanceBarVisibleWhenEnabledLevel(),true);
        /*
        * Need to add code for go to previous tab
        * driver.switchTo().window(driver.getWindowHandle());
        * */
        Assert.assertEquals(storefrontRewardsPage.isPointBalanceBarVisibleWhenDisabledLevel(),true);
    }


    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
