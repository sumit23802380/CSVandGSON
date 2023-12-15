package com.bridgelabz.csvandgson;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import java.nio.file.Files;
import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 * @desc : OpenCSV Reader Class
 */
public class OpenCSVReader {
    private static final String CSV_FILE_PATH = "data/users.csv";

    /**
     * @desc : Method to read the row one by one from CSV file and prints them
     */
    public static void readDataOneByOne(){
        try(
            Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
        )
        {
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext())!=null){
                System.out.println("Name :" + nextRecord[0]);
                System.out.println("Email :" + nextRecord[1]);
                System.out.println("Phone :" + nextRecord[2]);
                System.out.println("Country :" + nextRecord[3]);
                System.out.println("===========================");
            }
        }
        catch (IOException | CsvValidationException  e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    /**
     * @desc : Method to read the data at once from CSV file and prints them
     */
    public static void readDataAtOnce(){
        try(
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        )
        {
            List<String[]> records = csvReader.readAll();
            for(String[] nextRecord : records){
                System.out.println("Name :" + nextRecord[0]);
                System.out.println("Email :" + nextRecord[1]);
                System.out.println("Phone :" + nextRecord[2]);
                System.out.println("Country :" + nextRecord[3]);
                System.out.println("===========================");
            }
        }
        catch (IOException | CsvException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
