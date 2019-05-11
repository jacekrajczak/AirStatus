package com.airstatus.app;


import com.airstatus.app.data.model.services.menu.ParametersMenu;

public class Main {

    public static void main(String[] args) {

        ParametersMenu menu = new ParametersMenu();
        while(true)
        menu.showParamsMenu();

    }
}
