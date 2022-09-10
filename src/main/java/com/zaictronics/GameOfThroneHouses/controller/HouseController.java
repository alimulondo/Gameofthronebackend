package com.zaictronics.GameOfThroneHouses.controller;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.model.MiniHouseModel;
import com.zaictronics.GameOfThroneHouses.service.HousesService;
import com.zaictronics.GameOfThroneHouses.shared.HouseList;
import com.zaictronics.GameOfThroneHouses.shared.UtilWords;
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

    @Autowired
    UtilWords utilWords;

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

    @GetMapping("/houses/words")
    public ResponseEntity<List<MiniHouseModel>> getHouseByWords(@RequestParam(name = "words") String words){

        return houseService.getHouseByWords(words);
    }

    @GetMapping("/houses/haswords")
    public ResponseEntity<List<MiniHouseModel>> getHouseByHasWords(@RequestParam(name = "status") String status){
        String reqParam = status.toLowerCase();
        if(!utilWords.getBooleanPossibleValues().containsKey(reqParam)) {
            throw new IllegalArgumentException("only true or false is allowed");
        }

        return houseService.getHouseByHasWords(reqParam);
    }

}
