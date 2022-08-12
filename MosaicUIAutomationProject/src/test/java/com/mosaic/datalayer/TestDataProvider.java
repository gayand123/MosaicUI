package com.mosaic.datalayer;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "optionalFieldInOfferCreation")
    public static Object[][] OfferCreationData() {
        return new Object[][]{
                {"",""}
        };
    }
}
