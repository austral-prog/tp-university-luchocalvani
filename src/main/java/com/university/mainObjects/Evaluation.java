package com.university.mainObjects;
import java.util.ArrayList;
import java.util.List;


public class Evaluation {
    private String uniqueKey;
    private String studentName;
    private String subject;
    private String evaluationType;
    private String evaluationName;
    private List<Exercise> exercises;


    public Evaluation(String studentName,String subject, String evaluationType, String evaluationName) {
        this.studentName = studentName;
        this.subject = subject;
        this.evaluationType = evaluationType;
        this.evaluationName = evaluationName;
        this.exercises = new ArrayList<>();
        this.uniqueKey = studentName +":"+ subject +":"+ evaluationType +":"+ evaluationName;

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


