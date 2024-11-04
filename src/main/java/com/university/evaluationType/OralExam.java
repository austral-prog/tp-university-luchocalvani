package com.university.evaluationType;

import com.university.mainObjects.Evaluation;

public class OralExam extends Evaluation {
    public OralExam(String studentName, String subject, String evaluationType, String evaluationName) {
        super(studentName, subject, evaluationType, evaluationName);
    }

    @Override
    public void calculateFinalGrade() {
        finalGrade = Double.parseDouble(exercises.getFirst().getGrade());
    }
}
