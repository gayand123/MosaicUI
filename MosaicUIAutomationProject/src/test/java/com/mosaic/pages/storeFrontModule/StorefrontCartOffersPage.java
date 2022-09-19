package com.mosaic.pages.storeFrontModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.storeFrontModule.ElementsCartOffers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorefrontCartOffersPage extends TestBase {

    @FindBy(xpath = ElementsCartOffers.btnOrderNow)
    private WebElement btnOrderNow;

    public void clickBtnOrderNow() {

        clickOnElement(btnOrderNow);
    }
}
