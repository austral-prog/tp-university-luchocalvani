package com.university.evaluationType;

import com.university.mainObjects.Evaluation;
import com.university.mainObjects.Exercise;

public class FinalPracticalWork extends Evaluation {
    public FinalPracticalWork(String studentName, String subject, String evaluationType, String evaluationName) {
        super(studentName, subject, evaluationType, evaluationName);
    }

    @Override
    public void calculateFinalGrade() {
        for (Exercise exercise: exercises) {
            finalGrade += Double.parseDouble(exercise.getGrade());
        }
    }
}
