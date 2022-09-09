package com.zaictronics.GameOfThroneHouses.controller;

import com.zaictronics.GameOfThroneHouses.model.MiniHouseModel;
import com.zaictronics.GameOfThroneHouses.shared.HouseList;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HousesControllerWebLayerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Houses can be returned")
    void testGetHouses_WhenAListOfHousesIsRequested_returnsOkStatus(){
        //Arrange
        String ulr = "/api/v1/houses";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();

        //Act
        ResponseEntity<HouseList> response = testRestTemplate.exchange(requestEntity,HouseList.class);

        //Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }


    @Test
    @DisplayName("House can be return given a house id")
    void testGetHouse_WhenHouseIdIsProvided_returnHouse(){
        // Arrange
        String ulr = "/api/v1/houses/1";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();

        //Act
        ResponseEntity<MiniHouseModel> response = testRestTemplate.exchange(requestEntity, MiniHouseModel.class);

        //Assert
        Assertions.assertEquals(HttpStatus.OK,response.getStatusCode(),
                "Should return House with the provided Id");
    }

    @Test
    @DisplayName("Given a wrong id")
    void testGetHouse_WhenHouseIdProvidedIsWrong_return409(){
        // Arrange
        String ulr = "/api/v1/houses/900";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();

        HttpStatus expectedStatus = HttpStatus.CONFLICT;

        //Act

            ResponseEntity<Object> result = testRestTemplate.exchange(requestEntity, ParameterizedTypeReference.forType(String.class));

        //Assert
        Assertions.assertEquals(expectedStatus,result.getStatusCode(),
                "Should return 409");
    }

    @Test
    @DisplayName("Houses can be returned by name")
    void testGetHouseByName_GivenHouseName_returnOk(){
        //Arrange
        String ulr = "/api/v1/houses/name?name=House Allyrion of Godsgrace";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();

        //Act
        ResponseEntity<Object> response = testRestTemplate.exchange(requestEntity, ParameterizedTypeReference.forType(String.class));

        //Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }



}
