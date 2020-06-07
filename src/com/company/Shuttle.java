package com.company;

import java.util.Date;

public class Shuttle {
    private final int shuttleId;
    private String shuttleName;
    private Date manuYear;
    private int fuelCapacity;
    private int passengerCapacity;
    private int cargoCapacity;
    private int travelSpeed;
    private String origin;
    private boolean status;

    public Shuttle(int shuttleId, String shuttleName, Date manuYear, int fuelCapacity, int passengerCapacity, int cargoCapacity, int travelSpeed, String origin, boolean status){
        this.shuttleId = shuttleId;
        this.shuttleName = shuttleName;
        this.manuYear = manuYear;
        this.fuelCapacity = fuelCapacity;
        this.passengerCapacity = passengerCapacity;
        this.cargoCapacity = cargoCapacity;
        this.travelSpeed = travelSpeed;
        this.origin = origin;
        this.status = status;
    }


    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setManuYear(Date manuYear) {
        this.manuYear = manuYear;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public void setShuttleName(String shuttleName) {
        this.shuttleName = shuttleName;
    }

    public void setTravelSpeed(int travelSpeed) {
        this.travelSpeed = travelSpeed;
    }

    public void setOrigin(String origin){
        this.origin = origin;
    }

    public void setStatus(boolean status){this.status = status;}

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public Date getManuYear() {
        return manuYear;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getTravelSpeed() {
        return travelSpeed;
    }

    public int getShuttleId() {
        return shuttleId;
    }

    public boolean getStatus(){return status;}

    public String getShuttleName() {
        return shuttleName;
    }

    public String getOrigin() {
        return origin;
    }

    public void showShuttles(){
        //是否要用txt文件存储数据？
    }




}


