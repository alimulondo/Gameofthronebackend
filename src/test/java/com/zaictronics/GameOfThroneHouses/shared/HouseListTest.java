package com.zaictronics.GameOfThroneHouses.shared;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HouseListTest {

    @Autowired
    HouseList dummyData;

    @Test
    void testGetHouses_WhenMethodCallIsMade_returnDummyData() {
        String expectedUrl = "https://www.anapioficeandfire.com/api/houses/1";
        String expectedDiedOut = "Just test data";


        String actualUrl = dummyData.getHouses().get("url");
        String actualDiedOut = dummyData.getHouses().get("diedOut");

        Assertions.assertEquals(expectedUrl, actualUrl, "Url should be "+expectedUrl);
        Assertions.assertEquals(expectedDiedOut, actualDiedOut, "Url should be "+actualDiedOut);

    }
}