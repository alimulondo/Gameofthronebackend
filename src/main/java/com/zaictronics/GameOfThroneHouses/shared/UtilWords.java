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
}
