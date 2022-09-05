package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.shared.HouseList;

import java.util.List;

public interface HousesService {

    HouseList getHouses(String searchKey);
}
