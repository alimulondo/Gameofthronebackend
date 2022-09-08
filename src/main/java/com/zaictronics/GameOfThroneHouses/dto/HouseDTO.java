package com.zaictronics.GameOfThroneHouses.dto;

import java.util.List;

public class HouseDTO {
//    url	string	The hypermedia URL of this resource
//    name	string	The name of this house
//    region	string	The region that this house resides in.
//    coatOfArms	string	Text describing the coat of arms of this house.
//    coatOfArms	string	Text describing the coat of arms of this house.
//    words	string	The words of this house.
//    titles	array of strings	The titles that this house holds.
//    seats	array of strings	The seats that this house holds.
//    currentLord	string	The Character resource URL of this house's current lord.
//    heir	string	The Character resource URL of this house's heir.
//    overlord	string	The House resource URL that this house answers to.
//    founded	string	The year that this house was founded.
//    founder	string	The Character resource URL that founded this house.
//    diedOut	string	The year that this house died out.
//    ancestralWeapons	array of strings	An array of names of the noteworthy weapons that this house owns.
//    cadetBranches	array of strings	An array of House resource URLs that was founded from this house.
//    swornMembers	array of strings An array of Character resource URLs that are sworn to this house.


    private String url;
    private  String name;
    private  String region;
    private  String coatOfArms;
    private String words;
    private List<String> title;
    private List<String> seats;
    private String currentLord;
    private String heir;
    private String overlord;
    private String founded;
    private String diedOut;
    private List<String> ancestralWeapons;
    private List<String> cadetBranches;
    private List<String> swornMembers;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getCoatOfArms() {
        return coatOfArms;
    }

    public void setCoatOfArms(String coatOfArms) {
        this.coatOfArms = coatOfArms;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public String getCurrentLord() {
        return currentLord;
    }

    public void setCurrentLord(String currentLord) {
        this.currentLord = currentLord;
    }

    public String getHeir() {
        return heir;
    }

    public void setHeir(String heir) {
        this.heir = heir;
    }

    public String getOverlord() {
        return overlord;
    }

    public void setOverlord(String overlord) {
        this.overlord = overlord;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getDiedOut() {
        return diedOut;
    }

    public void setDiedOut(String diedOut) {
        this.diedOut = diedOut;
    }

    public List<String> getAncestralWeapons() {
        return ancestralWeapons;
    }

    public void setAncestralWeapons(List<String> ancestralWeapons) {
        this.ancestralWeapons = ancestralWeapons;
    }

    public List<String> getCadetBranches() {
        return cadetBranches;
    }

    public void setCadetBranches(List<String> cadetBranches) {
        this.cadetBranches = cadetBranches;
    }

    public List<String> getSwornMembers() {
        return swornMembers;
    }

    public void setSwornMembers(List<String> swornMembers) {
        this.swornMembers = swornMembers;
    }

    @Override
    public String toString() {
        return "HouseDTO{" +
                "ulr='" + url + '\'' +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", coatOfArms='" + coatOfArms + '\'' +
                ", words='" + words + '\'' +
                ", title=" + title +
                ", seats=" + seats +
                ", currentLord='" + currentLord + '\'' +
                ", heir='" + heir + '\'' +
                ", overlord='" + overlord + '\'' +
                ", founded='" + founded + '\'' +
                ", diedOut='" + diedOut + '\'' +
                ", ancestralWeapons=" + ancestralWeapons +
                ", cadetBranches=" + cadetBranches +
                ", swornMembers=" + swornMembers +
                '}';
    }
}
