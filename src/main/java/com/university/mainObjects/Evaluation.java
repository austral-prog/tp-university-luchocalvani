package com.university.mainObjects;
import java.util.ArrayList;
import java.util.List;


public abstract class Evaluation {
    protected String studentName;
    protected String subject;
    protected String evaluationType;
    protected String evaluationName;
    protected List<Exercise> exercises;
    protected Double finalGrade;


    public Evaluation(String studentName,String subject, String evaluationType, String evaluationName) {
        this.studentName = studentName;
        this.subject = subject;
        this.evaluationType = evaluationType;
        this.evaluationName = evaluationName;
        this.exercises = new ArrayList<>();
        this.finalGrade = 0.0;

    }
    public void addExercises(Exercise exercise) {
        exercises.add(exercise);
    }
    public String getSubject(){
        return subject;
    }
    public String getStudentName(){
        return studentName;
    }
    public String getEvaluationType() {
        return evaluationType;
    }
    public String getEvaluationName() {
        return evaluationName;
    }
    public List<Exercise> getExercises() {
        return exercises;
    }
    public abstract void calculateFinalGrade();

    public Double getFinalGrade() {
        return finalGrade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Evaluation){
            if (((Evaluation) obj).getEvaluationName().equals(evaluationName)){
                return (((Evaluation) obj).getSubject().equals(subject));
            }
        }
        return false;
    }
}

