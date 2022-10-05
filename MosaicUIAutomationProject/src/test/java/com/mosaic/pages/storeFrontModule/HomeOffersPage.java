package com.mosaic.pages.storeFrontModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.storeFrontModule.ElementsCartOffers;
import com.mosaic.util.storeFrontModule.ElementsHomePageOffers;
import com.mosaic.util.storeFrontModule.ElementsLoyaltyOffers;
import jnr.ffi.annotations.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.python.antlr.ast.Str;

import java.util.ArrayList;
import java.util.List;

public class HomeOffersPage extends TestBase {

    @FindBy(xpath = ElementsHomePageOffers.listHomePageOffers)
    private WebElement listHomePageOffers;

    @FindBy(xpath = ElementsHomePageOffers.btnViewAll)
    private WebElement btnViewAll;

    @FindBy(xpath = ElementsHomePageOffers.lblTag)
    private WebElement lblTag;

    @FindBy(xpath = ElementsHomePageOffers.lblOfferActivatedDate)
    private WebElement lblOfferActivatedDate;

    @FindBy(xpath = ElementsHomePageOffers.lblOfferName)
    private WebElement lblOfferName;

    @FindBy(xpath = ElementsHomePageOffers.btnOfferTile)
    private WebElement btnOfferTile;

    @FindBy(xpath = ElementsHomePageOffers.lblOfferNameInSideDrawer)
    private WebElement lblOfferNameInSideDrawer;

    @FindBy(xpath = ElementsHomePageOffers.btnClose)
    private WebElement btnClose;

    @FindBy(xpath = ElementsLoyaltyOffers.lblGetPointBalance)
    private WebElement lblGetPointBalance;

    @FindBy(xpath = ElementsHomePageOffers.btnAvator)
    private WebElement btnAvator;
    @FindBy(xpath = ElementsHomePageOffers.btnRewards)
    private WebElement btnRewards;

    public boolean getHomePageOfferCountAndCheckViewAllButton() throws InterruptedException{
        scrollDown();
        int offerCount = driver.findElements(By.xpath(ElementsHomePageOffers.listHomePageOffers)).size();
        if (offerCount == 4 ){
            try{
                if(isElementPresent(By.xpath(ElementsHomePageOffers.btnViewAll))){
                    return true;
                }
                else{
                    return false;
                }
            }catch (Exception e){
            System.out.println("Exception Occured");
            }
        }
        return true;
    }

    public boolean checkUnAvailabilityOfExpiredTag(String expiredTag){
        List<String> offerTags = new ArrayList<>();
        int tagNameCount = driver.findElements(By.xpath(ElementsHomePageOffers.lblTag)).size();
        for(int count= 0; count< tagNameCount; count++){
            String tagName = driver.findElements(By.xpath(ElementsHomePageOffers.lblTag)).get(count).getText();
            offerTags.add(tagName);
        }
        if(offerTags.contains(expiredTag)){
            return false;
        }else{
            return true;
        }
    }

//TODO Need to improve this method. Not totally implemented.
    public void checkDatesOrder(){
        List<String> dates =  new ArrayList<>();
        int offerCount = driver.findElements(By.xpath(ElementsHomePageOffers.lblOfferActivatedDate)).size();

        for (int count = 0; count < offerCount; count++) {
            String activatedDate = driver.findElements(By.xpath(ElementsHomePageOffers.lblOfferActivatedDate)).get(count).getText();
            dates.add(activatedDate);
        }
//        System.out.println("Created date List "+ dates);

    }

    public boolean isCheckEqualityOfNames() throws InterruptedException{
        String offerName = driver.findElement(By.xpath(ElementsHomePageOffers.lblOfferName)).getText();
        clickOnElement(btnOfferTile);
        Thread.sleep(2000);
        String sideDrawerOfferName = driver.findElement(By.xpath(ElementsHomePageOffers.lblOfferNameInSideDrawer)).getText();
        Thread.sleep(2000);
        if(offerName.equals(sideDrawerOfferName)){
            return true;
        }else{
            return false;
        }
    }

    public void closeSideDrawer(){
        clickOnElement(btnClose);
    }

    public boolean isGoToLoyaltyPageByClickingViewAllOrRewardIcon() throws InterruptedException {
        try{
            if(isElementPresent(By.xpath(ElementsHomePageOffers.btnViewAll))){
                clickOnElement(btnViewAll);
                if(isElementPresent(By.xpath(ElementsLoyaltyOffers.lblGetPointBalance))){
                    return true;
                }else{
                    return false;
                }
            }
        }catch(Exception e){
            clickOnElement(btnAvator);
            Thread.sleep(2000);
            clickOnElement(btnRewards);
            if(isElementPresent(By.xpath(ElementsLoyaltyOffers.lblGetPointBalance))){
                return true;
            }else{
                return false;
            }

        }
        return false;
    }
}
