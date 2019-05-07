package com.airstatus.app.data.model.services.implementation;

import com.airstatus.app.data.model.dao.StationDAO;
import com.airstatus.app.data.model.pojo.Station;
import com.airstatus.app.data.model.services.StationService;

import java.io.IOException;
import java.util.List;

public class StationServiceImpl implements StationService {

    private StationDAO stationDAO;

    public StationServiceImpl(){
        stationDAO = new StationDAO();
    }

    @Override
    public List<Station> getAllStations() throws IOException {
        return StationDAO.getStations();
    }

    @Override
    public Station getStationByName(String stationName) {
        return null;
    }
}
