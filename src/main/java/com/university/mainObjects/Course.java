package com.university.mainObjects;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private String subject;
    private List<String> classrooms;

    public Course(String subject) {
        this.subject = subject;
        this.classrooms = new ArrayList<>();
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
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void addClassroom(String classroom) {
        if (!this.classrooms.contains(classroom)) {
            this.classrooms.add(classroom);
        }
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
}
