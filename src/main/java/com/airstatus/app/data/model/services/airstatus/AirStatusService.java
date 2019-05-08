package com.airstatus.app.data.model.services.airstatus;

public interface AirStatusService {
    double getPM10IndexForCurrentCity(String city);
    double getIndexForCurrentCity(String city, String param);
}
