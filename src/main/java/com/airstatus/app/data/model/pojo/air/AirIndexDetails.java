package com.airstatus.app.data.model.pojo.air;

public class AirIndexDetails {

    private int id;
    private String indexLevelName;

    public AirIndexDetails(){}

    public AirIndexDetails(int id, String indexLevelName) {
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
        return "AirIndexDetails{" +
                "id=" + id +
                ", indexLevelName='" + indexLevelName + '\'' +
                '}';
    }
}
