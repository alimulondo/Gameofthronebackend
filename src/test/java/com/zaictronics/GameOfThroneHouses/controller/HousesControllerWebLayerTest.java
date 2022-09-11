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

    @Test
    @DisplayName("Houses can be returned by region")
    void testGetHouseByRegion_GivenHouseRegion_returnOk(){
        //Arrange
        String ulr = "/api/v1/houses/region?region=none";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();

        //Act
        ResponseEntity<Object> response = testRestTemplate.exchange(requestEntity, ParameterizedTypeReference.forType(String.class));
        System.out.println("testresp ====>"+response.getBody());

        //Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    @DisplayName("Houses can be returned by words")
    void testGetHouseByWords_GivenHouseWords_returnOk(){
        //Arrange
        String ulr = "/api/v1/houses/words?words=No Foe May Pass";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();

        //Act
        ResponseEntity<Object> response = testRestTemplate.exchange(requestEntity, ParameterizedTypeReference.forType(String.class));
        System.out.println("testresp ====>"+response.getBody());

        //Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    @DisplayName("Test wrong  hasWords as a search key")
    void testGetHouseByHasWords_ProvidedHasWordKeyIsInvalid_returnErrorMessage(){
        //Arrange
        String ulr = "/api/v1/houses/haswords?status=test";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        String expected = "only true or false is allowed";

        //Act

        ResponseEntity<Object> response = testRestTemplate.exchange(
                                            requestEntity, ParameterizedTypeReference.forType(String.class)
                                            );
        //Assert
        Assertions.assertEquals(expected, response.getBody());

    }

    @Test
    @DisplayName("Test correct  hasWords as a search key")
    void testGetHouseByHasWords_ProvidedHasWordKeyIsValid_returnOk(){
        //Arrange
        String ulr = "/api/v1/houses/haswords?status=true";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HttpStatus expected = HttpStatus.OK;

        //Act

        ResponseEntity<Object> response = testRestTemplate.exchange(
                requestEntity, ParameterizedTypeReference.forType(String.class)
        );
        //Assert
        Assertions.assertEquals(expected, response.getStatusCode());

    }

    @Test
    @DisplayName("Test correct  hasTittles as a search key")
    void testGetHouseByHasTitles_ProvidedHasWordKeyIsValid_returnOk(){
        //Arrange
        String ulr = "/api/v1/houses/hastitles?status=true";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HttpStatus expected = HttpStatus.OK;

        //Act

        ResponseEntity<Object> response = testRestTemplate.exchange(
                requestEntity, ParameterizedTypeReference.forType(String.class)
        );
        //Assert
        Assertions.assertEquals(expected, response.getStatusCode());

    }

    @Test
    @DisplayName("Test wrong  hasTittles as a search key")
    void testGetHouseByHasTitles_ProvidedHasWordKeyIsInValid_returnErrorMessage(){
        //Arrange
        String ulr = "/api/v1/houses/hastitles?status=test";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HttpStatus expectedStatus = HttpStatus.CONFLICT;
        String expectedMessage = "only true or false is allowed";


        //Act

        ResponseEntity<Object> response = testRestTemplate.exchange(
                requestEntity, ParameterizedTypeReference.forType(String.class)
        );
        //Assert
        Assertions.assertEquals(expectedStatus, response.getStatusCode());
        Assertions.assertEquals(expectedMessage, response.getBody());

    }

    @Test
    @DisplayName("Test  hasDiedOut a correct search key")
    void testGetHouseByHasSeats_ProvidedHasWordKeyIsValid_returnOk(){
        //Arrange
        String ulr = "/api/v1/houses/hasseats?status=true";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HttpStatus expectedStatus = HttpStatus.OK;

        //Act

        ResponseEntity<Object> response = testRestTemplate.exchange(
                requestEntity, ParameterizedTypeReference.forType(String.class)
        );
        //Assert
        Assertions.assertEquals(expectedStatus, response.getStatusCode());

    }

    //hasdiedout
    @Test
    @DisplayName("Test wrong  hasDiedOut as a search key")
    void testGetHouseByHasDiedOUt_ProvidedHasWordKeyIsInValid_returnErrorMessage(){
        //Arrange
        String ulr = "/api/v1/houses/hasdiedout?status=test";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HttpStatus expectedStatus = HttpStatus.CONFLICT;
        String expectedMessage = "only true or false is allowed";


        //Act

        ResponseEntity<Object> response = testRestTemplate.exchange(
                requestEntity, ParameterizedTypeReference.forType(String.class)
        );
        //Assert
        Assertions.assertEquals(expectedStatus, response.getStatusCode());
        Assertions.assertEquals(expectedMessage, response.getBody());

    }

    @Test
    @DisplayName("Test  hasSeats with a correct search key")
    void testGetHouseByHasDiedOut_ProvidedHasWordKeyIsValid_returnOk(){
        //Arrange
        String ulr = "/api/v1/houses/hasdiedout?status=true";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HttpStatus expectedStatus = HttpStatus.OK;

        //Act

        ResponseEntity<Object> response = testRestTemplate.exchange(
                requestEntity, ParameterizedTypeReference.forType(String.class)
        );
        //Assert
        Assertions.assertEquals(expectedStatus, response.getStatusCode());

    }

    //AncestralWeapons
    @Test
    @DisplayName("Test wrong  hasAncestralWeapons as a search key")
    void testGetHouseByHasAncestralWeapons_ProvidedHasWordKeyIsInValid_returnErrorMessage(){
        //Arrange
        String ulr = "/api/v1/houses/hasancestralweapons?status=test";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HttpStatus expectedStatus = HttpStatus.CONFLICT;
        String expectedMessage = "only true or false is allowed";


        //Act

        ResponseEntity<Object> response = testRestTemplate.exchange(
                requestEntity, ParameterizedTypeReference.forType(String.class)
        );
        //Assert
        Assertions.assertEquals(expectedStatus, response.getStatusCode());
        Assertions.assertEquals(expectedMessage, response.getBody());

    }

    @Test
    @DisplayName("Test  hasAncestralWeapons with a correct search key")
    void testGetHouseByHasAncestralWeapons_ProvidedHasWordKeyIsValid_returnOk(){
        //Arrange
        String ulr = "/api/v1/houses/hasancestralweapons?status=true";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HttpStatus expectedStatus = HttpStatus.OK;

        //Act

        ResponseEntity<Object> response = testRestTemplate.exchange(
                requestEntity, ParameterizedTypeReference.forType(String.class)
        );
        //Assert
        Assertions.assertEquals(expectedStatus, response.getStatusCode());

    }



}
