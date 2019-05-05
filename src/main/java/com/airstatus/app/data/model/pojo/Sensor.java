package com.airstatus.app.data.model.pojo;

public class Sensor {

    private int id;
    private int stationId;

    private Parameter param;

    public Sensor(){}

    public Sensor(int id, int stationId, Parameter param) {
        this.id = id;
        this.stationId = stationId;
        this.param = param;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public Parameter getParam() {
        return param;
    }

    public void setParam(Parameter param) {
        this.param = param;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id=" + id +
                ", stationId=" + stationId +
                ", param=" + param +
                '}';
    }
}
