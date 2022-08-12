package com.mosaic.pages.adminModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.adminModule.ElementsLoyalty;
import com.mosaic.util.adminModule.ElementsMenu;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoyaltyPage extends TestBase {
    @FindBy(xpath = ElementsLoyalty.txtRedeemPoints)
    private WebElement txtRedeemPoints;
    @FindBy(xpath = ElementsLoyalty.txtRedeemDiscountPercentage)
    private WebElement txtRedeemDiscountPercentage;
    @FindBy(xpath = ElementsLoyalty.txtAreaRedeemTierDescription)
    private WebElement txtAreaRedeemTierDescription;

    @FindBy(xpath = ElementsLoyalty.btnEditRedeemPoints)
    private WebElement btnEditRedeemPoints;

    public boolean isValueOfRedeemPointsAvailableAndClickable() {
        return getAttributeValue(txtRedeemPoints).isEmpty() && isElementEnabled(txtRedeemPoints);
    }


    public boolean isValueOfRedeemDiscountPercentageAvailableAndClickable() {
        return getAttributeValue(txtRedeemDiscountPercentage).isEmpty() && isElementEnabled(txtRedeemDiscountPercentage);
    }

    public boolean isValueOfRedeemDiscountAvailableAndClickable() {
        return getAttributeValue(txtAreaRedeemTierDescription).isEmpty() && isElementEnabled(txtAreaRedeemTierDescription) ;
    }

    public void clickEditRedeemPoints() {
        clickOnElement(btnEditRedeemPoints);
    }
}
