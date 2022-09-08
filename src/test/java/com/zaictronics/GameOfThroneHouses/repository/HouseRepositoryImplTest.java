package com.zaictronics.GameOfThroneHouses.repository;

import com.zaictronics.GameOfThroneHouses.dto.HouseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HouseRepositoryImplTest {

    @Autowired
    HouseRepository houseRepository;

    @Test
    void testGetHouse_WhenProvidedWithHouseId_returnOkStatus() {
        int id = 229;
        HttpStatus expectedStatus = HttpStatus.OK;
        HttpStatus actualStatus = houseRepository.getHouse(String.valueOf(id)).getStatusCode();

        Assertions.assertEquals(expectedStatus, actualStatus, "No house with id = "+ id);
    }

    @Test
    void testGetHouse_WhenProvidedWithWrongHouseId_throwException() {
        int id = -229;
        String expectedMessage = "404 NOT_FOUND";

        RuntimeException actualException = Assertions.assertThrows(RuntimeException.class, () -> {
            houseRepository.getHouse(String.valueOf(id)).getStatusCode();
        });

        Assertions.assertEquals(expectedMessage, actualException.getMessage(), "Should throw exception ");
    }

    @Test
    void testGetHouses_WhenMethodCallIsMade_returnAllHouses() {
        HttpStatus expectedStatus = HttpStatus.OK;
        ResponseEntity<List<HouseDTO>> houseList = houseRepository.getHouses();

        HttpStatus actualStatus = houseList.getStatusCode();


        Assertions.assertEquals(expectedStatus, actualStatus, "There was an error in getting all houses");
    }
}