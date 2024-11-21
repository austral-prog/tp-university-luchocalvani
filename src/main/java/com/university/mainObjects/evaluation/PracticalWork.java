package com.university.mainObjects.evaluation;

public class PracticalWork extends Evaluation {
    public PracticalWork(String studentName, String subject, String evaluationType, String evaluationName) {
        super(studentName, subject, evaluationType, evaluationName);
    }

    @Override
    public void calculateFinalGrade() {
        finalGrade = Double.parseDouble(exercises.getLast().getGrade());
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
