package com.airstatus.app;

import com.airstatus.app.data.model.pojo.AirQualityIndex;
import com.airstatus.app.data.model.pojo.IndexLevel;
import com.airstatus.app.data.model.pojo.Sensor;
import com.airstatus.app.data.model.pojo.Station;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        final String FIND_ALL_URL = "http://api.gios.gov.pl/pjp-api/rest/station/findAll";
        final String SENSORS_URL = "http://api.gios.gov.pl/pjp-api/rest/station/sensors/143";
        final String AIR_STATUS_INDEX = "http://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/143";

        ObjectMapper objectMapper = new ObjectMapper();
        List<Station> allStations = null;
        List<Sensor> sensorsForChoosenStation = null;
        IndexLevel indexLevel = null;

        try {
            URL jsonUrl = new URL(FIND_ALL_URL);
            URL sensorUrl = new URL(SENSORS_URL);
            URL indexUrl = new URL(AIR_STATUS_INDEX);

            allStations = objectMapper.readValue(jsonUrl,new TypeReference<List<Station>>(){});
            sensorsForChoosenStation = objectMapper.readValue(sensorUrl, new TypeReference<List<Sensor>>(){});
            indexLevel = objectMapper.readValue(indexUrl, AirQualityIndex.class).getPm10IndexLevel();

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

        System.out.println("\nPył zawieszony status jakości: " + indexLevel.toString());

    }

}
