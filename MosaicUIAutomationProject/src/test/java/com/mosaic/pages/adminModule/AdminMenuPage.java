package com.mosaic.pages.adminModule;

import com.mosaic.util.adminModule.ElementsMenu;
import com.mosaic.util.adminModule.ElementsOffers;
import com.mosaic.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminMenuPage extends TestBase {
    //Define Elements
    @FindBy(xpath = ElementsMenu.btnMenu)
    private WebElement btnMenu;
    @FindBy(xpath = ElementsMenu.btnOffers)
    private WebElement btnOffers;

    @FindBy(xpath = ElementsOffers.btnCreateOffer)
    private WebElement btnCreateOffer;

    @FindBy(xpath = ElementsMenu.btnLoyalty)
    private WebElement btnLoyalty;
    @FindBy(xpath = ElementsMenu.lblRedeemPoints)
    private WebElement lblRedeemPoints;

    @FindBy(xpath = ElementsMenu.btnCustomers)
    private WebElement btnCustomers;


    @FindBy(xpath = ElementsMenu.btnCloseMenuForm)
    private WebElement btnCloseMenuForm;

    public void clickMenu(){
        waitUntilVisibilityOfElement(By.xpath(ElementsMenu.btnMenu));
        clickOnElement(btnMenu);
    }
    public void clickbtnOffer(){
        waitUntilVisibilityOfElement(By.xpath(ElementsMenu.btnOffers));
        clickOnElement(btnOffers);
    }
    public String getTextBtnOffer(){
        waitUntilVisibilityOfElement(By.xpath(ElementsOffers.btnCreateOffer));
      return   getElementText(btnCreateOffer);
    }
    public void clickbtnLoyalty(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitUntilVisibilityOfElement(By.xpath(ElementsMenu.btnLoyalty));
        clickOnElement(btnLoyalty);
    }

    public void clickbtnCustomers(){
        waitUntilVisibilityOfElement(By.xpath(ElementsMenu.btnCustomers));
        clickOnElement(btnCustomers);
    }

    public String getTextOfRedeemPoints(){
        waitUntilVisibilityOfElement(By.xpath(ElementsMenu.lblRedeemPoints));
       return getElementText(lblRedeemPoints);
    }

    public void closeMenu(){
        clickOnElement(btnCloseMenuForm);
    }
}
