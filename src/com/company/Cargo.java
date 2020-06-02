package com.company;

import java.util.*;


public class Cargo {

    private String cargoFor;
    private String requirement;
    private int quantity;

    public Cargo(String cargoFor, String requirement, int quantity) {

        this.cargoFor = cargoFor;
        this.requirement = requirement;
        this.quantity = quantity;
    }

    public String getCargoFor() {
        return cargoFor;
    }

    public void setCargoFor(String cargoFor) {
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
