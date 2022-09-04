package com.zaictronics.GameOfThroneHouses.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(controllers = HouseController.class)
public class HousesControllerWebLayerTest {

    @Test
    @DisplayName("Houses can be returned")
    void testGetHouses_WhenSearchKeyIsProvided_returnsMatchingHouses(){
        //Arrange

        //Act

        //Assert

    }
}
