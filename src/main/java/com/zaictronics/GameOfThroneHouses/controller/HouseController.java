package com.zaictronics.GameOfThroneHouses.controller;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HouseController {

    @Autowired
    HousesService houseService;

    @GetMapping("/houses/{searchkey}")
    public List<HouseModel> getHouses(@PathVariable String searchkey){

        List<HouseModel> houses = houseService.getHouses(searchkey);

        return houses;
    }
}
