package com.zaictronics.GameOfThroneHouses.service;

import com.zaictronics.GameOfThroneHouses.dto.HouseDTO;
import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import com.zaictronics.GameOfThroneHouses.model.MiniHouseModel;
import com.zaictronics.GameOfThroneHouses.repository.HouseRepositoryImpl;
import com.zaictronics.GameOfThroneHouses.shared.UrlFormatter;
import com.zaictronics.GameOfThroneHouses.shared.UtilWords;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class HousesServiceImpl implements HousesService {

    @Autowired
    HouseRepositoryImpl houseRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UrlFormatter urlFormatter;

    @Autowired
    UtilWords utilWords;

    @Override
    public ResponseEntity<List<MiniHouseModel>> getHouses() {
        List<MiniHouseModel> houseModels = new LinkedList<>();
        MiniHouseModel houseModel;

        ResponseEntity<List<HouseDTO>> housesResponse = houseRepository.getHouses();
        List<HouseDTO> houseDtoList = housesResponse.getBody();
        if(houseDtoList == null) throw new RuntimeException("No Houses available");
        for(HouseDTO dto : houseDtoList){
             houseModel = modelMapper.map(dto, MiniHouseModel.class);
             houseModel.setId(urlFormatter.formatUrl(dto.getUrl()));
             houseModels.add(houseModel);
        }


        return new ResponseEntity<>(houseModels, housesResponse.getStatusCode());
    }

    @Override
    public HouseModel getHouse(int id) {
        HouseDTO houseDTO = houseRepository.getHouse(String.valueOf(id)).getBody();
        if(houseDTO == null) throw new RuntimeException("House with id="+id+" is not available");
        HouseModel houseModel = modelMapper.map(houseDTO, HouseModel.class);
        houseModel.setId(urlFormatter.formatUrl(houseDTO.getUrl()));

        return houseModel;
    }

    @Override
    public ResponseEntity<List<MiniHouseModel>> getHouseByName(String name) {
        houseRepository.setKey(utilWords.getParamKey().get("name"));

        return getListResponseEntity(name);
    }

    private ResponseEntity<List<MiniHouseModel>> getListResponseEntity(String name) {
        List<MiniHouseModel> miniHouseModels = new LinkedList<>();
        MiniHouseModel miniHouseModel;
        ResponseEntity<List<HouseDTO>> houseRepoResult = houseRepository.getHouseBySearchKey(name);
        List<HouseDTO> houseDTO = houseRepoResult.getBody();
        if(houseDTO == null) throw new RuntimeException("No house available with name="+ name);
        for(HouseDTO dto : houseDTO){
            miniHouseModel = modelMapper.map(dto, MiniHouseModel.class);
            miniHouseModel.setId(urlFormatter.formatUrl(dto.getUrl()));
            miniHouseModels.add(miniHouseModel);
        }

        HouseModel houseModel = modelMapper.map(houseDTO, HouseModel.class);
//        houseModel.setId(urlFormatter.formatUrl(houseDTO.getUrl()));
        return new ResponseEntity<>(miniHouseModels, houseRepoResult.getStatusCode());
    }

    @Override
    public ResponseEntity<List<MiniHouseModel>> getHouseByRegion(String region) {
        houseRepository.setKey(utilWords.getParamKey().get("region"));
        return getListResponseEntity(region);
    }

    @Override
    public ResponseEntity<List<MiniHouseModel>> getHouseByWords(String words) {
        houseRepository.setKey(utilWords.getParamKey().get("words"));
        return getListResponseEntity(words);
    }


}
