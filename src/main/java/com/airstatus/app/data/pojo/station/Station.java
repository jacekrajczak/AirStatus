package com.airstatus.app.data.pojo.station;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {

    private int id;
    private String stationName;
    private String addressStreet;

    private City city;

    public Station(){}

    public Station(int id, String stationName, String addressStreet) {
        this.id = id;
        this.stationName = stationName;
        this.addressStreet = addressStreet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", stationName='" + stationName + '\'' +
                ", addressStreet='" + addressStreet + '\'' +
                ", city=" + city +
                '}';
    }
}
