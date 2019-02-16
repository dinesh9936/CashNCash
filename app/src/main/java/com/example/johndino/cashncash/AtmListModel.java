package com.example.johndino.cashncash;

public class AtmListModel {
    private String name;
    private String latitude;
    private String longitude;
    private String status;

    public AtmListModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AtmListModel(String name, String latitude, String longitude, String status) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }
}
