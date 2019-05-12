package com.airstatus.app.data.model.services.airstatus;

import com.airstatus.app.data.model.dao.AirQualityDAO;
import com.airstatus.app.data.model.dao.CityDAO;
import com.airstatus.app.data.model.dao.SensorDAO;
import com.airstatus.app.data.model.pojo.Sensor;
import com.airstatus.app.data.model.pojo.Station;

import java.util.List;

public class AirStatusServiceImpl implements AirStatusService {

    @Override
    public double getIndexForCurrentCity(String city, String param) {
        double averageIndexValue = 0;
        int iterates = 0;
        double indexSum = 0;
        for(Station s : CityDAO.getStationsForCity(city)){
            List<Sensor> sensors = SensorDAO.getAllSensorsForStation(s);
            if(sensors != null){
                Sensor paramSensor = SensorDAO.getSensorWithParam(param,sensors);
                if (paramSensor != null) {
                    List<Double> airValues = AirQualityDAO.getValuesForSensor(paramSensor);
                    indexSum+= sumOfIndexQualityValues(airValues);
                    iterates+=airValues.size();
                }
            }
        }
        averageIndexValue = indexSum/iterates;
        return averageIndexValue;
    }

    @Override
    public double getCurrentAverageIndexForCity(String city, String param) {
        double averageCurrentIndexValue;
        int iterates = 0;
        double indexSum = 0;

        for(Station s : CityDAO.getStationsForCity(city)){
            List<Sensor> sensors = SensorDAO.getAllSensorsForStation(s);
            if(sensors != null){
                Sensor paramSensor = SensorDAO.getSensorWithParam(param,sensors);
                if (paramSensor != null) {
                    double airValue = AirQualityDAO.getValuesForSensor(paramSensor).get(0);
                    indexSum+= airValue;
                    iterates++;
                }
            }
        }
        averageCurrentIndexValue = indexSum/iterates;
        return averageCurrentIndexValue;
    }

    private Double sumOfIndexQualityValues(List<Double> indexValues){
        double sum = 0;
        for (Double index : indexValues)
            sum+=index;
        return sum;
    }
}
