package com.airstatus.app.data.model.services;

import com.airstatus.app.data.model.pojo.Station;

import java.io.IOException;
import java.util.List;

public interface StationService {

    List<Station> getAllStations() throws IOException;
    Station getStationByName(String stationName);
}
