package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;

import java.util.List;

public interface HousesService {

    List<HouseModel> getHouses(String searchKey);
}
