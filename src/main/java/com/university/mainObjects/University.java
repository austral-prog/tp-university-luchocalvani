package com.university.mainObjects;

import com.university.mainObjects.criteria.Criteria;
import com.university.mainObjects.evaluation.Evaluation;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Evaluation> evaluationsList;
    private List<Student> studentsList;
    private List<Course> coursesList;
    private List<Criteria> criteriasList;

    public University(){
        studentsList = new ArrayList<>();
        evaluationsList = new ArrayList<>();
        coursesList = new ArrayList<>();
        criteriasList = new ArrayList<>();
    }
    public List<Student> getStudentsList(){
        return studentsList;
    }
    public List<Evaluation> getEvaluationsList(){
        return evaluationsList;
    }
    public List<Course> getCoursesList(){
        return coursesList;
    }
    public List<Criteria> getCriteriasList(){
        return criteriasList;
    }
    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }
    public void setEvaluationsList(List<Evaluation> evaluationsList) {
        this.evaluationsList = evaluationsList;
    }
    public void setCoursesList(List<Course> coursesList) {
        this.coursesList = coursesList;
    }
    public void setCriteriasList(List<Criteria> criteriasList) {
        this.criteriasList = criteriasList;
    }
    public Student getStudent(String studentName){
        for (Student student : studentsList){
            if (student.getName().equals(studentName)){
                return student;
            }
        }
        return null;
    }
//    public Course getCourse(String subject){
//        for (Course course : coursesList){
//            if (course.getSubject().equals(subject)){
//                return course;
//            }
//        }
//        return null;
//    }
//    public Evaluation getEvaluation(String studentName, String subject, String evaluationType, String evaluationName){
//        for (Evaluation evaluation : evaluationsList){
//            if (evaluation.getStudentName().equals(studentName) && evaluation.getSubject().equals(subject) && evaluation.getEvaluationType().equals(evaluationType)){
//                return evaluation;
//            }
//        }
//        return null;
//    }
}
