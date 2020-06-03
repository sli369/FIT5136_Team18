package com.company;


import jxl.Workbook;

import java.io.File;
import java.util.Scanner;

public class MissionControl {

    public void writeFile(){
        try{
            Workbook workbook = Workbook.getWorkbook(new File("mission.xls"));

        }
        catch (Exception e){

        }
    }

    public void createMission(){
        Scanner sc = new Scanner(System.in);
    }
}
