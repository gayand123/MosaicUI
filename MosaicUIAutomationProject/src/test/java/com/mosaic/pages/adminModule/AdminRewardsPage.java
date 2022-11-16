package com.mosaic.pages.adminModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.adminModule.ElementsRewards;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.python.antlr.op.In;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminRewardsPage extends TestBase {

    @FindBy(xpath = ElementsRewards.btnRewards)
    private WebElement btnRewards;

    @FindBy(xpath = ElementsRewards.btnCreateNewReward)
    private WebElement btnCreateNewReward;

    @FindBy(xpath = ElementsRewards.txtRewardName)
    private WebElement txtRewardName;

    @FindBy(xpath = ElementsRewards.txtDescription)
    private WebElement txtDescription;

    @FindBy(xpath = ElementsRewards.btnDiscountType)
    private WebElement btnDiscountType;

    @FindBy(xpath = ElementsRewards.btnInUSD)
    private WebElement btnInUSD;

    @FindBy(xpath = ElementsRewards.btnInPercentage)
    private WebElement btnInPercentage;

    @FindBy(xpath = ElementsRewards.txtThresholdOrderAmount)
    private WebElement txtThresholdOrderAmount;

    @FindBy(xpath = ElementsRewards.enterPercentageAmount)
    private WebElement enterPercentageAmount;

    @FindBy(xpath = ElementsRewards.enterRedeemPoints)
    private WebElement enterRedeemPoints;

    @FindBy(xpath = ElementsRewards.btnCreateReward)
    private WebElement btnCreateReward;

    @FindBy(xpath = ElementsRewards.lstRewardsList)
    private WebElement lstRewardsList;

        public void clickbtnRewards(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOnElement(btnRewards);
    }
    public void clickbtnCreateNewRewards(){
        clickOnElement(btnCreateNewReward);
    }

    public void enterRewardName() throws InterruptedException {
        moveAndClick(txtRewardName);
        String rewardName = randomRewardName(05);

        // Thread.sleep(1000);
        txtRewardName.sendKeys(rewardName);

    }
    public void enterRewardDescription(String description) throws InterruptedException {
        moveAndClick(txtDescription);
        // Thread.sleep(1000);
        txtDescription.sendKeys(description);
        Thread.sleep(2000);
        scrollDown();

    }

    public void selectRedeemableDiscountType(String discountType) {
        clickOnElement(btnDiscountType);
        if (discountType == "In USD") {
            clickOnElement(btnInUSD);
        }
        if (discountType == "In Percentage") {
            clickOnElement(btnInPercentage);
        }

    }
    public void enterThresholdOrderAmount(int thresholdOrderAmount) throws InterruptedException {
            String thresholdAmount = Integer.toString(thresholdOrderAmount);
        moveAndClick(txtThresholdOrderAmount);

        // Thread.sleep(1000);
        txtThresholdOrderAmount.sendKeys(thresholdAmount);
        scrollDown();

    }

    public void enterRedeemPoints(String redeemPoints) throws InterruptedException {
        enterRedeemPoints.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
        enterRedeemPoints.sendKeys(redeemPoints);

    }

    public void enterPercentageAmount(String percentageAmount) throws InterruptedException {
        enterPercentageAmount.sendKeys(Keys.SPACE, Keys.BACK_SPACE);
        enterPercentageAmount.sendKeys(percentageAmount);
    }

    public void clickCreateRewardButton(){
            clickOnElement(btnCreateReward);
    }

    public void checkRewardsCount(){
        List<Integer> rewardsList = new ArrayList<>();
        int rewards = driver.findElements(By.xpath(ElementsRewards.lstRewardsList)).size();
    System.out.println("oooooooooooooo" +  rewards);
    }

}
