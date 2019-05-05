package com.airstatus.app.data.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AirQualityIndex {

    private int id;
    private String pm10CalcDate;

    private IndexLevel pm10IndexLevel;

    public AirQualityIndex(){}

    public AirQualityIndex(int id, String pm10CalcDate, IndexLevel pm10IndexLevel) {
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

    public IndexLevel getPm10IndexLevel() {
        return pm10IndexLevel;
    }

    public void setPm10IndexLevel(IndexLevel pm10IndexLevel) {
        this.pm10IndexLevel = pm10IndexLevel;
    }

    @Override
    public String toString() {
        return "AirQualityIndex{" +
                "id=" + id +
                ", pm10CalcDate='" + pm10CalcDate + '\'' +
                ", pm10IndexLevel=" + pm10IndexLevel +
                '}';
    }
}
