package com.mosaic.datalayer;

import org.testng.annotations.DataProvider;

import static com.mosaic.util.TestBase.properties;

public class TestDataProvider {
    @DataProvider(name = "optionalFieldInOfferCreation")
    public static Object[][] OfferCreationData() {
        return new Object[][]{
                {"",""}
        };
    }

    @DataProvider(name = "ImageSizeInOfferCreation")
    public static Object[][] OfferCreationImages() {
        return new Object[][]{
                {properties.getProperty("smallImagePath"),"File size should be greater than or equal to 500 KB"},
                {properties.getProperty("maxImagePath"),"File size should be less than or equal to 5 MB"}
        };
    }
}
