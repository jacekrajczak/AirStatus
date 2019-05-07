package com.airstatus.app.data.model.dao;

import com.airstatus.app.data.model.pojo.Station;

import java.util.*;

public class CityDAO {

    private static Map<String, List<Station>> stationsPerCity = new HashMap<>();

    static{
            for(Station s : StationDAO.getStations()){
                if(s.getCity()!=null){
                    assignStationsToCity(s);
                }
            }
        }

    public static Map<String, List<Station>> getStationsPerCity() {
            return stationsPerCity;
        }

    public static List<Station> getStationsForCity(String cityName){
            return stationsPerCity.get(cityName);
        }

    private static void assignStationsToCity(Station s) {
        List<Station> stations = stationsPerCity.get(s.getCity().getName());
        if(stations==null){
            stations = new ArrayList<>();
            stations.add(s);
            stationsPerCity.put(s.getCity().getName(),stations);
        }else {
            if(!stations.contains(s)) stations.add(s);
        }
    }
}
