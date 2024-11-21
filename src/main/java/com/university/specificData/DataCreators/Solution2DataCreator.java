package com.university.specificData.DataCreators;

import com.university.mainObjects.evaluation.Evaluation;
import com.university.specificData.Sorters.EvaluationSorter;

import java.util.ArrayList;
import java.util.List;

public class Solution2DataCreator {

    List<String[]> fileData = new ArrayList<>();

    public Solution2DataCreator(List<Evaluation> evaluations){
        EvaluationSorter evaluationSorter = new EvaluationSorter(evaluations);
        List<Evaluation> orderedEvaluations = evaluationSorter.getOrderedItems();
        for (Evaluation evaluation : orderedEvaluations){
            evaluation.calculateFinalGrade();
            String[] row = {evaluation.getSubject(), evaluation.getEvaluationName(), evaluation.getStudentName(), String.valueOf(evaluation.getFinalGrade())};
            fileData.add(row);
        }
    }
    public List<String[]> getFileData(){
        return fileData;
    }
}
