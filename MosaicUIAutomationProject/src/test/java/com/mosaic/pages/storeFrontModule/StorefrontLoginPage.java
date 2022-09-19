package com.mosaic.pages.storeFrontModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.adminModule.ElementsMenu;
import com.mosaic.util.storeFrontModule.ElementsSignIn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.sql.SQLOutput;

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

}
