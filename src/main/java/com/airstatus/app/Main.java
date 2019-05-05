package com.airstatus.app;

import com.airstatus.app.data.model.json.JsonRetriever;
import com.airstatus.app.data.model.pojo.air.AirQualityIndex;
import com.airstatus.app.data.model.pojo.air.AirQualityDetails;
import com.airstatus.app.data.model.pojo.Sensor;
import com.airstatus.app.data.model.pojo.Station;
import com.airstatus.app.data.model.services.implementation.StationServiceImpl;

import java.io.IOException;
import java.util.List;

public class Main {

    static final int INOWROCLAW_ID = 143;

    public static void main(String[] args) {

        StationServiceImpl stationService = new StationServiceImpl();

        List<Station> allStations = null;
        List<Sensor> sensorsForChoosenStation = null;
        AirQualityDetails indexLevelDetails = null;

        try {
            allStations = stationService.getAllStations();

            //przerobic na serwis --->

            sensorsForChoosenStation = JsonRetriever.getAllSensorsForStation(INOWROCLAW_ID);
            AirQualityIndex airIndexLevel = JsonRetriever.getQualityIndexesForStation(INOWROCLAW_ID);
            indexLevelDetails = airIndexLevel.getPm10IndexLevel();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Station inowroclaw = null;

        for(Station s : allStations){
            if(s.getId() == 143){
                inowroclaw = s;
            }
        }

        System.out.println(inowroclaw.toString());
        System.out.println(inowroclaw.getCity().toString());
        System.out.println(inowroclaw.getCity().getCommune().toString()+"\n");

        System.out.println("Rodzaje sensorów:");

        for(Sensor s : sensorsForChoosenStation){
            System.out.println(s.toString());
        }

        System.out.println("\nPył zawieszony status jakości: " + indexLevelDetails.toString());

    }

}
