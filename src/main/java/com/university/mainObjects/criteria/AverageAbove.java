package com.university.mainObjects.criteria;

import com.university.mainObjects.evaluation.Evaluation;
import com.university.mainObjects.Student;

import java.util.ArrayList;
import java.util.List;

public class AverageAbove extends Criteria {

    private List<String> acceptedEvaluations = new ArrayList<>();

    public AverageAbove(String subject, String criteriaType, String criteriaValue, List<String> evaluationsNames) {
        super(subject, criteriaType, criteriaValue, evaluationsNames);
        acceptedEvaluations.add("PRACTICAL_WORK");
    }

    @Override
    public String evaluate(Student student) {
        Double grade = 0.0;
        for (String evaluationName : evaluationNames){
            Evaluation ev = student.getEvaluation(subject, evaluationName, acceptedEvaluations);
            if (ev == null){
                return "Failed";
            }
            grade += ev.getFinalGrade();
        }
        grade = grade / evaluationNames.size();
        if (grade > Double.parseDouble(criteriaValue)){
            return "Approved";
        }
        return  "Failed";
    }
    //El promedio de la suma de todos los tps (excepto que sea TP final), osea .contains("TP ") pero !.contains("TP final")
}
//Map<String, List<Evaluation>> evaluationsPerSubject = student.getEvaluations();
//List<Evaluation> evaluations = evaluationsPerSubject.get(subject);
//        for (Evaluation evaluation : evaluations) {
//        if (evaluationName.contains(evaluation.getEvaluationName()))
//        }
//        return false;