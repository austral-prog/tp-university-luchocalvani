package com.university.specificData.Sorters;

import com.university.mainObjects.evaluation.Evaluation;

import java.util.Comparator;
import java.util.List;

public class EvaluationSorter implements Sortable<Evaluation>{

    private List<Evaluation> orderedEvaluations;

    public EvaluationSorter(List<Evaluation> evaluations) {
        sort(evaluations);
    }

    @Override
    public void sort(List<Evaluation> evaluations) {
        evaluations.sort(Comparator.comparing(Evaluation::getStudentName));
        evaluations.sort(Comparator.comparing(Evaluation::getEvaluationName));
        evaluations.sort(Comparator.comparing(Evaluation::getSubject));
        this.orderedEvaluations = evaluations;
    }

    @Override
    public List<Evaluation> getOrderedItems() {
        return orderedEvaluations;
    }
}
