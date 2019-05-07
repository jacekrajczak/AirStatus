package com.airstatus.app.data.model.dao;

import com.airstatus.app.data.model.pojo.Sensor;
import com.airstatus.app.data.model.pojo.air.AirQualityData;
import com.airstatus.app.data.model.pojo.air.AirQualityValues;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AirQualityDAO {

    private static final String VALUES_URL = "http://api.gios.gov.pl/pjp-api/rest/data/getData/";

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Double> getValuesForSensor(Sensor sensor){
        AirQualityData airData;
        List<Double> airValues = new ArrayList<>();
        try {
            airData= retrieveAirValuesForSensor(sensor);
            airValues = parseStringValuesToDouble(airData.getValues());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return airValues;
    }

    private static AirQualityData retrieveAirValuesForSensor(Sensor sensor) throws IOException {
        return mapper.readValue(new URL(VALUES_URL + sensor.getId()), AirQualityData.class);
    }

    private static List<Double> parseStringValuesToDouble(List<AirQualityValues> stringValues){
        List<Double> doubleValues = new ArrayList<>();
        for(AirQualityValues airV : stringValues){
            if(airV.getValue()!=null)
            doubleValues.add(Double.parseDouble(airV.getValue()));
        }
        return doubleValues;
    }
}
