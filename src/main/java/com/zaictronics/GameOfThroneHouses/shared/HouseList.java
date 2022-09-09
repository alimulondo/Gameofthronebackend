package com.zaictronics.GameOfThroneHouses.shared;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.model.MiniHouseModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.*;

/*
* Wrapper Class to return a list of houses
* */
@Component
public class HouseList {

    List<MiniHouseModel> houses;

    public void setHouses(List<MiniHouseModel> miniHouseModels) {
        this.houses = miniHouseModels;
    }

    public List<MiniHouseModel> getHouses() {
        return houses;
    }
}
