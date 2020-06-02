package com.company;

import java.util.ArrayList;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MtmSystem {
    private ArrayList<User> users;
    private ArrayList<Mission> missions;
    private ArrayList<Shuttle> shuttles;
    private ArrayList<Criteria> criterias;

//    // get list of mission
//    public static void main(String args[]){
//
//    }

    public ArrayList<Mission> getMissions(){
        missions = new ArrayList<Mission>();
        addMission();
        return missions;
    }


    public void showMissions(){
        missions = getMissions();
        System.out.println("Show all mission Id");
        for(int i=0; i<missions.size(); i++){
            System.out.println("mission id" + missions.get(i).getMissionId());
        }
    }

    private void addMission(){
        try{
            Workbook book = Workbook.getWorkbook(new File("mission.xls"));
            int sheetSize = book.getNumberOfSheets();
            Sheet sheet = book.getSheet(0);
            int row_total = sheet.getRows();
            int columns_total = sheet.getColumns();
            // get one line of mission
            for (int j = 1; j < row_total; j++) {
                int missionId;
                String missionLauchDate;
                String missionOrign;
                int missionDuration;
                String missionType;
                String missionDescription;
                String employeeRequire;
                String ageRange;
                String minExp;
                String qualification;
                String occupation;
                String skillRequire;
                String language;
                String secLanguage;
                String cargoFor;
                String cargoRequire;
                int cargoQuality;
                // 读取第1个mission内容
//                if(j == 1){
                    Cell[] cells = sheet.getRow(j);
//                    for(int i=0; i< columns_total; i++) {
//                        System.out.println(cells[i].getContents());
                    missionId = Integer.parseInt(cells[0].getContents());
                    missionLauchDate = cells[1].getContents();
                    missionOrign = cells[2].getContents();
                    missionDuration = Integer.parseInt(cells[3].getContents());
                    missionType = cells[4].getContents();
                    missionDescription = cells[5].getContents();
                    employeeRequire = cells[6].getContents();
                    ageRange = cells[7].getContents();
                    minExp = cells[8].getContents();
                    qualification = cells[9].getContents();
                    occupation = cells[10].getContents();
                    skillRequire = cells[11].getContents();
                    language = cells[12].getContents();
                    secLanguage = cells[13].getContents();
                    cargoFor = cells[14].getContents();
                    cargoRequire = cells[15].getContents();
                    cargoQuality = Integer.parseInt(cells[16].getContents());

//                    System.out.println("Mission ID: " + missionId);
//                    System.out.println("Launch Date: " + missionLauchDate);
//                    System.out.println("Mission Duration: " + missionDuration);
//                    System.out.println("Mission Type: " + missionType);
//                    System.out.println("mission Description: " + missionDescription);
//                    System.out.println("Employee Requirement" + employeeRequire);
//                    System.out.println("Skill Requirement " + skillRequire);
//                    System.out.println("Cargo For ?: " + cargoFor);
//                    System.out.println("Cargo Requirement: " + cargoRequire);
//                    System.out.println("Cargo quality: " + cargoQuality);

                    Mission mission = new Mission(missionId);
                    missions.add(mission);
                }
//            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public ArrayList<Shuttle> getShuttles(){
        shuttles = new ArrayList<Shuttle>();
        readShuttle();
        return shuttles;
    }

    public void showShuttles(){
        shuttles = getShuttles();
        System.out.println("All shuttles are shown below:");
        for(int i=0; i<shuttles.size(); i++){
            System.out.println("Shuttle id" + shuttles.get(i).getShuttleId());
        }
    }

    public void readShuttle(){
        try{
            Workbook book = Workbook.getWorkbook(new File("shuttles.xls"));
            int sheetSize = book.getNumberOfSheets();
            Sheet sheet = book.getSheet(0);
            int row_total = sheet.getRows();
            int columns_total = sheet.getColumns();
            // get one line of mission
            for (int j = 1; j < row_total; j++) {
                int shuttleId;
                String shuttleName;
                String shuttleManuyear;
                int shuttleFuelcap;
                int shuttlePassengercap;
                int shuttlecargocap;
                int shuttlespeed;
                String shuttleOrigin;
                String shuttleMission;

                Cell[] cells = sheet.getRow(j);
                if(cells.length <= 8) {
                    shuttleId = Integer.parseInt(cells[0].getContents());
                    shuttleName = cells[1].getContents();
                    shuttleManuyear = cells[2].getContents();
                    shuttleFuelcap = Integer.parseInt(cells[3].getContents());
                    shuttlePassengercap = Integer.parseInt(cells[4].getContents());
                    shuttlecargocap = Integer.parseInt(cells[5].getContents());
                    shuttlespeed = Integer.parseInt(cells[6].getContents());
                    shuttleOrigin = cells[7].getContents();


                    System.out.println("Shuttle ID: " + shuttleId);
//                    System.out.println("Shuttle Name: " + shuttleName);
//                    System.out.println("Manufacture Year: " + shuttleManuyear);
//                    System.out.println("Fuel Capacity (in litres): " + shuttleFuelcap);
//                    System.out.println("Passenger Capacity: " + shuttlePassengercap);
//                    System.out.println("Cargo Capacity (in kgs): " + shuttlecargocap);
//                    System.out.println("Travel Speed: " + shuttlespeed);
//                    System.out.println("Origin Country: " + shuttleOrigin);
//
//                    Shuttle shuttle = new Shuttle(shuttleId);
//                    shuttles.add(shuttle);
//                    System.out.println(shuttles);
                }
            }
//            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
