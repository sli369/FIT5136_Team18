package com.company;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {
    public static void main(String args[]) {
        try{
            Workbook book = Workbook.getWorkbook(new File("C:\\Users\\harry\\IdeaProjects\\FIT5136_Team18\\src\\com\\company\\mission.xls"));

            int sheetSize = book.getNumberOfSheets();
            Sheet sheet = book.getSheet(0);
            int row_total = sheet.getRows();
            for (int j = 0; j < row_total; j++) {
                if(j == 0){
                    Cell[] cells = sheet.getRow(j);

                    System.out.println(cells[0].getContents());
                    System.out.println(cells[1].getContents());
                    System.out.println(cells[2].getContents());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}