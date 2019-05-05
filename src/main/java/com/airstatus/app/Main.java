package com.airstatus.app;

import com.airstatus.app.data.pojo.station.Station;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        final String FIND_ALL_URL = "http://api.gios.gov.pl/pjp-api/rest/station/findAll";
        List<Station> allStations;
        try {
            URL jsonUrl = new URL(FIND_ALL_URL);
            allStations = objectMapper.readValue(jsonUrl,new TypeReference<List<Station>>(){});
            Station testStation = allStations.get(100);

            System.out.println(testStation.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
