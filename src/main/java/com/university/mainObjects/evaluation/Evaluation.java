package com.university.mainObjects.evaluation;

import com.university.CLI.Entity;

import java.util.ArrayList;
import java.util.List;


public abstract class Evaluation implements Entity {
    protected String studentName;
    protected String subject;
    protected String evaluationType;
    protected String evaluationName;
    protected List<Exercise> exercises;
    protected Double finalGrade;
    protected int id;


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
    public abstract void calculateFinalGrade();

    public Double getFinalGrade() {
        return finalGrade;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Evaluation){
            if (((Evaluation) obj).getEvaluationName().equals(evaluationName)){
                if (((Evaluation) obj).getEvaluationType().equals(evaluationType)){
                    if (((Evaluation) obj).getStudentName().equals(studentName)){
                        if (((Evaluation) obj).getSubject().equals(subject)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}


