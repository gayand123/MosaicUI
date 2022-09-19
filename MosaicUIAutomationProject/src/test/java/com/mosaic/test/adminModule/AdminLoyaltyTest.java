package com.mosaic.test.adminModule;

import com.mosaic.pages.adminModule.AdminLoyaltyPage;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminLoyaltyTest  extends TestBase {


    @BeforeClass
    public void loginAdminUser() throws InterruptedException {
        userLogin();
    }

    @Test
    public void verifyViewRedeemPointsValue() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnLoyalty();
       Assert.assertEquals(adminMenuPage.getTextOfRedeemPoints(),"Redeem Points");
        AdminLoyaltyPage adminLoyaltyPage = PageFactory.initElements(driver, AdminLoyaltyPage.class);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemPointsAvailableAndClickable(),false);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountPercentageAvailableAndClickable(),false);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountAvailableAndClickable(),false);
    }

    @Test
    public void verifyEditRedeemPointsValue() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnLoyalty();
        Assert.assertEquals(adminMenuPage.getTextOfRedeemPoints(),"Redeem Points");
        AdminLoyaltyPage adminLoyaltyPage = PageFactory.initElements(driver, AdminLoyaltyPage.class);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemPointsAvailableAndClickable(),false);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountPercentageAvailableAndClickable(),false);
        Assert.assertEquals(adminLoyaltyPage.isValueOfRedeemDiscountAvailableAndClickable(),false);
        adminLoyaltyPage.clickEditRedeemPoints();
    }
}