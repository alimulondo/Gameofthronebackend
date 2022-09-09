package com.zaictronics.GameOfThroneHouses.repository;

import com.zaictronics.GameOfThroneHouses.dto.HouseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HouseRepository {
    ResponseEntity<HouseDTO> getHouse(String id);
    ResponseEntity<List<HouseDTO>> getHouses();

    ResponseEntity<List<HouseDTO>> getHouseByName(String name);
}
