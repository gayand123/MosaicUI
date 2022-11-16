package com.mosaic.pages.storeFrontModule;

import com.mosaic.util.TestBase;
import com.mosaic.util.storeFrontModule.ElementsRewards;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.*;

public class StorefrontRewardsPage extends TestBase {

    @FindBy(xpath = ElementsRewards.btnAvator)
    private WebElement btnAvator;

    @FindBy(xpath = ElementsRewards.btnRewards)
    private WebElement btnRewards;

    @FindBy(xpath = ElementsRewards.txtGetPointBalance)
    private WebElement txtGetPointBalance;

    @FindBy(xpath = ElementsRewards.txtUserPoints)
    private WebElement txtUserPoints;

    @FindBy(xpath = ElementsRewards.btnPointHistoryArrow)
    private WebElement btnPointHistoryArrow;

    @FindBy(xpath = ElementsRewards.txtCompletedPoints)
    private WebElement txtCompletedPoints;

    @FindBy(xpath = ElementsRewards.txtRedeemPoints)
    private WebElement txtRedeemPoints;

    @FindBy(xpath = ElementsRewards.txtDate)
    private WebElement txtDate;

    @FindBy(xpath = ElementsRewards.btnClosePointHistory)
    private WebElement btnClosePointHistory;

    @FindBy(xpath = ElementsRewards.lblPointBalanceBar)
    private WebElement lblPointBalanceBar;

    public void clickButtonAvator() throws InterruptedException{
        clickOnElement(btnAvator);
        Thread.sleep(2000);
    }

    public void clickBtnRewards() {
        clickOnElement(btnRewards);
    }

    public String getPointBalance() {
        return getElementText(txtGetPointBalance);
    }

    public void clickPointBalanceArrow(){
        clickOnElement(btnPointHistoryArrow);
    }

    public int calculatePointBalance() {
        int pointBalance = 0;
        int sumPointBalance = 0;
        List<Integer> pointList = new ArrayList<>();
        int pointCount = driver.findElements(By.xpath(ElementsRewards.txtUserPoints)).size();

        for (int rowCount = 0; rowCount < pointCount; rowCount++) {
            String point = driver.findElements(By.xpath(ElementsRewards.txtUserPoints)).get(rowCount).getText();
            if (point.contains("Pending")) {
                continue;
            } else {
                pointBalance = Integer.parseInt(point);
                pointList.add(pointBalance);
            }
        }
        for (int element : pointList) {
            sumPointBalance = sumPointBalance + element;
        }
        return sumPointBalance;
    }

    public boolean checkingDateOrder() throws Exception {
        List<Date> dateList = new ArrayList<>();
        int date = driver.findElements(By.xpath(ElementsRewards.txtDate)).size();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        for (int rowCount = 0; rowCount < date; rowCount++) {
            String stringDate = driver.findElements(By.xpath(ElementsRewards.txtDate)).get(rowCount).getText();
            dateList.add(sdf.parse(stringDate));
        }
        return dateArraySorted(dateList);
    }

    public static boolean dateArraySorted(List<Date> dateList) {
        List<Date> sortedDateList = dateList;
        Collections.sort(sortedDateList,Collections.reverseOrder());

        if(dateList.equals(sortedDateList)){
            return true;
         }else{
            return false;
        }

    }

    public void clickClosePointHistory(){
        clickOnElement(btnClosePointHistory);
    }

    public boolean isPointBalanceBarVisibleWhenEnabledLevel(){
        try{
            if(isElementPresentAndDisplay(lblPointBalanceBar)){
        System.out.println("Point balace bar present" );
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println("Point balace bar Not Present");
            return true;
        }
    }

    public boolean isPointBalanceBarVisibleWhenDisabledLevel(){
        try{
            if(isElementPresentAndDisplay(lblPointBalanceBar)){
                System.out.println("Point balace bar present" );
                return false;
            }else{
                return true;
            }
        }catch(Exception e){
            System.out.println("Point balace bar Not Present");
            return true;
        }
    }
}
