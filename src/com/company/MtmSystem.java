package com.company;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MtmSystem {
    private ArrayList<User> users;
    private ArrayList<Mission> missions;
    private ArrayList<Shuttle> shuttles;
    private ArrayList<Criteria> criterias;
    private ArrayList<Cargo> cargos;
    private ArrayList<Job> jobs;
//    // get list of mission
//    public static void main(String args[]){
//
//    }

    public ArrayList<Mission> getMissions(){
        missions = new ArrayList<Mission>();

        return missions;
    }

    public void showMissions(){
        missions = getMissions();
        System.out.println("Show all mission Id");
        for(int i=0; i<missions.size(); i++){
            System.out.println("mission id: " + missions.get(i).getMissionId() + "  mission name: "+ missions.get(i).getMissionName());
        }
    }

    public void showOneMission(){
        Scanner sc = new Scanner(System.in);
        int missionId = sc.nextInt();
        missions = getMissions();
        for(int i=0; i<missions.size(); i++){
            if(missionId == missions.get(i).getMissionId()){
                System.out.println("mission id: " + missions.get(i).getMissionId() + "  mission name: "+ missions.get(i).getMissionName());
            }
        }
    }



}
