package com.university.mainObjects;

import com.university.CLI.Entity;
import com.university.mainObjects.evaluation.Evaluation;

import java.util.ArrayList;
import java.util.List;

public class Course implements Entity {

    private String subject;
    private List<String> classrooms;
    private List<Student> students;
    private List<Evaluation> evaluations;
    private int id;

    public Course(){}
    public Course(String subject) {

        this.subject = subject;
        this.classrooms = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    public String getSubject() {
        return subject;
    }
    public List<String> getClassrooms() {
        return classrooms;
    }
    public int getClassroomsAmount() {
        return classrooms.size();
    }
    public List<Student> getStudents() {
        return students;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void addClassroom(String classroom) {
        if (!this.classrooms.contains(classroom)) {
            this.classrooms.add(classroom);
        }
    }

    public void addStudent(Student student) {
        if (!students.contains(student)){
            students.add(student);
        }
    }
    public void addEvaluation(Evaluation evaluation) {
        if (!evaluations.contains(evaluation)){
            evaluations.add(evaluation);
        }
    }
    public Student getStudent(String studentName) {
        for (Student student : students){
            if (student.getName().equals(studentName)){
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Course: " + subject + ", Classrooms: " + classrooms;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            return this.subject.equals(((Course) obj).subject);
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

    public void setName(String subject){
        this.subject = subject;
    }
}
