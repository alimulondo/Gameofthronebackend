package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.dto.HouseDTO;
import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.model.MiniHouseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HousesServiceImplTest {
    @Autowired
    HousesService housesService;

    @Test
    void testGtHouse_WhenMethodIsCalled_returnWhiteListedHouseModel() {
        int id = 1;
        String expectedName = "House Algood";
        String actualName = housesService.getHouse(id).getName();

        String expectedId = "1";
        String actualId = housesService.getHouse(id).getId();

        Assertions.assertEquals(expectedName, actualName, "Data was not successfully moved to the model");
        Assertions.assertEquals(expectedId, actualId, "Id should be "+expectedId);
    }

    @Test
    void testGetHouses_WhenMethodCallIsMade_returnOkStatus() {
        HttpStatus expectedStatus = HttpStatus.OK;
        ResponseEntity<List<HouseModel>> houseList = housesService.getHouses();

        HttpStatus actualStatus = houseList.getStatusCode();


        Assertions.assertEquals(expectedStatus, actualStatus, "There was an error in getting all houses");
    }

    @Test
    void testGetHouseByName_WhenHouseNameIsProvide_returnOkStatus() {
        HttpStatus expectedStatus = HttpStatus.OK;
        String name = "House Allyrion of Godsgrace";
        ResponseEntity<List<MiniHouseModel>> houseList = housesService.getHouseByName(name);

        HttpStatus actualStatus = houseList.getStatusCode();


        Assertions.assertEquals(expectedStatus, actualStatus, "Should return house with name = "+name);
    }
}