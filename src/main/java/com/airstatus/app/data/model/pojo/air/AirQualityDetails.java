package com.airstatus.app.data.model.pojo.air;

public class AirQualityDetails {

    private int id;
    private String indexLevelName;

    public AirQualityDetails(){}

    public AirQualityDetails(int id, String indexLevelName) {
        this.id = id;
        this.indexLevelName = indexLevelName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndexLevelName() {
        return indexLevelName;
    }

    public void setIndexLevelName(String indexLevelName) {
        this.indexLevelName = indexLevelName;
    }

    @Override
    public String toString() {
        return "AirQualityDetails{" +
                "id=" + id +
                ", indexLevelName='" + indexLevelName + '\'' +
                '}';
    }
}
