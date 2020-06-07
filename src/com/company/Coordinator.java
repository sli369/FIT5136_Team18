package com.company;

import java.util.Scanner;

public class Coordinator extends User {
    private String name;
    private String email;

    public Coordinator(String name, String email){
        super();
        this.name = name;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean missionBelong() {
        return true;
    }



}
