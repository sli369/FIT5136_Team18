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

public class Test {

    public static void main(String args[]) throws WriteException, IOException, BiffException {
        MtmSystem mtm = new MtmSystem();
        WriteExcel();
    }

    private static void WriteExcel() {
        String existingxlsPathName = "/Users/zoe/IdeaProjects/FIT5136_Team18/Candidate.xls";
        //WorkbookSettings wbSettings = new WorkbookSettings();
        //wbSettings.setLocale(new Locale("en", "EN"));
        WritableWorkbook writebook = null;
        InputStream in = null;
        String UTF8_ENCODING = "UTF-8";
        try {
            WorkbookSettings setEncode = new WorkbookSettings();
            setEncode.setEncoding(UTF8_ENCODING);
            in = new FileInputStream(new File("/Users/zoe/IdeaProjects/FIT5136_Team18/Candidate.xls"));
            Workbook existingWorkbook = Workbook.getWorkbook(in);
            WritableWorkbook workbookCopy = Workbook.createWorkbook(new java.io.File("/Users/zoe/IdeaProjects/FIT5136_Team18/Candidate.xls"), existingWorkbook);
            WritableSheet sheetToEdit = workbookCopy.getSheet(0);
            sheetToEdit.addCell(new Label(4, 12, "test3"));
            workbookCopy.write();
            workbookCopy.close();
            in.close();
        } catch (IOException | WriteException | BiffException e) {
            System.out.println(e.getMessage());
        }


    }



}
