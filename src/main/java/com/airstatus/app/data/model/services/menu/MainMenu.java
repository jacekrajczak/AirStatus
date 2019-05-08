package com.airstatus.app.data.model.services.menu;

import com.airstatus.app.data.model.services.airstatus.AirStatusServiceImpl;

import java.util.Scanner;

public class MainMenu {

    private Scanner scanner = new Scanner(System.in);
    private AirStatusServiceImpl airStatusService = new AirStatusServiceImpl();

    private void showMenu(String indexParameter){
        System.out.println(">>>> AirStatus - check your air quality index <<<<");
        System.out.println("Choose your city:" +
                            "\n1) Gdansk." +
                            "\n2) Wroclaw." +
                            "\n3) Bydgoszcz." +
                            "\n4) Poznan." +
                            "\n5) Krakow."+
                            "\n6) Exit.");
        try{
        menuImplementation(Integer.parseInt(scanner.next().trim()),indexParameter);
        }catch(NumberFormatException e){
            System.out.println("You must enter a number.");
            showMenu(indexParameter);
        }
    }

    public void showIndexMenu(){
        System.out.println("Choose Air Quality Index you want to check:");
        System.out.println(
                "1) PM10. (Pyl zawieszony PM10)" +
                "\n2) C6H6. (Benzen)" +
                "\n3) CO. (Tlenek wegla)" +
                "\n4) Exit.");
        try{
            showIndexMenuImpl(Integer.parseInt(scanner.next().trim()));
        }catch(NumberFormatException e){
            System.out.println("You must enter a number.");
            showIndexMenu();
        }
    }

    private void menuImplementation(int choice, String indexParameter){
        switch(choice){
            case 1:
                airStatusService.getIndexForCurrentCity(Cities.Gdańsk.name(),indexParameter);
                break;
            case 2:
                airStatusService.getIndexForCurrentCity(Cities.Wrocław.name(), indexParameter);
                break;
            case 3:
                airStatusService.getIndexForCurrentCity(Cities.Bydgoszcz.name(), indexParameter);
                break;
            case 4:
                airStatusService.getIndexForCurrentCity(Cities.Poznań.name(), indexParameter);
                break;
            case 5:
                airStatusService.getIndexForCurrentCity(Cities.Kraków.name(), indexParameter);
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Wrong option...");
                showIndexMenu();
        }
    }

    private void showIndexMenuImpl(int choice){
        switch(choice){
            case 1:
                showMenu(SensorParams.PM10.name());
                break;
            case 2:
                showMenu(SensorParams.C6H6.name());
                break;
            case 3:
                showMenu(SensorParams.CO.name());
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Wrong option...");
                showIndexMenu();
        }
    }


}
