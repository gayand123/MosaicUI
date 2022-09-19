package com.mosaic.functionlayer;

import com.mosaic.pages.adminModule.AdminCustomerPage;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.python.modules._sre;
import org.testng.Assert;
import sun.security.mscapi.CPublicKey;

public class CustomerLoyaltyView extends TestBase {
    Integer customerLoyaltyPoints;
    public int getCustomerLoyaltyPoints() throws InterruptedException {

        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnCustomers();
        Thread.sleep(2000);
        AdminCustomerPage adminCustomerPage = PageFactory.initElements(driver, AdminCustomerPage.class);
        Assert.assertEquals(adminCustomerPage.getCustomerText().contains("Customers"), true);
        adminCustomerPage.clickSpecificEmailActionInCustomersList(DomainConstants.resultPerPage10, DomainConstants.userEmail);
        Thread.sleep(2000);
        adminCustomerPage.clickViewEditPoints();
         return customerLoyaltyPoints = Integer.valueOf(adminCustomerPage.getCustomerCurrentPoints());
    }
}