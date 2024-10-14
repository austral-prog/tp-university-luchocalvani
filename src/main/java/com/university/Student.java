package com.university;
import java.util.HashSet;
import java.util.Set;

public class Student {
    private String name;
    private String email;
    private Set<Course> courses;

    public Student(String name, String email){
        this.name = name;
        this.email = email;
        this.courses = new HashSet<>();
    }

    public String getEmail(){
        return email;
    }
    public String getName(){
        return name;
    }
    public Set<Course> getCourses(){
        return courses;
    }
    public int getCoursesAmount(){
        return courses.size();
    }
    public void addCourse(Course course){
        if (!courses.contains(course)){
            this.courses.add(course);
        }
    }
    @Override
    public String toString() {
        return name;
    }
}
