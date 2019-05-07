package com.airstatus.app.data.model.pojo.air;

public class AirQualityValues {

    private String value;
    private String date;

    public AirQualityValues(){}

    public AirQualityValues(String value, String date) {
        this.value = value;
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AirQualityValues{" +
                "value='" + value + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
