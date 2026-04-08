package com.batterytestsite.testingsite;

import java.io.IOException;

import edu.wpi.first.util.datalog.DataLogReader;
public class WPILogHandler {
    DataLogReader LogReader;

     public WPILogHandler(String fileName) {
        try {
            LogReader=new DataLogReader(fileName);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public DataLogReader ReturnReader(){
        return LogReader;
    }
    public Boolean IsLogValid(){
        return LogReader.isValid();
    };
}
