package com.company;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ShuttleControl {

    public void selectShuttle(int selection){
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
                if(Integer.parseInt(cells[0].getContents()) == selection) {
                    shuttleId = Integer.parseInt(cells[0].getContents());
                    shuttleName = cells[1].getContents();
                    shuttleManuyear = cells[2].getContents();
                    shuttleFuelcap = Integer.parseInt(cells[3].getContents());
                    shuttlePassengercap = Integer.parseInt(cells[4].getContents());
                    shuttlecargocap = Integer.parseInt(cells[5].getContents());
                    shuttlespeed = Integer.parseInt(cells[6].getContents());
                    shuttleOrigin = cells[7].getContents();


                    System.out.println("Shuttle ID: " + shuttleId);
                    System.out.println("Shuttle Name: " + shuttleName);
                    System.out.println("Manufacture Year: " + shuttleManuyear);
                    System.out.println("Fuel Capacity (in litres): " + shuttleFuelcap);
                    System.out.println("Passenger Capacity: " + shuttlePassengercap);
                    System.out.println("Cargo Capacity (in kgs): " + shuttlecargocap);
                    System.out.println("Travel Speed: " + shuttlespeed);
                    System.out.println("Origin Country: " + shuttleOrigin);

                    System.out.println("Would you like to assign this shuttle to a mission?");

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
