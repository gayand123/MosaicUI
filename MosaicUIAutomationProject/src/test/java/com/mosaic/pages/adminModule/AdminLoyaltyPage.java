package com.mosaic.pages.adminModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.adminModule.ElementsLoyalty;
import com.mosaic.util.adminModule.ElementsMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    @FindBy(xpath = ElementsLoyalty.btnEdit)
    private WebElement btnEdit;

    @FindBy(xpath = ElementsLoyalty.btnLevelTwo)
    private WebElement btnLevelTwo;

    @FindBy(xpath = ElementsLoyalty.btnLevelThree)
    private WebElement btnLevelThree;

    @FindBy(xpath = ElementsLoyalty.btnDownGradeToggleLevel2)
    private WebElement btnDownGradeToggleLevel2;

    @FindBy(xpath = ElementsLoyalty.btnDownGradeToggleLevel3)
    private WebElement btnDownGradeToggleLevel3;


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

    public void clickEditLevels(){
        clickOnElement(btnEdit);
    }
    public void disableLevels() throws InterruptedException{
        scrollDown();
        Thread.sleep(3000);
        clickOnElement(btnLevelTwo);
//       if(driver.findElement(By.xpath(ElementsLoyalty.btnDownGradeToggleLevel2)).isEnabled()){
//            System.out.println("Turned On");
////            driver.findElement(By.xpath(ElementsLoyalty.btnDownGradeToggleLevel2)).click();
//       }else{
//           driver.findElement(By.xpath(ElementsLoyalty.btnDownGradeToggleLevel2)).click();
//       }

    }
}
