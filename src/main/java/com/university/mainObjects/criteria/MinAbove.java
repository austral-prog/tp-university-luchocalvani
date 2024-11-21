package com.university.mainObjects.criteria;

import com.university.mainObjects.evaluation.Evaluation;
import com.university.mainObjects.Student;

import java.util.ArrayList;
import java.util.List;

public class MinAbove extends Criteria {

    List<String> acceptedEvaluations = new ArrayList<>();

    public MinAbove(String subject, String criteriaType, String criteriaValue, List<String> evaluationNames) {
        super(subject, criteriaType, criteriaValue, evaluationNames);
        acceptedEvaluations.add("WRITTEN_EXAM");
        acceptedEvaluations.add("ORAL_EXAM");
    }

    @Override
    public String evaluate(Student student) {
        Double grade = 0.0;
        int counterApproved = 0;
        for (String evaluationName : evaluationNames){
            Evaluation ev = student.getEvaluation(subject, evaluationName, acceptedEvaluations);
            if(ev == null){
                return "Failed";
            }
            grade = ev.getFinalGrade();
            if (grade >= Double.parseDouble(criteriaValue)){
                counterApproved++;
            }
        }
        if (counterApproved == evaluationNames.size()){
            return "Approved";
        }
        return "Failed";
    }
}
