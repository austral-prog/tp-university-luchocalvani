package com.university.mainObjects;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> studentsList;

    public University(){
        studentsList = new ArrayList<>();
    }
    public List<Student> getStudentsList(){
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
    public Student getStudent(String studentName){
        for (Student student : studentsList){
            if (student.getName().equals(studentName)){
                return student;
            }
        }
        return null;
    }
}
