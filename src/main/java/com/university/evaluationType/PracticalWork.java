package com.university.evaluationType;

import com.university.mainObjects.Evaluation;

public class PracticalWork extends Evaluation {
    public PracticalWork(String studentName, String subject, String evaluationType, String evaluationName) {
        super(studentName, subject, evaluationType, evaluationName);
    }

    @Override
    public void calculateFinalGrade() {
        finalGrade = Double.parseDouble(exercises.getLast().getGrade());
    }
}
