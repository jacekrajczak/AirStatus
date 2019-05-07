package com.airstatus.app.data.model.dao;

import com.airstatus.app.data.model.pojo.Sensor;
import com.airstatus.app.data.model.pojo.Station;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SensorDAO {

    private static final String SENSORS_URL = "http://api.gios.gov.pl/pjp-api/rest/station/sensors/";

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Sensor> getAllSensorsForStation(Station station){
        List<Sensor> sensors = new ArrayList<>();
        try {
           sensors = retrieveSensorsForStation(station);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sensors;
    }

    private static List<Sensor> retrieveSensorsForStation(Station station) throws IOException {
        return mapper.readValue(new URL(SENSORS_URL+station.getId()), new TypeReference<List<Sensor>>(){});
    }

    public static Sensor getSensorWithParam(String param, List<Sensor> sensorsInStation){
        for(Sensor sens : sensorsInStation){
          if(sens.getParam().getParamFormula().equals(param)){
              return sens;
          }
        }
        return null;
    }

}
