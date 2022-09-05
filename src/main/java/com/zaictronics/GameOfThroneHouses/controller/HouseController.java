package com.zaictronics.GameOfThroneHouses.controller;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/v1")
public class HouseController {

    @Autowired
    HousesService houseService;

    @GetMapping("/houses")
    public List<HouseModel> getHouses(@RequestParam( "searchKey") String searchkey){

        List<HouseModel> houses = houseService.getHouses(searchkey);

        return houses;
    }
}
