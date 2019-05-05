package com.airstatus.app.data.model.json;

import com.airstatus.app.data.model.pojo.air.AirQualityIndex;
import com.airstatus.app.data.model.pojo.Sensor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class JsonRetriever {

    private static final String SENSORS_URL = "http://api.gios.gov.pl/pjp-api/rest/station/sensors/";
    private static final String AIR_QUALITY_INDEX = "http://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/";

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Sensor> getAllSensorsForStation(int stationId) throws IOException {
        return mapper.readValue(new URL(SENSORS_URL + stationId),new TypeReference<List<Sensor>>(){});
    }

    public static AirQualityIndex getQualityIndexesForStation(int stationId) throws IOException {
        return mapper.readValue(new URL(AIR_QUALITY_INDEX + stationId),AirQualityIndex.class);
    }
}
