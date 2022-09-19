package com.mosaic.test.storeFrontModule;

import com.mosaic.pages.storeFrontModule.StorefrontCartOffersPage;
import com.mosaic.util.TestBase;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

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
