package com.bridgelabz.csvandgson;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * @desc : Open csv read and parse to bean class
 */
public class OpenCSVReadAndParseToBean {
    private static final String CSV_FILE_PATH = "data/users.csv";

    /**
     * @desc : Method to read the data from csv file and parse to bean and print it
     */
    public static void readData(){
        try(
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        )
        {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();
            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()){
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name :" + csvUser.getName());
                System.out.println("Email :" + csvUser.getEmail());
                System.out.println("PhoneNo :" + csvUser.getPhoneNo());
                System.out.println("Country :" + csvUser.getCountry());
                System.out.println("================================");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
