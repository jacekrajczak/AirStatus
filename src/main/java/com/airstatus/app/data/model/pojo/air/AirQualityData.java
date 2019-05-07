package com.airstatus.app.data.model.pojo.air;

import java.util.List;

public class AirQualityData {

    private String key;
    private List<AirQualityValues> values;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<AirQualityValues> getValues() {
        return values;
    }

    public void setValues(List<AirQualityValues> values) {
        this.values = values;
    }
}
