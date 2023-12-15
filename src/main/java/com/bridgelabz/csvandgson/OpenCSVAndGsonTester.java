package com.bridgelabz.csvandgson;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @desc : Reading from CSV file and writing into json file
 */
public class OpenCSVAndGsonTester {

    private static final String SAMPLE_CSV_FILE_PATH = "data/users.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "data/users.json";

    public static void readFromCSVandWriteToJSON() {
        try {
            // Reading CSV File and creating bean
            BufferedReader reader = new BufferedReader(new FileReader(Paths.get(SAMPLE_CSV_FILE_PATH).toFile()));
            CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();

            // Convert to JSON and save
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();

            // Reading JSON File and converting to bean
            BufferedReader br = new BufferedReader(new FileReader(Paths.get(SAMPLE_JSON_FILE_PATH).toFile()));
            CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrObj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
