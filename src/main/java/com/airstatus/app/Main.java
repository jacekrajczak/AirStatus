package com.airstatus.app;

import com.airstatus.app.data.model.services.airstatus.AirStatusServiceImpl;

public class Main {

    public static void main(String[] args) {

        /*for(Station s : CityDAO.getStationsForCity("Warszawa")){
            System.out.println(s);
        }*/

        AirStatusServiceImpl airStatusService = new AirStatusServiceImpl();
        airStatusService.getPM10IndexForCurrentCity("Inowrocław");
        airStatusService.getPM10IndexForCurrentCity("Warszawa");



    }

}
