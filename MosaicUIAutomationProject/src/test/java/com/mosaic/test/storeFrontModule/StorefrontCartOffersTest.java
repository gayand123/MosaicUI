package com.mosaic.test.storeFrontModule;

import com.mosaic.pages.storeFrontModule.StorefrontCartOffersPage;
import com.mosaic.pages.storeFrontModule.StorefrontRewardsPage;
import com.mosaic.util.TestBase;
import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StorefrontCartOffersTest extends TestBase {

    @BeforeClass
    public void storefrontUserLogin() throws InterruptedException {
        storeFrontUserLogin();
    }

    @Test
    public void checkOfferCount() throws InterruptedException {

        StorefrontCartOffersPage storefrontCartOffersPage = PageFactory.initElements(driver, StorefrontCartOffersPage.class);
        storefrontCartOffersPage.clickBtnOrderNow();
    }

}
