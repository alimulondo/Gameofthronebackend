package com.zaictronics.GameOfThroneHouses.controller;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.model.MiniHouseModel;
import com.zaictronics.GameOfThroneHouses.service.HousesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path ="/api/v1")
public class HouseController {

    @Autowired
    HousesService houseService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/houses")
    public ResponseEntity<List<HouseModel>> getHouses(@RequestParam(name = "searchKey") String searchKey){

        if(searchKey == null || searchKey.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return houseService.getHouses();
    }

    @GetMapping("/houses/{id}")
    public ResponseEntity<MiniHouseModel> getHouse(@PathVariable(name = "id") int id){

        HouseModel house = houseService.getHouse(id);
        if(house == null) throw new RuntimeException("No house found with id = "+id);
        MiniHouseModel miniHouseModel = modelMapper.map(house, MiniHouseModel.class);

        return new ResponseEntity<>(miniHouseModel, HttpStatus.OK);
    }
}
