package com.mosaic.pages.storeFrontModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.storeFrontModule.ElementsCartOffers;
import com.mosaic.util.storeFrontModule.ElementsRewards;
import jnr.ffi.annotations.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.mosaic.util.storeFrontModule.ElementsCartOffers.postbtnAddProduct;
import static com.mosaic.util.storeFrontModule.ElementsCartOffers.prebtnAddProduct;

public class StorefrontCartOffersPage extends TestBase {

    @FindBy(xpath = ElementsCartOffers.btnOrderNow)
    private WebElement btnOrderNow;

    @FindBy(xpath = ElementsCartOffers.btnSecondOrderNow)
    private WebElement btnSecondOrderNow;

   // @FindBy(xpath = ElementsCartOffers.btnAddProduct)
   // private WebElement btnAddProduct;

    @FindBy(xpath = ElementsCartOffers.btnAddToCart)
    private WebElement btnAddToCart;

    @FindBy(xpath = ElementsCartOffers.btnProceedToCheckout)
    private WebElement btnProceedToCheckout;

    @FindBy(xpath = ElementsCartOffers.txtQualifyOfferCount)
    private WebElement txtQualifyOfferCount;

    @FindBy(xpath = ElementsCartOffers.txtClickArrowIcon)
    private WebElement txtClickArrowIcon;

    @FindBy(xpath = ElementsCartOffers.listApplyOffers)
    private WebElement listApplyOffers;

    @FindBy(xpath = ElementsCartOffers.btnClose)
    private WebElement btnClose;

    @FindBy(xpath = ElementsCartOffers.listOfferNames)
    private WebElement listOfferNames;

    @FindBy(xpath = ElementsCartOffers.btlOfferCheckBox)
    private WebElement btlOfferCheckBox;

    @FindBy(xpath = ElementsCartOffers.btnApplyOffer)
    private WebElement btnApplyOffer;

    @FindBy(xpath = ElementsCartOffers.lblDiscountValue)
    private WebElement lblDiscountValue;

    @FindBy(xpath = ElementsCartOffers.lblSubTotal)
    private WebElement lblSubTotal;

    @FindBy(xpath = ElementsCartOffers.lblAppliedDiscount)
    private WebElement lblAppliedDiscount;

    @FindBy(xpath = ElementsCartOffers.btnCheckout)
    private WebElement btnCheckout;

    @FindBy(xpath = ElementsCartOffers.btnSelectPayLater)
    private WebElement btnSelectPayLater;

    @FindBy(xpath = ElementsCartOffers.btnDoPayLater)
    private WebElement btnDoPayLater;

    public void clickBtnOrderNow() {

        clickOnElement(btnOrderNow);
    }

    public void clickBtnSecondOrderNow() throws InterruptedException{
        clickOnElement(btnSecondOrderNow);
        Thread.sleep(1000);
    }

    public void clickAddProduct(String productName) throws InterruptedException{

        clickOnElement( driver.findElement(By.xpath(prebtnAddProduct+productName+postbtnAddProduct)));
        Thread.sleep(2000);
//        scrollDown();
    }

    public void clickAddToCart() throws InterruptedException{
        Thread.sleep(1000);
        clickOnElement(btnAddToCart);
    }

    public void clickProceedToCheckout() throws InterruptedException{
        Thread.sleep(1000);
        clickOnElement(btnProceedToCheckout);
    }

    public int getQualifyOfferCount(){
        String OfferCount = getElementText(txtQualifyOfferCount);
        return Integer.parseInt(OfferCount);
    }

    public void clickArrowIcon(){
        clickOnElement(txtClickArrowIcon);
    }

    public int getApplyOfferCount(){
        int offerCount = driver.findElements(By.xpath(ElementsCartOffers.listApplyOffers)).size();
        return offerCount;
    }

    public void clickCloseButton(){
        clickOnElement(btnClose);
    }

    public boolean getOfferName(String name){
        int offerCount = driver.findElements(By.xpath(ElementsCartOffers.listOfferNames)).size();
        List<String> offerNames = new ArrayList<>();

        for (int count =0; count< offerCount; count++){
            String OfferName = driver.findElements(By.xpath(ElementsCartOffers.listOfferNames)).get(count).getText();
            offerNames.add(OfferName);
        }
        if(offerNames.contains(name)){
            return true;
        }else{
            return false;
        }
    }

    public void selectOffer(){
        clickOnElement(btlOfferCheckBox);
    }

    int discountValue =0;
    public void getDiscountValueByRemovePercentage(){
        String discount = getElementText(lblDiscountValue);
        discount = discount.replace("%","");
        discountValue = Integer.parseInt(discount);
    }

    public void clickApplyOffer(){
        clickOnElement(btnApplyOffer);
    }
    public Double getSubTotalByRemove$Sign(){
        String total = getElementText(lblSubTotal);
        total = total.replace("$","");
        Double subTotal = Double.parseDouble(total);
        return subTotal;
    }


    public Double getCalculatedDiscount(){
        Double subTotal = getSubTotalByRemove$Sign();
        Double discountAmount =  (subTotal * discountValue) / 100;
        return discountAmount;
    }

    public Double getSystemAppliedDiscount(){
        String discount =  getElementText(lblAppliedDiscount);
        discount = discount.replace("$","");
        discount = discount.replace("-","");
        Double appliedDiscount = Double.parseDouble(discount);
        return  appliedDiscount;
    }

    public void clickCheckOutButton(){
        clickOnElement(btnCheckout);
    }
    public void clickPayLater(){
        clickOnElement(btnSelectPayLater);
    }

    public void clickDoPayLater(){
        clickOnElement(btnDoPayLater);
    }
}
