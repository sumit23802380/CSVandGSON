package com.bridgelabz.csvandgson;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @desc : Open CSV Writer class
 */
public class OpenCSVWriter {
    public static final String OBJECT_LIST_SAMPLE = "data/users.csv";

    /**
     * @desc : Method to write the new object of csvuser by using stateful bean to csv
     */
    public static void writeIntoCSV(){
        try(Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE))){
            StatefulBeanToCsv<Object> beanToCsv = new StatefulBeanToCsvBuilder<>(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            CSVUser csvUser = new CSVUser("sumit jangid" , "sumit@gmail.com" , "8696911813" , "india");
            beanToCsv.write(csvUser);
        }
        catch (IOException|CsvRequiredFieldEmptyException | CsvDataTypeMismatchException  e) {
            throw new RuntimeException(e);
        }
    }
}
