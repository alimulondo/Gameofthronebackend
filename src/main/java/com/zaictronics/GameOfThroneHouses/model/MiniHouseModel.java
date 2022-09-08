package com.zaictronics.GameOfThroneHouses.model;
/*
* This model will be used to transfer small amount of content to the calling client
* */
public class MiniHouseModel {
    private String id;
    private  String name;
    private  String region;
    private String words;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "MiniHouseModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", words='" + words + '\'' +
                '}';
    }
}
