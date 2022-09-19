package com.mosaic.test.adminModule;

import com.mosaic.pages.adminModule.AdminLoyaltyPage;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.util.RetryAnalyzer;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminLoyaltyTest  extends TestBase {


    @BeforeClass
    public void loginAdminUser() throws InterruptedException {
        userLogin();
    }

    @Test(priority = 1,retryAnalyzer= RetryAnalyzer.class)
    public void verifyViewRedeemPointsValue() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnLoyalty();
       Assert.assertEquals(adminMenuPage.getTextOfRedeemPoints(),"Redeem Points");
        AdminLoyaltyPage adminLoyaltyPage = PageFactory.initElements(driver, AdminLoyaltyPage.class);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemPointsAvailableAndClickable(),false);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountPercentageAvailableAndClickable(),false);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountAvailableAndClickable(),false);
        System.out.println("I am out");
    }

    @Test(priority = 2,retryAnalyzer= RetryAnalyzer.class)
    public void verifyEditRedeemPointsValue() throws InterruptedException {
        System.out.println("I am in 1");
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        System.out.println("I am in 2");
        Thread.sleep(1000);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnLoyalty();
        Assert.assertEquals(adminMenuPage.getTextOfRedeemPoints(),"Redeem Points");
        AdminLoyaltyPage adminLoyaltyPage = PageFactory.initElements(driver, AdminLoyaltyPage.class);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemPointsAvailableAndClickable(),false);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountPercentageAvailableAndClickable(),false);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountAvailableAndClickable(),false);
        adminLoyaltyPage.clickEditRedeemPoints();
    }
    @AfterClass
    public void closeBrowser(){
        //driver.close();
    }
}