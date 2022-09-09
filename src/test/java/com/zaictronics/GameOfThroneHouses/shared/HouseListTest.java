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

    }
}