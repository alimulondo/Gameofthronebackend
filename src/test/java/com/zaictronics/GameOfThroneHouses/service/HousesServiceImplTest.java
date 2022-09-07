package com.zaictronics.GameOfThroneHouses.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HousesServiceImplTest {
    @Autowired
    HousesService housesService;

    @Test
    void testGtHouse_WhenMethodIsCalled_returnWhiteListedHouseModel() {
        String expectedName = "House Algood";
        String actualName = housesService.getHouse(1).getName();

        String expectedId = "1";
        String actualId = housesService.getHouse(1).getId();

        Assertions.assertEquals(expectedName, actualName, "Data was not successfully moved to the model");
        Assertions.assertEquals(expectedId, actualId, "Id was should be "+expectedId);
    }
}