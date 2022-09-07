package com.zaictronics.GameOfThroneHouses.repository;

import com.zaictronics.GameOfThroneHouses.dto.HouseDTO;
import com.zaictronics.GameOfThroneHouses.shared.HouseList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseRepositoryImpl implements HouseRepository {

    @Autowired
    HouseList dummyData;

    @Override
    public HouseDTO getHouse() {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setUlr(dummyData.getHouses().get("url"));
        houseDTO.setName(dummyData.getHouses().get("name"));
        houseDTO.setRegion(dummyData.getHouses().get("region"));
        houseDTO.setCoatOfArms(dummyData.getHouses().get("coatOfArms"));
        houseDTO.setWords(dummyData.getHouses().get("words"));
        houseDTO.setTitle(List.of(dummyData.getHouses().get("titles")));
        houseDTO.setSeats(List.of(dummyData.getHouses().get("seats")));
        houseDTO.setCurrentLord(dummyData.getHouses().get("currentLord"));
        houseDTO.setHeir(dummyData.getHouses().get("heir"));
        houseDTO.setDiedOut(dummyData.getHouses().get("diedOut"));
        houseDTO.setAncestralWeapons(List.of(dummyData.getHouses().get("ancestralWeapons")));
        houseDTO.setCadetBranches(List.of(dummyData.getHouses().get("cadetBranches")));
        houseDTO.setSwornMembers(List.of(dummyData.getHouses().get("swornMembers")));


        return  houseDTO;

    }
}
