package com.university.evaluationType;

import com.university.mainObjects.Evaluation;
import com.university.mainObjects.Exercise;

public class WrittenExam extends Evaluation {

    public WrittenExam(String studentName, String subject, String evaluationType, String evaluationName) {
        super(studentName, subject, evaluationType, evaluationName);
    }


    @Override
    public void calculateFinalGrade() {
        int i = 0;
        for (Exercise exercise: exercises) {
            i++;
            finalGrade += Double.parseDouble(exercise.getGrade());
        }
        finalGrade = finalGrade/i;
    }
}
