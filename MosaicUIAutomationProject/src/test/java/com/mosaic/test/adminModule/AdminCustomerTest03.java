package com.mosaic.test.adminModule;

import com.mosaic.pages.adminModule.AdminCustomerPage;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.RetryAnalyzer;
import com.mosaic.util.TestBase;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminCustomerTest03 extends TestBase {
    @BeforeClass
    public void loginAdminUser() throws InterruptedException {
        userLogin();
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void verifyResultPerPageInCustomerList() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnCustomers();
        Thread.sleep(2000);
        AdminCustomerPage adminCustomerPage = PageFactory.initElements(driver, AdminCustomerPage.class);
        Assert.assertEquals(adminCustomerPage.getCustomerText().contains(DomainConstants.customersTXT), true);
        Thread.sleep(2000);
        adminCustomerPage.clickResultPerpage();
        adminCustomerPage.clickResultPerPageValue(DomainConstants.resultPerPage30);
        Assert.assertEquals(adminCustomerPage.getRowCount301InCustomers(DomainConstants.resultPerPage30), adminCustomerPage.getCustomerCount());
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }
}