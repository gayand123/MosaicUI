package com.mosaic.pages.adminModule;

import com.mosaic.util.adminModule.ElementsMenu;
import com.mosaic.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage extends TestBase {

    //Define Elements
    @FindBy(xpath = ElementsMenu.btnSignIn)
    private WebElement btnSignIn;

    @FindBy(xpath = ElementsMenu.txtUserEmail)
    private WebElement txtUserEmail;

    @FindBy(xpath = ElementsMenu.txtPassword)
    private WebElement txtPassword;

    @FindBy(xpath = ElementsMenu.btnLogin)
    private WebElement btnLogin;
    @FindBy(xpath = ElementsMenu.txtLoginMessage)
    private WebElement txtLoginMessage;
    public void enterAdminUserName(){
        clearAndType(txtUserEmail,  properties.getProperty("merchantAdminUserName"));
    }
    public void enterAdminPassword(){
        clearAndType(txtPassword, properties.getProperty("merchantAdminpassword"));
    }
    public void clickSignIn(){
        waitUntilVisibilityOfElement(By.xpath(ElementsMenu.btnLogin));
        clickOnElement(btnSignIn);
    }

    public void clickLogin(){
        clickOnElement(btnLogin);
    }
    public String getLoginMessage(){
        waitUntilVisibilityOfElement(By.xpath(ElementsMenu.txtLoginMessage));
      return   getElementText(txtLoginMessage);
    }





}
