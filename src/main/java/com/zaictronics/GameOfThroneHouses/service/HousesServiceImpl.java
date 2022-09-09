package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.dto.HouseDTO;
import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.repository.HouseRepository;
import com.zaictronics.GameOfThroneHouses.shared.UrlFormatter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class HousesServiceImpl implements HousesService {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UrlFormatter urlFormatter;

    @Override
    public ResponseEntity<List<HouseModel>> getHouses() {
        List<HouseModel> houseModels = new LinkedList<>();
        HouseModel houseModel;

        ResponseEntity<List<HouseDTO>> housesResponse = houseRepository.getHouses();
        List<HouseDTO> houseDtoList = housesResponse.getBody();
        if(houseDtoList == null) throw new RuntimeException("No Houses available");
        for(HouseDTO dto : houseDtoList){
             houseModel = modelMapper.map(dto, HouseModel.class);
             houseModel.setId(urlFormatter.formatUrl(dto.getUrl()));
             houseModels.add(houseModel);
        }



        return new ResponseEntity<>(houseModels, HttpStatus.OK);
    }

    @Override
    public HouseModel getHouse(int id) {
        HouseDTO houseDTO = houseRepository.getHouse(String.valueOf(id)).getBody();
        HouseModel houseModel = modelMapper.map(houseDTO, HouseModel.class);
        houseModel.setId(urlFormatter.formatUrl(houseDTO.getUrl()));

        return houseModel;
    }


}
