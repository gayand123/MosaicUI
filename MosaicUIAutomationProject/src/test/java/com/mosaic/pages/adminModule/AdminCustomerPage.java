package com.mosaic.pages.adminModule;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.mosaic.util.DomainConstants;
import com.mosaic.util.TestBase;
import com.mosaic.util.adminModule.ElementsCustomerLoyaltySummary;
import com.mosaic.util.adminModule.ElementsCustomers;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(xpath = ElementsCustomerLoyaltySummary.txtCurrentPoints)
    private WebElement txtCurrentPoints;

    public String getCustomerCurrentPoints() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("testa "+getAttributeValue(txtCurrentPoints));
        return getAttributeValue(txtCurrentPoints);
    }



    public String getCustomerText() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        System.out.println("customerCount " + customerCount);
        System.out.println("resultPerPage" + resultPerPage);
        double pageCount = customerCount / resultPerPage;
        System.out.println("pageCount" + pageCount);
        int correctPageCount = (int) Math.ceil(pageCount);
        System.out.println("correctPageCount " + correctPageCount);
        int tempCustomerCount = 0;
        int rowCount = 0;
        //   int rowCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
        for (int temp = 0; temp < correctPageCount; temp++) {
            List<WebElement> listRecords = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts));
            //  tempCustomerCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
            tempCustomerCount = listRecords.size();
            System.out.println(tempCustomerCount + "tempCustomerCount");
            rowCount = rowCount + tempCustomerCount;
            if (isElementEnabled(btnNextPageArrow) == true) {
                clickOnElement(btnNextPageArrow);
            }
            scrollDown();
            System.out.println("rowCount  " + rowCount);
        }
        System.out.println("total row Count  " + rowCount);
        System.out.println("rowCount " + rowCount);
        return rowCount;
    }

    public int getCustomerCount() {
        String customerCount = replacement(getCustomerText(), "Customers ");
        System.out.println(customerCount + "customerCount");
        String result = StringUtils.substringBetween(customerCount, "(", ")");
        System.out.println("result " + result);
        int intcustomerCount = 0;
        intcustomerCount = Integer.parseInt(result);

        System.out.println("customerCount " + intcustomerCount);
        return intcustomerCount;
    }

    public void clickResultPerpage() {
        moveAndClick(drpDownResultPerPage);
    }

    public void clickResultPerPageValue(int resultPerPage) {
        if (resultPerPage == 30) {
            moveAndClick(drpDownResultPerPage30);
        }
        if (resultPerPage == 100) {
            moveAndClick(drpDownResultPerPage100);
        }
    }

    public int getRowCount30InCustomers(double resultPerPage) throws InterruptedException {
        double customerCount = getCustomerCount();
        System.out.println("customerCount " + customerCount);
        System.out.println("resultPerPage" + resultPerPage);
        double pageCount = customerCount / resultPerPage;
        System.out.println("pageCount" + pageCount);
        int correctPageCount = (int) Math.ceil(pageCount);
        System.out.println("correctPageCount " + correctPageCount);
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


    public boolean isSpecificEmailAvailableInCustomersList(double resultPerPage, String customerEmail) throws InterruptedException {

        double customerCount = getCustomerCount();
        System.out.println("customerCount " + customerCount);
        System.out.println("resultPerPage" + resultPerPage);
        double pageCount = customerCount / resultPerPage;
        System.out.println("pageCount" + pageCount);
        int correctPageCount = (int) Math.ceil(pageCount);
        System.out.println("correctPageCount " + correctPageCount);
        int tempCustomerCount = 0;
        int rowCount = 0;
        boolean isEmailavailable = false;
        //   int rowCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
        for (int temp = 0; temp <= correctPageCount; temp++) {
            tempCustomerCount = driver.findElements(By.xpath(ElementsCustomers.lblCustomersEmail)).size();
            System.out.println("tempCustomerCount " + tempCustomerCount);

            for (int x = 0; x < tempCustomerCount; x++) {
                String email = driver.findElements(By.xpath(ElementsCustomers.lblCustomersEmail)).get(x).getText();
                System.out.println("email " + email);
                if (email.contains(customerEmail)) {
                    isEmailavailable = true;
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


    public void clickSpecificEmailActionInCustomersList(double resultPerPage, String customerEmail) throws InterruptedException {

        double customerCount = getCustomerCount();
        System.out.println("customerCount " + customerCount);
        System.out.println("resultPerPage" + resultPerPage);
        double pageCount = customerCount / resultPerPage;
        System.out.println("pageCount" + pageCount);
        int correctPageCount = (int) Math.ceil(pageCount);
        System.out.println("correctPageCount " + correctPageCount);
        int tempCustomerCount = 0;
        int rowCount = 0;
        boolean isEmailavailable = false;
        String userEmail=null;
        //   int rowCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
        for (int temp = 0; temp <= correctPageCount; temp++) {
            tempCustomerCount = driver.findElements(By.xpath(ElementsCustomers.lblCustomersEmail)).size();
            System.out.println("tempCustomerCount " + tempCustomerCount);

            for (int x = 0; x < tempCustomerCount; x++) {
                String email = driver.findElements(By.xpath(ElementsCustomers.lblCustomersEmail)).get(x).getText();
                System.out.println("email " + email);

                if (email.contains(customerEmail)) {
                    isEmailavailable = true;
                    driver.findElement(By.xpath(ElementsCustomers.prebtnActionCustomer + customerEmail + ElementsCustomers.postbtnActionCustomer)).click();
                    System.out.println("I am in there");
                    userEmail =email;
                    System.out.println("email ="+userEmail);
                   Thread.sleep(1000);
                    System.out.println("I am breake");
                break;

                }

            }
            rowCount = rowCount + tempCustomerCount;
            if (!userEmail.contains(customerEmail)&&isElementEnabled(btnNextPageArrow) == true) {
                System.out.println("I am in here");
                clickOnElement(btnNextPageArrow);
            } if (userEmail.contains(customerEmail)){
         break;
            }
            scrollDown();
            System.out.println("rowCount  " + rowCount);
        }
        System.out.println("total row Count  " + rowCount);

        //   return isEmailavailable;
    }

    public void clickViewEditPoints() {
        System.out.println("I am in click view");
        clickOnElement(btnViewEditPoints);
    }

    public void viewCustomerCurrentPoints() {
         clickOnElement(btnViewEditPoints);
    }



    public String getViewEditPointsText() {
        System.out.println("test" + getElementText(lblViewEditPointsText));
        return getElementText(lblViewEditPointsText);
    }

    public int getRowCount301InCustomers(double resultPerPage) throws InterruptedException {
        double customerCount = getCustomerCount();
        System.out.println("customerCount " + customerCount);
        System.out.println("resultPerPage" + resultPerPage);
        double pageCount = customerCount / resultPerPage;
        System.out.println("pageCount" + pageCount);
        int correctPageCount = (int) Math.ceil(pageCount);
        System.out.println("correctPageCount " + correctPageCount);
        int tempCustomerCount = 0;
        int rowCount = 0;
        int pageCountIn30 =0;
        int lastpageCount=0;
        //   int rowCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
   //     String  values = driver.findElement(By.id("data-id")).getAttribute("value");
        for (int temp = 0; temp < correctPageCount; temp++) {
             rowCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
         //String value= driver.findElement(By.xpath("//div[@class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi']/div["+(rowCount-1)+"]")).getAttribute("data-rowindex");
        //    System.out.println("value   "+value);
            tempCustomerCount = driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
            rowCount = rowCount + tempCustomerCount;
            if (isElementEnabled(btnNextPageArrow) == true) {
                pageCountIn30 = pageCountIn30 +1;
                System.out.println("pageCount"+pageCountIn30);
                clickOnElement(btnNextPageArrow);
            }
            if (isElementEnabled(btnNextPageArrow) == false) {
                 lastpageCount =driver.findElements(By.xpath(ElementsCustomers.tblRowCounts)).size();
                System.out.println("lastpageCount"+lastpageCount);
            }

            scrollDown();
            System.out.println("rowCount  " + rowCount);
        }
        System.out.println("total row Count  " + rowCount);
        int totalCount =(pageCountIn30*30)+lastpageCount;
        return totalCount;

    }
}

