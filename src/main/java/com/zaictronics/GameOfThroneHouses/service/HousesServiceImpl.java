package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.dto.HouseDTO;
import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.repository.HouseRepository;
import com.zaictronics.GameOfThroneHouses.shared.HouseList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HousesServiceImpl implements HousesService {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public HouseList getHouses(String searchKey) {



        return null;
    }

    @Override
    public HouseModel getHouse(int id) {
        HouseDTO houseDTO = houseRepository.getHouse();
        HouseModel houseModel = modelMapper.map(houseDTO, HouseModel.class);

        return houseModel;
    }
}
