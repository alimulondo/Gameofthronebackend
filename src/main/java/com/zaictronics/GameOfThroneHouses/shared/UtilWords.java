package com.zaictronics.GameOfThroneHouses.shared;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UtilWords {

    @Bean
    public Map<String, String> getParamKey(){

        return Map.of(
                "name","name",
                "region", "region",
                "words","words"
        );


    }

    @Bean
    public Map<String, String> getBooleanParamKey(){

        return Map.of(
                "hasWords","hasWords",
                "hasTitles", "hasTitles",
                "hasSeats","hasSeats",
                "hasDiedOut","hasDiedOut",
                "hasAncestralWeapons","hasAncestralWeapons"
        );

    }

    @Bean
    public Map<String, String> getBooleanPossibleValues() {

        return Map.of(
                "true", "true",
                "false", "false"
        );
    }
}
