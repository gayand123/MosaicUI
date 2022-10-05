package com.mosaic.pages.storeFrontModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.storeFrontModule.ElementsHomePageOffers;
import com.mosaic.util.storeFrontModule.ElementsLoyaltyOffers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoyaltyOffersPage extends TestBase {

    @FindBy(xpath = ElementsLoyaltyOffers.lblExpired)
    private WebElement lblExpired;

    @FindBy(xpath = ElementsLoyaltyOffers.lblSideDrawer)
    private WebElement lblSideDrawer;

    @FindBy(xpath = ElementsLoyaltyOffers.lblNew)
    private WebElement lblNew;

    @FindBy(xpath = ElementsLoyaltyOffers.lblOfferCount)
    private WebElement lblOfferCount;

    public boolean isCheckClickabilityOfExpiredOffers() throws InterruptedException {
        clickOnElement(lblExpired);
        Thread.sleep(2000);
        try{
            if(isElementPresentAndDisplay(lblSideDrawer)){
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            return true;
        }

    }

    public boolean isCheckNewOfferCount(){
        int newTagCount = driver.findElements(By.xpath(ElementsLoyaltyOffers.lblNew)).size();
        int offerCount = Integer.parseInt(driver.findElement(By.xpath(ElementsLoyaltyOffers.lblOfferCount)).getText());
        if(newTagCount==offerCount){
            return true;
        }else{
            return false;
        }

    }
}
