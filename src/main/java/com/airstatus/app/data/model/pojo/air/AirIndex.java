package com.airstatus.app.data.model.pojo.air;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirIndex {

    private int id;
    private String pm10CalcDate;

    private AirIndexDetails pm10IndexLevel;

    public AirIndex(){}

    public AirIndex(int id, String pm10CalcDate, AirIndexDetails pm10IndexLevel) {
        this.id = id;
        this.pm10CalcDate = pm10CalcDate;
        this.pm10IndexLevel = pm10IndexLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPm10CalcDate() {
        return pm10CalcDate;
    }

    public void setPm10CalcDate(String pm10CalcDate) {
        this.pm10CalcDate = pm10CalcDate;
    }

    public AirIndexDetails getPm10IndexLevel() {
        return pm10IndexLevel;
    }

    public void setPm10IndexLevel(AirIndexDetails pm10IndexLevel) {
        this.pm10IndexLevel = pm10IndexLevel;
    }

    @Override
    public String toString() {
        return "AirIndex{" +
                "id=" + id +
                ", pm10CalcDate='" + pm10CalcDate + '\'' +
                ", pm10IndexLevel=" + pm10IndexLevel +
                '}';
    }
}
