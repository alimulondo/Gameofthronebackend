package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HousesService {

    ResponseEntity<List<HouseModel>> getHouses();

    HouseModel getHouse(int id);
}
