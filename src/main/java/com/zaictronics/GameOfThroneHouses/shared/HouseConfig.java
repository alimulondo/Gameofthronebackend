package com.zaictronics.GameOfThroneHouses.shared;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration

public class HouseConfig {

    @Bean
    public ModelMapper dataMapper (){
        return  new ModelMapper();
    }

    @Bean
    public WebClient webClientConfig(){

        return WebClient.builder()
                .baseUrl("https://anapioficeandfire.com/api")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
