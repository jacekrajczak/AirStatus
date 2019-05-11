package com.airstatus.app.data.model.services.menu;

import com.airstatus.app.data.model.services.airstatus.AirStatusServiceImpl;
import com.airstatus.app.data.model.services.menu.choices.Cities;
import com.airstatus.app.data.model.services.menu.choices.SensorParams;

import java.util.Scanner;

public class ParametersMenu implements Menu{

    private Scanner scanner = new Scanner(System.in);
    private AirStatusServiceImpl airStatusService = new AirStatusServiceImpl();

    public void showParamsMenu(){
        Menu.super.showParamsMenu();
        try{
            showParamsMenuImpl(Integer.parseInt(scanner.next().trim()));
        }catch(NumberFormatException e){
            System.out.println("You must enter a number.");
            showParamsMenu();
        }
    }

    private void showAverageOrCurrentMenu(String indexParameter){
        Menu.super.averageOrCurrentMenu();
        try{
            showAverageOrCurrentMenu(Integer.parseInt(scanner.next().trim()),indexParameter);
        }catch(NumberFormatException e){
            System.out.println("You must enter a number.");
            showAverageOrCurrentMenu(indexParameter);
        }
    }

    private void showCitiesMenu(String indexParameter, boolean isCurrent){
        Menu.super.showCitiesMenu();
        try{
            if(isCurrent) {
                currentIndexMenuImpl(Integer.parseInt(scanner.next().trim()), indexParameter);
            }else {
                averageIndexMenuImpl(Integer.parseInt(scanner.next().trim()), indexParameter);
            }
        }catch(NumberFormatException e){
            System.out.println("You must choose City.");
            showCitiesMenu(indexParameter, isCurrent);
        }
    }

    private void averageIndexMenuImpl(int choice, String indexParameter){
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
                airStatusService.getCurrentAverageIndexForCity(Cities.Gdańsk.name(),indexParameter);
                break;
            case 2:
                airStatusService.getCurrentAverageIndexForCity(Cities.Wrocław.name(), indexParameter);
                break;
            case 3:
                airStatusService.getCurrentAverageIndexForCity(Cities.Bydgoszcz.name(), indexParameter);
                break;
            case 4:
                airStatusService.getCurrentAverageIndexForCity(Cities.Poznań.name(), indexParameter);
                break;
            case 5:
                airStatusService.getCurrentAverageIndexForCity(Cities.Kraków.name(), indexParameter);
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
