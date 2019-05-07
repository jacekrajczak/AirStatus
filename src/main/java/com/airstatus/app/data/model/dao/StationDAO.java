package com.airstatus.app.data.model.dao;

import com.airstatus.app.data.model.pojo.Station;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StationDAO {

    private static final String FIND_ALL_URL = "http://api.gios.gov.pl/pjp-api/rest/station/findAll";
    private static ObjectMapper mapper = new ObjectMapper();
    private static List<Station> stations = new ArrayList<>();

    static{
        try {
            stations = mapper.readValue(new URL(FIND_ALL_URL),new TypeReference<List<Station>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Station> getStations() {
        return stations;
    }

}
