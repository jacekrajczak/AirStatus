package com.airstatus.app.data.model.services.airstatus;

import com.airstatus.app.data.model.dao.AirQualityDAO;
import com.airstatus.app.data.model.dao.CityDAO;
import com.airstatus.app.data.model.dao.SensorDAO;
import com.airstatus.app.data.model.pojo.Sensor;
import com.airstatus.app.data.model.pojo.Station;

import java.util.List;

public class AirStatusServiceImpl implements AirStatusService {
    @Override
    public double getPM10IndexForCurrentCity(String city) {
        double averagePM10 = 0;
        int iterates = 0;
        double indexSum = 0;
        for(Station s : CityDAO.getStationsForCity(city)){
            List<Sensor> sensors = SensorDAO.getAllSensorsForStation(s);
            if(sensors != null){
                Sensor paramSensor = SensorDAO.getSensorWithParam("PM10",sensors);
                if (paramSensor != null) {
                    List<Double> airValues = AirQualityDAO.getValuesForSensor(paramSensor);
                    indexSum+= sumOfPM10Indexes(airValues);
                    iterates+=airValues.size();
                }
            }
        }
        averagePM10 = indexSum/iterates;
        System.out.printf("PM10 index for " + city + ": " + "%.2f" ,averagePM10);
        return averagePM10;
    }

    private Double sumOfPM10Indexes(List<Double> PM10Indexes){
        double sum = 0;
        for (Double index : PM10Indexes)
            sum+=index;
        return sum;
    }
}
