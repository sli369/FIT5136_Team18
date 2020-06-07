package com.company;

import jxl.*;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class ShuttleControl {

    private static final String UTF8_ENCODING = "UTF-8";
    private ArrayList<Shuttle> shuttles;
    MainPageController mp = new MainPageController();

    public void shuttlePage(){
        Scanner sc = new Scanner(System.in);
        int userInput = 0;
        System.out.println("-- Please select an option: ");
        System.out.println("1. View all shuttles ");
        System.out.println("2. Search for a shuttle");
        System.out.println("3. Change status of a shuttle");
        System.out.println("4. Back");
        System.out.println("-- Please enter the number of your selection:");
        while(true) {
            try {
                userInput = sc.nextInt();
                while(true){
                    if(userInput>=1 && userInput<=4){
                        break;
                    }
                    else{
                        System.out.println("Wrong input! Please enter a valid option:");
                        userInput = sc.nextInt();
                    }
                }
                break;
            }catch(Exception e) {
                System.out.println("Wrong input! please enter an Integer: ");
                sc.next();
            }
        }

//        while(!rangeInDefined(userInput,1,3)){
//            System.out.println("Please enter a valid option!");
//            userInput = sc.nextInt();
//        }
        switch(userInput){
            case 1:
                showShuttles();
                shuttlePage();
            case 2:
                int s1 = 0;
                System.out.println("-- Please enter the shuttle ID:");
                while(true) {
                    try {
                        s1 = sc.nextInt();
                        while(true){
                            if(inShuttleList(s1)){
                                break;
                            }
                            else{
                                System.out.println("Shuttle does not exist! Please try again:");
                                s1 = sc.nextInt();
                            }
                        }
                        break;
                    }catch(Exception e) {
                        System.out.println("Wrong input! please enter an Integer: ");
                        sc.next();
                    }
                }
                showShuttleDetails(s1);
                shuttlePage();

            case 3:
                int s2 = 0;
                System.out.println("-- Please enter the shuttle ID:");
                while(true) {
                    try {
                        s2 = sc.nextInt();
                        while(true){
                            if(inShuttleList(s2)){
                                break;
                            }
                            else{
                                System.out.println("Shuttle does not exist! Please try again:");
                                s2 = sc.nextInt();
                            }
                        }
                        break;
                    }catch(Exception e) {
                        System.out.println("Wrong input! please enter an Integer: ");
                        sc.next();
                    }
                }
                changeShuttleStatus(s2);
                shuttlePage();
            case 4:
//                mp.WelcomePage();
        }

    }

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0;) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean rangeInDefined(int current, int min, int max)
    {
        return Math.max(min, current) == Math.min(current, max);
    }

    public  boolean inShuttleList(int shuttleid){
        getShuttles();
        boolean ret = false;
        for(int i=0; i<shuttles.size(); i++){
            if(shuttleid == shuttles.get(i).getShuttleId()){
                ret = true;
            }
        }
        return ret;
    }

    public boolean checkShuttleID(int shuttleid) throws IOException, BiffException {
        Workbook book = Workbook.getWorkbook(new File("shuttles.xls"));
        int sheetSize = book.getNumberOfSheets();
        Sheet sheet = book.getSheet(0);
        int row_total = sheet.getRows();
        boolean flag = false;
        int columns_total = sheet.getColumns();
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

            if(Integer.parseInt(cells[0].getContents()) == shuttleid){
                flag = true;
            }
        }
        return flag;
    }

//    public void assignShuttle(int missionid, int shuttleid){
//        File f = new File("shuttles.xls");
//        try {
//            Workbook wb = Workbook.getWorkbook(f);//
//            WritableWorkbook book = wb.createWorkbook(f, wb);
//            Sheet st = book.getSheet(0);
//            for (int i = 0; i < st.getRows(); i++) {
//                Cell[] cells = st.getRow(i);
//                if(Integer.parseInt(cells[0].getContents()) == shuttleid){
//                    Label lable = new Label(9, i, String.valueOf(missionid));
//                }
//            }
//            book.write();
//            book.close();
//            wb.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public ArrayList<Shuttle> getShuttles(){
        shuttles = new ArrayList<Shuttle>();
        addShuttle();
        return shuttles;
    }

    public void showShuttles(){
        shuttles = getShuttles();
        System.out.println("Show all shuttle Id");
        for(int i=0; i<shuttles.size(); i++){
            System.out.println("Shuttle id: " + shuttles.get(i).getShuttleId());
        }
    }

    public void showShuttleDetails(int shuttleid){
        shuttles = getShuttles();
        System.out.println("******Details of Shuttle " + shuttleid + "******");
        for(int i=0; i<shuttles.size(); i++){
            if(shuttles.get(i).getShuttleId() == shuttleid){
                System.out.println("ID: " + shuttles.get(i).getShuttleId());
                System.out.println("Name: " + shuttles.get(i).getShuttleName());
                System.out.println("Manufacture Year: " + shuttles.get(i).getManuYear());
                System.out.println("Fuel Capacity (in litres): " + shuttles.get(i).getFuelCapacity());
                System.out.println("Passenger Capacity: " + shuttles.get(i).getPassengerCapacity());
                System.out.println("Cargo Capacity (in kgs): " + shuttles.get(i).getCargoCapacity());
                System.out.println("Travel Speed: " + shuttles.get(i).getTravelSpeed());
                System.out.println("Origin Country: " + shuttles.get(i).getOrigin());
                System.out.println("If Available: " + shuttles.get(i).getStatus());
            }
        }
        System.out.println("*******************************************");
    }

    public void changeShuttleStatus(int shuttleid) {
        shuttles = getShuttles();
        int target = 0;
        for (int i = 0; i < shuttles.size(); i++) {
            if (shuttles.get(i).getShuttleId() == shuttleid) {
                target = i;
                if (shuttles.get(i).getStatus()) {
                    shuttles.get(i).setStatus(false);
                } else {
                    shuttles.get(i).setStatus(true);
                }
            }
        }
        InputStream in = null;
        try {
            WorkbookSettings setEncode = new WorkbookSettings();
            setEncode.setEncoding(UTF8_ENCODING);
            in = new FileInputStream(new File("shuttles.xls"));
            Workbook existingWorkbook = Workbook.getWorkbook(in);
            WritableWorkbook workbookCopy = Workbook.createWorkbook(new java.io.File("shuttles.xls"), existingWorkbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            String value = String.valueOf(shuttles.get(target).getStatus());
            sheetToEdit.addCell(new Label(8, target + 1, value));
            System.out.println("The Status of Shuttle " + shuttleid + " has been changed to " + shuttles.get(target).getStatus());
            workbookCopy.write();
            workbookCopy.close();
            in.close();
        } catch (IOException | WriteException | BiffException e) {
            System.out.println(e.getMessage());
        }
    }



    public void addShuttle(){
        try{
            Workbook book = Workbook.getWorkbook(new File("shuttles.xls"));
            int sheetSize = book.getNumberOfSheets();
            Sheet sheet = book.getSheet(0);
            int row_total = sheet.getRows();
            int columns_total = sheet.getColumns();
            for (int j = 1; j < row_total; j++) {
                int shuttleId;
                String shuttleName;
                Date manuYear;
                int fuelCapacity;
                int passengerCapacity;
                int cargoCapacity;
                int travelSpeed;
                String origin;
                boolean status;
                SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
                Cell[] cells = sheet.getRow(j);
                shuttleId = Integer.parseInt(cells[0].getContents());
                shuttleName = cells[1].getContents();
                manuYear = format.parse(cells[2].getContents());
                fuelCapacity = Integer.parseInt(cells[3].getContents());
                passengerCapacity = Integer.parseInt(cells[4].getContents());
                cargoCapacity = Integer.parseInt(cells[5].getContents());
                travelSpeed = Integer.parseInt(cells[6].getContents());
                origin = cells[7].getContents();
                status = Boolean.parseBoolean(cells[8].getContents());


                Shuttle shuttle = new Shuttle(shuttleId, shuttleName, manuYear, fuelCapacity, passengerCapacity, cargoCapacity, travelSpeed, origin, status);
                shuttles.add(shuttle);


            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
