package com.mosaic.pages.adminModule;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.mosaic.util.TestBase;
import com.mosaic.util.adminModule.ElementsCustomers;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminCustomerPage extends TestBase {
    @FindBy(xpath = ElementsCustomers.lblCustomers)
    private WebElement lblCustomers;
    @FindBy(xpath = ElementsCustomers.btnNextPageArrow)
    private WebElement btnNextPageArrow;
    @FindBy(xpath = ElementsCustomers.drpDownResultPerPage)
    private WebElement drpDownResultPerPage;
    @FindBy(xpath = ElementsCustomers.drpDownResultPerPage30)
    private WebElement drpDownResultPerPage30;
    @FindBy(xpath = ElementsCustomers.drpDownResultPerPage100)
    private WebElement drpDownResultPerPage100;

    @FindBy(xpath = ElementsCustomers.btnViewEditPoints)
    private WebElement btnViewEditPoints;
    @FindBy(xpath = ElementsCustomers.lblViewEditPointsText)
    private WebElement lblViewEditPointsText;

    public String getCustomerText() {
        return getElementText(lblCustomers);
    }


    public void clickNextPageInCustomers() {
        if (isElementEnabled(btnNextPageArrow) == true) {
            clickOnElement(btnNextPageArrow);
        } else
            System.out.println("cannot click");
    }

    public int getRowCountInCustomers(double resultPerPage) throws InterruptedException {
        double customerCount = getCustomerCount();
        System.out.println("customerCount "+customerCount);
        System.out.println("resultPerPage"+resultPerPage);
        double pageCount =customerCount/resultPerPage;
        System.out.println("pageCount" + pageCount);
       int correctPageCount= (int) Math.ceil(pageCount);
        System.out.println("correctPageCount "+correctPageCount);
        int tempCustomerCount = 0;
        int rowCount = 0;
        //   int rowCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
        for (int temp = 0; temp <= correctPageCount; temp++) {
           tempCustomerCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
            rowCount = rowCount + tempCustomerCount;
            if (isElementEnabled(btnNextPageArrow) == true) {
                clickOnElement(btnNextPageArrow);
            }
            scrollDown();
            System.out.println("rowCount  " + rowCount);
        }
        System.out.println("total row Count  " + rowCount);
        return rowCount;
    }

    public int getCustomerCount() {
        String customerCount = replacement(getCustomerText(), "Customers ");
        String result = StringUtils.substringBetween(customerCount, "(", ")");
        System.out.println("result " + result);
        int intcustomerCount = 0;
        intcustomerCount = Integer.parseInt(result);

        System.out.println("customerCount " + intcustomerCount);
        return intcustomerCount;
    }

public void clickResultPerpage(){
    moveAndClick(drpDownResultPerPage);
}

public void clickResultPerPageValue(int resultPerPage){
        if(resultPerPage ==30) {
            moveAndClick(drpDownResultPerPage30);
        } if (resultPerPage==100){
            moveAndClick(drpDownResultPerPage100);
    }
}

    public int getRowCount30InCustomers(double resultPerPage) throws InterruptedException {
        double customerCount = getCustomerCount();
        System.out.println("customerCount "+customerCount);
        System.out.println("resultPerPage"+resultPerPage);
        double pageCount =customerCount/resultPerPage;
        System.out.println("pageCount" + pageCount);
        int correctPageCount= (int) Math.ceil(pageCount);
        System.out.println("correctPageCount "+correctPageCount);
        int tempCustomerCount = 0;
        int rowCount = 0;
        //   int rowCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
        for (int temp = 0; temp <= correctPageCount; temp++) {
            tempCustomerCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
            rowCount = rowCount + tempCustomerCount;
            if (isElementEnabled(btnNextPageArrow) == true) {
                clickOnElement(btnNextPageArrow);
            }
            scrollDown();
            System.out.println("rowCount  " + rowCount);
        }
        System.out.println("total row Count  " + rowCount);
        return rowCount;
    }


    public boolean isSpecificEmailAvailableInCustomersList(double resultPerPage,String customerEmail) throws InterruptedException {

        double customerCount = getCustomerCount();
        System.out.println("customerCount "+ customerCount);
        System.out.println("resultPerPage"+ resultPerPage);
        double pageCount = customerCount/ resultPerPage;
        System.out.println("pageCount" + pageCount);
        int correctPageCount= (int) Math.ceil(pageCount);
        System.out.println("correctPageCount "+ correctPageCount);
        int tempCustomerCount = 0;
        int rowCount = 0;
        boolean isEmailavailable = false;
        //   int rowCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
        for (int temp = 0; temp <= correctPageCount; temp++) {
            tempCustomerCount = driver.findElements(By.xpath(ElementsCustomers.lblCustomersEmail)).size();
            System.out.println("tempCustomerCount "+tempCustomerCount);

            for ( int x=0; x<tempCustomerCount; x++) {
           String email = driver.findElements(By.xpath(ElementsCustomers.lblCustomersEmail)).get(x).getText();
                System.out.println("email "+ email);
                if(email.contains(customerEmail)){
                    isEmailavailable =  true;
                    break;
                }

            }
            rowCount = rowCount + tempCustomerCount;
            if (isElementEnabled(btnNextPageArrow) == true) {
                clickOnElement(btnNextPageArrow);
            }
            scrollDown();
            System.out.println("rowCount  " + rowCount);
        }
        System.out.println("total row Count  " + rowCount);
        return isEmailavailable;
    }


    public void clickSpecificEmailActionInCustomersList(double resultPerPage,String customerEmail) throws InterruptedException {

        double customerCount = getCustomerCount();
        System.out.println("customerCount "+ customerCount);
        System.out.println("resultPerPage"+ resultPerPage);
        double pageCount = customerCount/ resultPerPage;
        System.out.println("pageCount" + pageCount);
        int correctPageCount= (int) Math.ceil(pageCount);
        System.out.println("correctPageCount "+ correctPageCount);
        int tempCustomerCount = 0;
        int rowCount = 0;
        boolean isEmailavailable = false;
        //   int rowCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
        for (int temp = 0; temp <= correctPageCount; temp++) {
            tempCustomerCount = driver.findElements(By.xpath(ElementsCustomers.lblCustomersEmail)).size();
            System.out.println("tempCustomerCount "+tempCustomerCount);

            for ( int x=0; x<tempCustomerCount; x++) {
                String email = driver.findElements(By.xpath(ElementsCustomers.lblCustomersEmail)).get(x).getText();
                System.out.println("email "+ email);
                if(email.contains(customerEmail)){
                    isEmailavailable =  true;
                    driver.findElement(By.xpath(ElementsCustomers.prebtnActionCustomer+x+1+ElementsCustomers.postbtnActionCustomer)).click();
                    break;
                }

            }
            rowCount = rowCount + tempCustomerCount;
            if (isElementEnabled(btnNextPageArrow) == true) {
                clickOnElement(btnNextPageArrow);
            }
            scrollDown();
            System.out.println("rowCount  " + rowCount);
        }
        System.out.println("total row Count  " + rowCount);
     //   return isEmailavailable;
    }
public void clickViewEditPoints(){
        clickOnElement(btnViewEditPoints);
}
public String getViewEditPointsText(){
        return getElementText(lblViewEditPointsText);
}
}
