package com.university.specificData;

import com.university.mainObjects.Evaluation;

import java.util.Comparator;
import java.util.List;

public class EvaluationSorter {

    private List<Evaluation> orderedEvaluations;

    public EvaluationSorter(List<Evaluation> evaluations) {
        evaluations.sort(Comparator.comparing(Evaluation::getStudentName));
        evaluations.sort(Comparator.comparing(Evaluation::getEvaluationName));
        evaluations.sort(Comparator.comparing(Evaluation::getSubject));
        this.orderedEvaluations = evaluations;
    }
    public List<Evaluation> getOrderedEvaluations() {
        return orderedEvaluations;
    }
}
