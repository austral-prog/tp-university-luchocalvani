package com.university.mainObjects.evaluation;

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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
