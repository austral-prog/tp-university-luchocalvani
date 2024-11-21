package com.university.mainObjects.criteria;

import com.university.mainObjects.evaluation.Evaluation;
import com.university.mainObjects.Student;

import java.util.ArrayList;
import java.util.List;

public class MaxAbove extends Criteria {

    private List<String> acceptedEvaluations = new ArrayList<>();

    public MaxAbove(String subject, String criteriaType, String criteriaValue, List<String> evaluationNames) {
        super(subject, criteriaType, criteriaValue, evaluationNames);
        acceptedEvaluations.add("FINAL_PRACTICAL_WORK");
        acceptedEvaluations.add("ORAL_EXAM");
        acceptedEvaluations.add("WRITTEN_EXAM");
    }

    @Override
    public String evaluate(Student student) {
        Double grade = 0.0;
        for (String evaluationName : evaluationNames){
            Evaluation ev = student.getEvaluation(subject, evaluationName, acceptedEvaluations);
            if (ev == null){
                return "Failed";
            }
            grade = ev.getFinalGrade();
        }
        if (grade <= Double.parseDouble(criteriaValue)){
            return "Approved";
        }
        return "Failed";
    }
    //Es la nota de Examen final y tmb de TP final (por separado)

}
