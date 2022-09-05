package com.zaictronics.GameOfThroneHouses.controller;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

@WebMvcTest(controllers = HouseController.class)
@AutoConfigureWebMvc()
public class HousesControllerWebLayerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Houses can be returned")
    void testGetHouses_WhenSearchKeyIsProvided_returnsMatchingHouses(){
        //Arrange
        String ulr = "http://localhost:8080/api/v1/houses?searchKey=test";
        RequestEntity<Void> requestEntity = RequestEntity.get(ulr).build();
        HouseModel houseModel = new HouseModel();

        //Act
        ResponseEntity<HouseModel> response = testRestTemplate.exchange(requestEntity, HouseModel.class);

        //Assert
        Assertions.assertEquals(houseModel, response.getBody());

    }
}
