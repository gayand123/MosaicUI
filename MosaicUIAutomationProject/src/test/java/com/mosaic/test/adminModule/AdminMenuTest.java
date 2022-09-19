package com.mosaic.test.adminModule;

import com.mosaic.pages.adminModule.AdminLoginPage;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminMenuTest extends TestBase {
    @BeforeClass
    public void loginAdminUser() throws InterruptedException {
        userLogin();
    }

    @Test
    public void viewOfferList() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnOffer();
        adminMenuPage.getTextBtnOffer();
        Assert.assertEquals( adminMenuPage.getTextBtnOffer(),"Create Offer");

    }
}
