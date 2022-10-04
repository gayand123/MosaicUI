package com.mosaic.test.storeFrontModule;

import com.mosaic.pages.storeFrontModule.StorefrontLoginPage;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StorefrontLoginTest extends TestBase {
    @BeforeClass
     public void Login() throws InterruptedException {
        setupPreRequisites(DomainConstants.browserMode);
    }
    @Test
    public void loginWithValidCredentials(){

        driver.get(properties.getProperty("storeFrontBaseURL"));
        StorefrontLoginPage storefrontLoginPage = PageFactory.initElements(driver, StorefrontLoginPage.class);
        storefrontLoginPage.clickValidateAgeButton();
        storefrontLoginPage.clickButtonSignIn();
        storefrontLoginPage.enterUserName();
        storefrontLoginPage.enterPassword();
        storefrontLoginPage.clickButtonSignInStoreFront();
    }
    @AfterClass
    public void closeBrowser(){
        driver.close();}
}
