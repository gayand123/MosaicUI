package com.mosaic.pages.storeFrontModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.adminModule.ElementsMenu;
import com.mosaic.util.storeFrontModule.ElementsHomePageOffers;
import com.mosaic.util.storeFrontModule.ElementsSignIn;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StorefrontLoginPage extends TestBase {

    @FindBy(xpath = ElementsSignIn.btnValidateAge)
    private WebElement btnValidateAge;

    @FindBy(xpath = ElementsSignIn.btnSignIn)
    private WebElement btnSignIn;

    @FindBy(xpath = ElementsSignIn.txtUserEmail)
    private WebElement txtUserEmail;
    @FindBy(xpath = ElementsSignIn.txtPassword)
    private WebElement txtPassword;

    @FindBy(xpath = ElementsSignIn.btnSignInStoreFront)
    private WebElement btnSignInStoreFront;

    @FindBy(xpath = ElementsSignIn.lblGuestUserOfferName)
    private WebElement lblGuestUserOfferName;

    @FindBy(xpath = ElementsSignIn.lblSideDrawerOfferName)
    private WebElement lblSideDrawerOfferName;

    @FindBy(xpath = ElementsSignIn.lblParagraphTextInSideDrawer)
    private WebElement lblParagraphTextInSideDrawer;

    @FindBy(xpath = ElementsSignIn.btnSideDrawerClose)
    private WebElement btnSideDrawerClose;

    @FindBy(xpath = ElementsSignIn.btnSignUpToViewMore)
    private WebElement btnSignUpToViewMore;

    @FindBy(xpath = ElementsSignIn.btnCloseSignInPanel)
    private WebElement btnCloseSignInPanel;

    public void enterUserName(){
        clearAndType(txtUserEmail,  properties.getProperty("userEmail"));
    }

    public void enterPassword(){
        clearAndType(txtPassword, properties.getProperty("userPassword"));
    }

    public void clickValidateAgeButton(){
        clickOnElement(btnValidateAge);
    }

    public void clickButtonSignIn(){
        waitUntilVisibilityOfElement(By.xpath(ElementsMenu.btnSignIn));
        clickOnElement(btnSignIn);
    }

    public void clickButtonSignInStoreFront(){
        clickOnElement(btnSignInStoreFront);
    }

    public List<String> getGuestUserOfferNames() throws InterruptedException{
        List<String> offerNames =  new ArrayList<>();
        scrollDown();
        int offerCount = driver.findElements(By.xpath(ElementsSignIn.lblGuestUserOfferName)).size();
        for (int count =0; count < offerCount; count++){
            String name = driver.findElements(By.xpath(ElementsSignIn.lblGuestUserOfferName)).get(count).getText();
            offerNames.add(name);
        }
        return offerNames;
    }

    public boolean checkTextContainsInsideOffers() throws InterruptedException{
        String offerName = driver.findElements(By.xpath(ElementsSignIn.lblFistGuestUserOfferName)).get(1).getText();
        clickOnElement(driver.findElements(By.xpath(ElementsSignIn.lblFistGuestUserOfferName)).get(1));
        scrollDown();
        String sideDrawerOfferName = driver.findElements(By.xpath(ElementsSignIn.lblSideDrawerOfferName)).get(0).getText();

        if(offerName.equals(sideDrawerOfferName)){
            int size =driver.findElements(By.xpath(ElementsSignIn.lblParagraphTextInSideDrawer)).size();
           for(int i=0; i< size;i++){
               if(driver.findElements(By.xpath(ElementsSignIn.lblParagraphTextInSideDrawer)).get(i).getText().equals("Registered users only")){
                   clickOnElement(btnSideDrawerClose);
                   return true;
               }
           }
        }else{
            return false;
        }
        return false;
    }

    public void navigateToLandingPage(String url,int index){
        switchToWindow(index);
        navigateToURL(url);
    }

    public String verifySignUpToViewMoreButtonFunctionality() {
        clickOnElement(btnSignUpToViewMore);
        String signInLabel = driver.findElements(By.xpath("//h1[contains(text(),' Sign In')]")).get(0).getText();
        return signInLabel;
    }
    public void closeSignInPanel(){
        clickOnElement(btnCloseSignInPanel);
    }
}
