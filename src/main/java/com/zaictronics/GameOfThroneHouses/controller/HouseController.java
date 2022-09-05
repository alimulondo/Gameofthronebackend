package com.zaictronics.GameOfThroneHouses.controller;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.service.HousesService;
import com.zaictronics.GameOfThroneHouses.shared.HouseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path ="/api/v1")
public class HouseController {

    @Autowired
    HousesService houseService;

    @GetMapping("/houses")
    public ResponseEntity<HouseList> getHouses(@RequestParam(name = "searchKey") String searchKey){

        if(searchKey == null || searchKey.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(houseService.getHouses(searchKey), HttpStatus.OK);
    }

    @GetMapping("/houses/{id}")
    public ResponseEntity<HouseModel> getHouse(@PathVariable(name = "id") int id){

        HouseModel house = houseService.getHouse(id);

        return new ResponseEntity<>(house, HttpStatus.OK);
    }
}
