package com.mosaic.test.adminModule;

import com.mosaic.pages.adminModule.AdminCustomerPage;
import com.mosaic.pages.adminModule.AdminMenuPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.RetryAnalyzer;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminCustomerTest01 extends TestBase {
    @BeforeClass
    public void loginAdminUser() throws InterruptedException {
        userLogin();
    }

  /*  @Test
    public void verifyCustomerCountInViewCustomerList() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnCustomers();
        Thread.sleep(2000);
        AdminCustomerPage adminCustomerPage = PageFactory.initElements(driver, AdminCustomerPage.class);
        Assert.assertEquals(adminCustomerPage.getCustomerText().contains("Customers"), true);
        Assert.assertEquals(adminCustomerPage.getRowCountInCustomers(DomainConstants.resultPerPage10),adminCustomerPage.getCustomerCount());

    }

    @Test
    public void verifyResultPerPageInCustomerList() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnCustomers();
        Thread.sleep(2000);
        AdminCustomerPage adminCustomerPage = PageFactory.initElements(driver, AdminCustomerPage.class);
        Assert.assertEquals(adminCustomerPage.getCustomerText().contains("Customers"), true);
        Thread.sleep(2000);
        adminCustomerPage.clickResultPerpage();
        adminCustomerPage.clickResultPerPageValue(DomainConstants.resultPerPage30);
        Assert.assertEquals(adminCustomerPage.getRowCount301InCustomers(DomainConstants.resultPerPage30),adminCustomerPage.getCustomerCount());
    }

   */

    @Test (priority = 1,retryAnalyzer= RetryAnalyzer.class)
    public void verifyEmailInCustomerList() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnCustomers();
        Thread.sleep(2000);
        AdminCustomerPage adminCustomerPage = PageFactory.initElements(driver, AdminCustomerPage.class);
        Assert.assertEquals(adminCustomerPage.getCustomerText().contains("Customers"), true);
        Assert.assertEquals(adminCustomerPage.isSpecificEmailAvailableInCustomersList(DomainConstants.resultPerPage10,"gayandunuwila+qa100@gmail.com"),true);

    }
  /*
    @Test (priority = 2)
    public void verifyEditCustomerInCustomerList() throws InterruptedException {
        AdminMenuPage adminMenuPage = PageFactory.initElements(driver, AdminMenuPage.class);
        adminMenuPage.clickMenu();
        adminMenuPage.clickbtnCustomers();
        Thread.sleep(2000);
        AdminCustomerPage adminCustomerPage = PageFactory.initElements(driver, AdminCustomerPage.class);
        Assert.assertEquals(adminCustomerPage.getCustomerText().contains("Customers"), true);
        adminCustomerPage.clickSpecificEmailActionInCustomersList(DomainConstants.resultPerPage10,DomainConstants.userEmail);
        Thread.sleep(2000);
        adminCustomerPage.clickViewEditPoints();
        Assert.assertEquals(adminCustomerPage.getViewEditPointsText(),"Loyalty Points Summary");
        // Assert.assertEquals(adminCustomerPage.getCustomerCurrentPoints(),"18963");

    }

   */
    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
