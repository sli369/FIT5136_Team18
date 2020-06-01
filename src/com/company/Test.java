package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.Test;


public class Test {
     try{
        jxl.Workbook wb =null;
        InputStream is = new FileInputStream("D://G201.xls");
        wb = Workbook.getWorkbook(is);

        int sheetSize = wb.getNumberOfSheets();
        Sheet sheet = wb.getSheet(0);
        int row_total = sheet.getRows();
        for (int j = 0; j < row_total; j++) {
            if(j == 0){
                Cell[] cells = sheet.getRow(j);

                System.out.println(cells[0].getContents());
                System.out.println(cells[1].getContents());
                System.out.println(cells[2].getContents());
            }
        }
    }
     catch (
    IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (BiffException e){
        e.printStackTrace();
    }
}
