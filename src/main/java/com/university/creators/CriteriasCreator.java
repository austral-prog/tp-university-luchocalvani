package com.university.creators;

import com.university.CSV.CSVReader;
import com.university.mainObjects.criteria.AverageAbove;
import com.university.mainObjects.criteria.Criteria;
import com.university.mainObjects.criteria.MaxAbove;
import com.university.mainObjects.criteria.MinAbove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CriteriasCreator {
    private static List<Criteria> criterias = new ArrayList<>();

    public CriteriasCreator(String fileIn){
        CSVReader csv = new CSVReader(fileIn);
        csv.read(",");
        List<String[]> allData = csv.getAllData();
        for(String[] data : allData){
            System.out.println(data.length);
            String subject = data[0];
            String criteriaType = data[1];
            String criteriaValue = data[2];
            List<String> evaluationNames = List.of(Arrays.copyOfRange(data, 3, data.length));

            switch(criteriaType){
                case "AVERAGE_ABOVE_VALUE":
                    AverageAbove averageAbove = new AverageAbove(subject, criteriaType, criteriaValue, evaluationNames);
                    criterias.add(averageAbove);
                case "MAX_ABOVE_VALUE":
                    MaxAbove maxAbove =  new MaxAbove(subject, criteriaType, criteriaValue, evaluationNames);
                    criterias.add(maxAbove);
                case "MIN_ABOVE_VALUE":
                    MinAbove minAbove =  new MinAbove(subject, criteriaType, criteriaValue, evaluationNames);
                    criterias.add(minAbove);

            }
        }
    }
    public List<Criteria> getCriteriasList(){
        return criterias;
    }
}
