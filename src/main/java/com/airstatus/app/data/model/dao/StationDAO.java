package com.airstatus.app.data.model.dao;

import com.airstatus.app.data.model.pojo.Station;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class StationDAO {

    private static final String FIND_ALL_URL = "http://api.gios.gov.pl/pjp-api/rest/station/findAll";
    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Station> getAllStationsAsJson() throws IOException {
        return mapper.readValue(new URL(FIND_ALL_URL),new TypeReference<List<Station>>(){});
    }

    public Station getStationById(int stationId) throws IOException {
        Station foundStation = null;

        for (Station s: getAllStationsAsJson()) {
            if(s.getId() == stationId)
                foundStation = s;
        }
        return foundStation;
    }

}
