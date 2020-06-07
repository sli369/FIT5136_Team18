//package com.company;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class File {
//    private String filename;
//
//    public File(String filename) {
//        this.filename = filename;
//    }
//
//    public String getFilename() {
//        return filename;
//    }
//
//    public void setFilename(String filename) {
//        this.filename = filename;
//    }
//
//    public ArrayList<String[]> readFile(){
//        try{
//            FileReader inputFile = new FileReader(filename);
//            try{
//                Scanner parser = new Scanner(inputFile);
//                ArrayList<String[]> values = new ArrayList<String[]>();
//                while(parser.hasNextLine()){
//                    String value = parser.nextLine();
//                    String[] line = value.split(",");
//                    values.add(line);
//                }
//                return values;
//
//
//            }
//            finally {
//                System.out.println("Finish reading file, close file");
//                inputFile.close();
//            }
//        }
//        catch (FileNotFoundException e){
//            System.out.println(filename + "not found");
//        }
//        catch (IOException e){
//            System.out.println("Unexpeted I/O error occues");
//        }
//        return null;
//    }
//
//}

