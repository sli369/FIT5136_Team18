package com.company;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.WriteAbortedException;

public class Test {

    public static void main(String args[]) throws WriteException, IOException, BiffException {
         MtmSystem mtm = new MtmSystem();
        readAndWrite();
    }

    private static void readAndWrite() throws BiffException, IOException, WriteAbortedException, WriteException {
        //File file = new File("forWritingIntoCandidate.xls");
        Workbook workbook = Workbook.getWorkbook(new java.io.File("candidate.xls"));
        OutputStream os = new FileOutputStream("candidate.xls");
        WritableWorkbook writableWorkbook = Workbook.createWorkbook(os);
        WritableSheet sheet = writableWorkbook.getSheet(0);
        Label lable2 = new Label(2,2,"hello world!");
        writableWorkbook.write();

        writableWorkbook.close();

    }
}
