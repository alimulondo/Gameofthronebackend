package com.zaictronics.GameOfThroneHouses.repository;

import com.zaictronics.GameOfThroneHouses.dto.HouseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class HouseRepositoryImpl implements HouseRepository {

    @Autowired
    WebClient webClient;

    @Override
    public ResponseEntity<HouseDTO> getHouse(String id) {

        return webClient.get()
                .uri("/houses/"+id)
                .retrieve()
                .onStatus(
                 HttpStatus::isError, e->Mono.error(new RuntimeException(e.statusCode().toString())))
                .toEntity(HouseDTO.class)
                .block();

    }
    @Override
    public ResponseEntity<List<HouseDTO>> getHouses() {

        Mono<ResponseEntity<List<HouseDTO>>> houses = webClient.get()
                                             .uri("/houses")
                                             .retrieve()
                                             .onStatus(
                                             HttpStatus::isError, e->Mono.error(new RuntimeException(e.statusCode().toString())))
                                             .toEntityList(HouseDTO.class)
                                             .onErrorResume(Mono::error);

        return houses.block();


    }
}
