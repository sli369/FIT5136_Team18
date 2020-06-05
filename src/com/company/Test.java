package com.company;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Test {

    public static void main(String args[]){
        MissionControl mc = new MissionControl();
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        mc.showOneMission(i);


    }

    private static void WriteExcel() {
        String existingxlsPathName = "/Users/zoe/IdeaProjects/FIT5136_Team18/Candidate.xls";
        //WorkbookSettings wbSettings = new WorkbookSettings();
        //wbSettings.setLocale(new Locale("en", "EN"));
        WritableWorkbook writebook = null;
        InputStream in = null;
        String UTF8_ENCODING = "UTF-8";
        Scanner sc = new Scanner(System.in);
        try {
            WorkbookSettings setEncode = new WorkbookSettings();
            setEncode.setEncoding(UTF8_ENCODING);
            in = new FileInputStream(new File("Candidate.xls"));
            Workbook existingWorkbook = Workbook.getWorkbook(in);
            WritableWorkbook workbookCopy = Workbook.createWorkbook(new java.io.File("Candidate.xls"), existingWorkbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            String value = sc.nextLine();
            sheetToEdit.addCell(new Label(5, 12, value));
            System.out.println("You add successfully");
            workbookCopy.write();
            workbookCopy.close();
            in.close();
        } catch (IOException | WriteException | BiffException e) {
            System.out.println(e.getMessage());
        }


    }



}
