package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.model.MiniHouseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HousesService {

    ResponseEntity<List<MiniHouseModel>> getHouses();

    HouseModel getHouse(int id);

    ResponseEntity<List<MiniHouseModel>> getHouseByName(String name);

    ResponseEntity<List<MiniHouseModel>> getHouseByRegion(String region);

    ResponseEntity<List<MiniHouseModel>> getHouseByWords(String words);

    ResponseEntity<List<MiniHouseModel>> getHouseByHasWords(String status);

    ResponseEntity<List<MiniHouseModel>> getHouseByTittles(String reqParam);

    ResponseEntity<List<MiniHouseModel>> getHouseByHasSeats(String reqParam);

    ResponseEntity<List<MiniHouseModel>> getHouseByHasDiedOut(String reqParam);

    ResponseEntity<List<MiniHouseModel>> getHouseByHasAncestralWeapons(String reqParam);
}
