package com.company;

import com.opencsv.CSVWriter;
import com.sun.corba.se.impl.orbutil.closure.Constant;

import java.io.FileWriter;
import java.io.IOException;

public class CSVHelper {

    CSVWriter csvWriter;

    public CSVHelper() {
            initCsvHelper();
            System.out.println();
        //csvWriter.writeNext(new String[3]);
    }

    private void initCsvHelper() {
        try {
            csvWriter = new CSVWriter(new FileWriter(Constants.FILE_NAME+CommonHelper.createTimeForFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToCSVFile(String ... args) {
        csvWriter.writeNext(args);
    }

    public void closeCsvFile() {
        try {
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
