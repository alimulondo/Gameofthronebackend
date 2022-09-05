package com.zaictronics.GameOfThroneHouses.shared;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;

import java.util.ArrayList;
import java.util.List;

/*
* Wrapper Class to return a list of houses
* */
public class HouseList {
    List<HouseModel> houses;

    public HouseList() {
        houses = new ArrayList<>();
    }

    public List<HouseModel> getHouses() {
        return houses;
    }

    public void setHouses(List<HouseModel> houses) {
        this.houses = houses;
    }
}
