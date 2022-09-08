package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.dto.HouseDTO;
import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.repository.HouseRepository;
import com.zaictronics.GameOfThroneHouses.shared.HouseList;
import com.zaictronics.GameOfThroneHouses.shared.UrlFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HousesServiceImpl implements HousesService {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UrlFormatter urlFormatter;

    @Override
    public HouseList getHouses(String searchKey) {

        return null;
    }

    @Override
    public HouseModel getHouse(int id) {
        HouseDTO houseDTO = houseRepository.getHouse(String.valueOf(id));
        HouseModel houseModel = modelMapper.map(houseDTO, HouseModel.class);
        houseModel.setId(urlFormatter.formatUrl(houseDTO.getUrl()));

        return houseModel;
    }
}
