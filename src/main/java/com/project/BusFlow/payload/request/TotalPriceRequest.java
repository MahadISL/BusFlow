package com.project.BusFlow.payload.request;

public class TotalPriceRequest {

    private String city;
    private String startPosition;
    private String stopPosition;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getStopPosition() {
        return stopPosition;
    }

    public void setStopPosition(String stopPosition) {
        this.stopPosition = stopPosition;
    }

    @Override
    public String toString() {
        return "totalPriceRequest{" +
                "city='" + city + '\'' +
                ", startPosition='" + startPosition + '\'' +
                ", stopPosition='" + stopPosition + '\'' +
                '}';
    }
}
