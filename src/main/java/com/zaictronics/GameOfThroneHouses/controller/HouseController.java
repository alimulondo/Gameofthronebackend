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

        ResponseEntity<List<HouseModel>> serviceResp = houseService.getHouses();

        List<HouseModel> houseModels = serviceResp.getBody();

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
    public ResponseEntity<MiniHouseModel> getHouseByName(@RequestParam(name = "name") String name){


        ResponseEntity<List<MiniHouseModel>> houseModels = houseService.getHouseByName(name);

       return  null;
    }
}
