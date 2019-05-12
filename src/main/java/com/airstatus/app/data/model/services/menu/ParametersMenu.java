package com.airstatus.app.data.model.services.menu;

import com.airstatus.app.data.model.services.airstatus.AirStatusServiceImpl;
import com.airstatus.app.data.model.services.menu.choices.Cities;
import com.airstatus.app.data.model.services.menu.choices.SensorParams;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ParametersMenu{

    private Scanner scanner = new Scanner(System.in);
    private AirStatusServiceImpl airStatusService = new AirStatusServiceImpl();
    private ResourceBundle resourceBundle;

     public void chooseLanguage(){
        int choice;
        try{
            System.out.println("Choose your language:\n1) PL\n2) EN \n3) DE");
            choice = Integer.parseInt(scanner.next().trim());
            switch (choice){
                case 1:
                    Locale.setDefault(new Locale("pl","PL"));
                    break;
                case 2:
                    Locale.setDefault(new Locale("en","US"));
                    break;
                case 3:
                    Locale.setDefault(new Locale("de","DE"));
                    break;
                default:
                    System.out.println("Wrong option...");
                    chooseLanguage();
            }
        }catch(NumberFormatException e){
            System.out.println("You must enter a number.");
            chooseLanguage();
        }
    }

    public void showParamsMenu(){
        resourceBundle = ResourceBundle.getBundle("MyLabels");
        System.out.println(resourceBundle.getString("param_menu"));
        try{
            showParamsMenuImpl(Integer.parseInt(scanner.next().trim()));
        }catch(NumberFormatException e){
            System.out.println(resourceBundle.getString("choice_error"));
            showParamsMenu();
        }
    }

    private void showAverageOrCurrentMenu(String indexParameter){
        resourceBundle = ResourceBundle.getBundle("MyLabels");
        System.out.println(resourceBundle.getString("index_menu"));
        try{
            showAverageOrCurrentMenu(Integer.parseInt(scanner.next().trim()),indexParameter);
        }catch(NumberFormatException e){
            System.out.println(resourceBundle.getString("choice_error"));
            showAverageOrCurrentMenu(indexParameter);
        }
    }

    private void showCitiesMenu(String indexParameter, boolean isCurrent){
        resourceBundle = ResourceBundle.getBundle("MyLabels");
        System.out.println(resourceBundle.getString("main_menu"));
        try{
            if(isCurrent) {
                currentIndexMenuImpl(Integer.parseInt(scanner.next().trim()), indexParameter);
            }else {
                averageIndexMenuImpl(Integer.parseInt(scanner.next().trim()), indexParameter);
            }
        }catch(NumberFormatException e){
            System.out.println(resourceBundle.getString("choice_error"));
            showCitiesMenu(indexParameter, isCurrent);
        }
    }

    private void averageIndexMenuImpl(int choice, String indexParameter){
        switch(choice){
            case 1:
                System.out.printf(indexParameter + "index : " + "%.2f",
                airStatusService.getIndexForCurrentCity(Cities.Gdańsk.name(),indexParameter));
                break;
            case 2:
                System.out.printf(indexParameter + "index : " + "%.2f",
                airStatusService.getIndexForCurrentCity(Cities.Wrocław.name(), indexParameter));
                break;
            case 3:
                System.out.printf(indexParameter + "index : " + "%.2f",
                airStatusService.getIndexForCurrentCity(Cities.Bydgoszcz.name(), indexParameter));
                break;
            case 4:
                System.out.printf(indexParameter + "index : " + "%.2f",
                airStatusService.getIndexForCurrentCity(Cities.Poznań.name(), indexParameter));
                break;
            case 5:
                System.out.printf(indexParameter + "index : " + "%.2f",
                airStatusService.getIndexForCurrentCity(Cities.Kraków.name(), indexParameter));
                break;
            case 6:
                showParamsMenu();
            case 7:
                System.exit(0);
            default:
                System.out.println("Wrong option...");
                showParamsMenu();
        }
    }

    private void currentIndexMenuImpl(int choice, String indexParameter){
        switch(choice){
            case 1:
                System.out.printf("Current " + indexParameter + " index for Gdansk: " + "%2f",
                airStatusService.getCurrentAverageIndexForCity(Cities.Gdańsk.name(),indexParameter));
                break;
            case 2:
                System.out.printf("Current " + indexParameter + " index for Wroclaw: " + "%2f",
                airStatusService.getCurrentAverageIndexForCity(Cities.Wrocław.name(), indexParameter));
                break;
            case 3:
                System.out.printf("Current " + indexParameter + " index for Bydgoszcz: " + "%2f",
                airStatusService.getCurrentAverageIndexForCity(Cities.Bydgoszcz.name(), indexParameter));
                break;
            case 4:
                System.out.printf("Current " + indexParameter + " index for Poznan: " + "%2f",
                airStatusService.getCurrentAverageIndexForCity(Cities.Poznań.name(), indexParameter));
                break;
            case 5:
                System.out.printf("Current " + indexParameter + " index for Krakow: " + "%2f",
                airStatusService.getCurrentAverageIndexForCity(Cities.Kraków.name(), indexParameter));
                break;
            case 6:
                showParamsMenu();
            case 7:
                System.exit(0);
            default:
                System.out.println("Wrong option...");
                showParamsMenu();
        }
    }

    private void showParamsMenuImpl(int choice){
        switch(choice){
            case 1:
                showAverageOrCurrentMenu(SensorParams.PM10.name());
                break;
            case 2:
                showAverageOrCurrentMenu(SensorParams.C6H6.name());
                break;
            case 3:
                showAverageOrCurrentMenu(SensorParams.CO.name());
                break;
            case 4:
                System.exit(0);
            default:
                System.out.println("Wrong option...");
                showParamsMenu();
        }
    }

    private void showAverageOrCurrentMenu(int choice, String indexParameter){
        switch(choice){
            case 1:
                showCitiesMenu(indexParameter, true);
                break;
            case 2:
                showCitiesMenu(indexParameter, false);
                break;
            case 3:
                showParamsMenu();
            case 4:
                System.exit(0);
            default:
                System.out.println("Wrong option...");
                showParamsMenu();
        }
    }

}
