package com.zaictronics.GameOfThroneHouses.shared;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HouseConfig {

    @Bean
    public ModelMapper dataMapper (){
        return  new ModelMapper();
    }
}
