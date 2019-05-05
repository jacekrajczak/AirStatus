package com.airstatus.app.data.model.pojo;

public class City {

    private int id;
    private String name;

    private Commune commune;

    public City(){}

    public City(int id, String name, com.airstatus.app.data.model.pojo.Commune commune) {
        this.id = id;
        this.name = name;
        this.commune = commune;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commune getCommune() {
        return commune;
    }


    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", commune=" + commune +
                '}';
    }
}
