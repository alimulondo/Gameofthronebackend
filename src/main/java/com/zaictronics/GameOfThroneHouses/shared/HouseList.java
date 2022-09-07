package com.zaictronics.GameOfThroneHouses.shared;

import com.zaictronics.GameOfThroneHouses.model.HouseModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* Wrapper Class to return a list of houses
* */
@Component
public class HouseList {

    public Map<String, String> getHouses() {
        Map<String, String> dataSegmentOne = Map.of(
                "url", "https://www.anapioficeandfire.com/api/houses/1",
                "name", "House Algood",
                "region", "The Westerlands",
                "coatOfArms", "A golden wreath, on a blue field with a gold border" +
                        "(Azure, a garland of laurel within a bordure or)",
                "words", "",
                "titles", "[\" \"]",
                "seats", "[\" \"]",
                "currentLord", "",
                "heir", "",
                "overlord", "https://www.anapioficeandfire.com/api/houses/229"
        );
        Map<String, String> dataSegmentTwo = Map.of(
                "diedOut", "Just test data",
                "ancestralWeapons", "[\" \"]",
                "cadetBranches", "[\" \"]",
                "swornMembers", "[\" \"]"


        );

        Map<String, String> transferData = new HashMap<>();
        transferData.putAll(dataSegmentOne);
        transferData.putAll(dataSegmentTwo);

        return transferData;

    }

    public void setHouses(List<HouseModel> houseModel) {
    }


}
