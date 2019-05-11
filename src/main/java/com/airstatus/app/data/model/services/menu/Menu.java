package com.airstatus.app.data.model.services.menu;

public interface Menu {

    default void showCitiesMenu(){
        System.out.println(">>>> AirStatus - check your air quality index <<<<");
        System.out.println("Choose your city:" +
                "\n1) Gdansk." +
                "\n2) Wroclaw." +
                "\n3) Bydgoszcz." +
                "\n4) Poznan." +
                "\n5) Krakow."+
                "\n6) Previous."+
                "\n7) Exit.");
    }

    default void showParamsMenu(){
        System.out.println("\nChoose Air Quality Index you want to check:");
        System.out.println(
                "1) PM10. (Pyl zawieszony PM10)" +
                "\n2) C6H6. (Benzen)" +
                "\n3) CO. (Tlenek wegla)" +
                "\n4) Exit.");
    }

    default void averageOrCurrentMenu(){
        System.out.println("Do you want to show current or average index? (from past 2 days)");
        System.out.println(
                "1) Current Index." +
                "\n2) Average Index." +
                "\n3) Previous." +
                "\n4) Exit.");
    }


}
