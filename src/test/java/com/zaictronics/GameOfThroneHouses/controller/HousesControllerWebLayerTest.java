package com.zaictronics.GameOfThroneHouses.controller;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.service.HousesService;
import com.zaictronics.GameOfThroneHouses.shared.HouseList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HousesControllerWebLayerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private HousesService housesService;

    @Test
    @DisplayName("Houses can be returned")
    void testGetHouses_WhenSearchKeyIsProvided_returnsMatchingHouses(){
        //Arrange
        String ulr = "/api/v1/houses?searchKey=test";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HouseModel houseModel = new HouseModel();
        houseModel.setName("test Name");
        houseModel.setCoatOfArms("Coat of am");

        HouseList houseList = new HouseList();
        houseList.setHouses(List.of(houseModel));

       when(housesService.getHouses(any(String.class))).thenReturn(houseList);

        //Act
        ResponseEntity<HouseList> response = testRestTemplate.exchange(requestEntity, HouseList.class);

        //Assert
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    @DisplayName("Search key can not be empty")
    void tesGetHouses_WhenSeachKeyInEmpty_returnBadRequest(){
        //Arrange
        String ulr = "/api/v1/houses?searchKey=";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HouseModel houseModel = new HouseModel();
        houseModel.setName("test Name");
        houseModel.setCoatOfArms("Coat of am");

        HouseList houseList = new HouseList();
        houseList.setHouses(List.of(houseModel));

        when(housesService.getHouses(any(String.class))).thenReturn(houseList);

        // Act
        ResponseEntity<HouseList> response = testRestTemplate.exchange(requestEntity, HouseList.class);

        // Assert
        Assertions.assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode(),
                "Should return bad request when searchkey is empty");
    }
}
