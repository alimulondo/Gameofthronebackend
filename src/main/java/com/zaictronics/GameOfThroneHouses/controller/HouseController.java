package com.zaictronics.GameOfThroneHouses.controller;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.model.MiniHouseModel;
import com.zaictronics.GameOfThroneHouses.service.HousesService;
import com.zaictronics.GameOfThroneHouses.shared.HouseList;
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
    HouseList houseList;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/houses")
    public ResponseEntity<HouseList> getHouses() {

        ResponseEntity<List<MiniHouseModel>> serviceResp = houseService.getHouses();

        List<MiniHouseModel> houseModels = serviceResp.getBody();

        houseList.setHouses(houseModels);

        return new ResponseEntity<>(houseList, serviceResp.getStatusCode());
    }

    @GetMapping("/houses/{id}")
    public ResponseEntity<MiniHouseModel> getHouse(@PathVariable(name = "id") int id){

        HouseModel house = houseService.getHouse(id);
        if(house == null) throw new RuntimeException("No house found with id = "+id);
        MiniHouseModel miniHouseModel = modelMapper.map(house, MiniHouseModel.class);

        return new ResponseEntity<>(miniHouseModel, HttpStatus.OK);
    }

    @GetMapping("/houses/name")
    public ResponseEntity<List<MiniHouseModel>> getHouseByName(@RequestParam(name = "name") String name){

        return houseService.getHouseByName(name);
    }
    @GetMapping("/houses/region")
    public ResponseEntity<List<MiniHouseModel>> getHouseByRegion(@RequestParam(name = "region") String region){

        return houseService.getHouseByRegion(region);
    }
}
