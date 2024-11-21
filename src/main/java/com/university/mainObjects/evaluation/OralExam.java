package com.university.mainObjects.evaluation;

public class OralExam extends Evaluation {
    public OralExam(String studentName, String subject, String evaluationType, String evaluationName) {
        super(studentName, subject, evaluationType, evaluationName);
    }

    @Override
    public void calculateFinalGrade() {
        finalGrade = Double.parseDouble(exercises.getFirst().getGrade());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {

    }
}
