package com.airstatus.app.data.model.services.airstatus;

import com.airstatus.app.data.model.dao.AirQualityDAO;
import com.airstatus.app.data.model.dao.CityDAO;
import com.airstatus.app.data.model.dao.SensorDAO;
import com.airstatus.app.data.model.pojo.Sensor;
import com.airstatus.app.data.model.pojo.Station;

import java.util.List;

public class AirStatusServiceImpl implements AirStatusService {
    @Override
    public void getPM10IndexForCurrentCity(String city) {
        int iterates = 0;
        double indexSum = 0;
        for(Station s : CityDAO.getStationsForCity(city)){
            List<Sensor> sensors = SensorDAO.getAllSensorsForStation(s);
            if(sensors != null){
                Sensor paramSensor = SensorDAO.getSensorWithParam("PM10",sensors);
                if (paramSensor != null) {
                    List<Double> airValues = AirQualityDAO.getValuesForSensor(paramSensor);
                    indexSum+=averagePM10IndexForCity(airValues);
                    iterates+=airValues.size();
                }
            }

        }
        System.out.println(indexSum/iterates);
    }

    private Double averagePM10IndexForCity(List<Double> PM10Indexes){
        double sum = 0;
        for (Double d : PM10Indexes)
            sum+=d;
        return sum;
    }
}
