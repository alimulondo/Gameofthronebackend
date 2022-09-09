package com.zaictronics.GameOfThroneHouses.shared;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

/*
* Wrapper Class to return a list of houses
* */
@Component
public class HouseList {

    List<HouseModel> houses;

    public void setHouses(List<HouseModel> houseModel) {
        this.houses = houseModel;
    }

    public List<HouseModel> getHouses() {
        return houses;
    }
}
