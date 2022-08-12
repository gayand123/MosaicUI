package com.mosaic.test.adminModule;

import com.mosaic.pages.adminModule.AdminLoginPage;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminLoginTest extends TestBase {
    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        driver.get(properties.getProperty("baseURL"));
        AdminLoginPage adminLoginPage = PageFactory.initElements(driver, AdminLoginPage.class);
        adminLoginPage.clickSignIn();
        adminLoginPage.enterAdminUserName();
        adminLoginPage.enterAdminPassword();
        adminLoginPage.clickLogin();
        Thread.sleep(2000);
        Assert.assertEquals(adminLoginPage.getLoginMessage(),"Hi, Merchant");

    }






}
