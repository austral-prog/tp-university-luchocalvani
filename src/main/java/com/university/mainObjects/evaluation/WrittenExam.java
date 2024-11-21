package com.university.mainObjects.evaluation;

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

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
