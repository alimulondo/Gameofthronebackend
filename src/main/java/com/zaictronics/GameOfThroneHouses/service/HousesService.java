package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.model.MiniHouseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HousesService {

    ResponseEntity<List<MiniHouseModel>> getHouses();

    HouseModel getHouse(int id);

    ResponseEntity<List<MiniHouseModel>> getHouseByName(String name);

}
