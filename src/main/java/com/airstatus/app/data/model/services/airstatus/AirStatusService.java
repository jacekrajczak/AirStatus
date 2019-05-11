package com.airstatus.app.data.model.services.airstatus;

public interface AirStatusService {
    double getIndexForCurrentCity(String city, String param);
    double getCurrentAverageIndexForCity(String city, String param);
}
