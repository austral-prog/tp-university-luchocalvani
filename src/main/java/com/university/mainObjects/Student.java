package com.university.mainObjects;
import com.university.CLI.Entity;
import com.university.mainObjects.evaluation.Evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Student implements Entity {
    private String name;
    private String email;
    private HashMap<String, List<String>> courses;
    private HashMap<String, List<Evaluation>> evaluations;
    private int id;

    public Student(){}
    public Student(String name, String email){
        this.name = name;
        this.email = email;
        this.courses = new HashMap<>();
        this.evaluations = new HashMap<>();
    }

    public String getName(){
        return name;
    }

    public int getCoursesAmount(){
        return courses.size();
    }

    public void addCourse(String subject, String classroom){
        if(!courses.containsKey(subject)){
            courses.put(subject, new ArrayList<>());
            courses.get(subject).add(classroom);
        }
        else{
            courses.get(subject).add(classroom);
        }
    }
    public void addEvaluation(String subject, Evaluation evaluation){
        if (evaluations.containsKey(subject)){
            evaluations.get(subject).add(evaluation);
        }
        else{
            evaluations.put(subject, new ArrayList<>());
            evaluations.get(subject).add(evaluation);
        }
    }
    public Evaluation getEvaluation(String subject, String evaluationName, List<String> evaluationTypes){
        if (evaluations.containsKey(subject)){
            for(Evaluation evaluation : evaluations.get(subject)){
                for (String evaluationType : evaluationTypes){
                    if (evaluation.getEvaluationName().equals(evaluationName) && evaluation.getEvaluationType().equals(evaluationType)){
                        return evaluation;
                    }
                }
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student){
            if (((Student) obj).getName().equals(this.name)){
                return true;
            }
        }
        return false;
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
