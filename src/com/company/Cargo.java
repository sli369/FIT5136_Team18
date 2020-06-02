package com.company;

import java.util.*;


public class Cargo {
    private int cargoId;
    private boolean cargoFor;
    private String requirement;
    private int quantity;

    public Cargo(int cargoId, boolean cargoFor, String requirement, int quantity) {
        this.cargoId = cargoId;
        this.cargoFor = cargoFor;
        this.requirement = requirement;
        this.quantity = quantity;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public boolean isCargoFor() {
        return cargoFor;
    }

    public void setCargoFor(boolean cargoFor) {
        this.cargoFor = cargoFor;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
