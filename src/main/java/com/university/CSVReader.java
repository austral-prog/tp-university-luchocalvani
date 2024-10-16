package com.university;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    private String filename;
    private List<String[]> allData = new ArrayList<>();

    public CSVReader(String filename) {
        this.filename = filename;
    }
    public void read(String delimiter){
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                allData.add(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String[]> getAllData(){
        return allData;
    }
}
