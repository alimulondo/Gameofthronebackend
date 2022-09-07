package com.zaictronics.GameOfThroneHouses.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HouseRepositoryImplTest {

    @Autowired
    HouseRepository houseRepository;

    @Test
    void testGetHouse_WhenThisMethodIsCalled_returnHouseDTO() {
        String expectedUrl = "https://www.anapioficeandfire.com/api/houses/1";
        String actualUrl = houseRepository.getHouse().getUlr();

        Assertions.assertEquals(expectedUrl, actualUrl, "Data did not move to the Dto correctly");
    }
}