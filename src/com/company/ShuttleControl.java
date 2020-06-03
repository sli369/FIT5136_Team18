package com.company;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ShuttleControl {

    private ArrayList<Shuttle> shuttles;

    public void checkShuttleInput(String shuttleid)
    {
        try
        {
            int i = Integer.parseInt(shuttleid);

        }
        catch(Exception e)
        {
            System.out.println("Please input a correct shuttle ID!");
        }
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
    }

    public void changeShuttleStatus(int shuttleid){
        shuttles = getShuttles();
        for(int i=0; i<shuttles.size(); i++){
            if(shuttles.get(i).getShuttleId() == shuttleid){
                if(shuttles.get(i).getStatus()){
                    shuttles.get(i).setStatus(false);
                    System.out.println(shuttles.get(i).getStatus());
                }
                else{
                    shuttles.get(i).setStatus(true);
                    System.out.println(shuttles.get(i).getStatus());

                }

            }
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

                // 读取第1个mission内容
//                if(j == 1){
                Cell[] cells = sheet.getRow(j);
//                    for(int i=0; i< columns_total; i++) {
//                        System.out.println(cells[i].getContents());
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
