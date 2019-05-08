package com.airstatus.app.data.model.services.menu;

import com.airstatus.app.data.model.services.airstatus.AirStatusServiceImpl;

import java.util.Scanner;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private AirStatusServiceImpl airStatusService = new AirStatusServiceImpl();

    public void showMenu(){
        System.out.println(">>>> AirStatus - check your air quality index <<<<");
        System.out.println("Choose your city:" +
                            "\n1) Gdańsk." +
                            "\n2) Wrocław." +
                            "\n3) Bydgoszcz." +
                            "\n4) Poznań." +
                            "\n5) Inowrocław."+
                            "\n6) Exit.");
        try{
        menuImplementation(Integer.parseInt(scanner.next().trim()));
        }catch(NumberFormatException e){
            System.out.println("You must enter a number.");
            showMenu();
        }
    }

    private void menuImplementation(int choice){
        switch(choice){
            case 1:
                airStatusService.getPM10IndexForCurrentCity(Cities.Gdańsk.name());
                break;
            case 2:
                airStatusService.getPM10IndexForCurrentCity(Cities.Wrocław.name());
                break;
            case 3:
                airStatusService.getPM10IndexForCurrentCity(Cities.Bydgoszcz.name());
                break;
            case 4:
                airStatusService.getPM10IndexForCurrentCity(Cities.Poznań.name());
                break;
            case 5:
                airStatusService.getPM10IndexForCurrentCity(Cities.Inowrocław.name());
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Wrong option...");
        }
    }


}
