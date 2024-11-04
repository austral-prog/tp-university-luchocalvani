package com.university.mainObjects;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Student {
    private String name;
    private String email;
    private HashMap<String, List<String>> courses;
    private HashMap<String, List<Evaluation>> evaluations;

    public Student(String name, String email){
        this.name = name;
        this.email = email;
        this.courses = new HashMap<>();
        this.evaluations = new HashMap<>();
    }

    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public HashMap<String, List<String>> getCourses(){
        return courses;
    }
    public int getCoursesAmount(){
        return courses.size();
    }
    public HashMap<String, List<Evaluation>> getEvaluations(){
        return evaluations;
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
    }
    @Override
    public String toString() {
        return name;
    }
}
