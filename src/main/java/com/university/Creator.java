package com.university;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Creator {
    private static HashMap<String, Student> studentMap = new HashMap<>();
    private static HashMap<String, Course> courseMap = new HashMap<>();

    public Creator(String fileName) {
        CSVReader csvReader = new CSVReader(fileName);
        csvReader.read(",");
        List<String[]> allData = csvReader.getAllData();
        for (String[] data : allData) {
            String classroom = data[0];
            String subject = data[1];
            String studentName = data[2];
            String studentEmail = data[3];

            Course course = courseMap.computeIfAbsent(subject, k -> new Course(subject));
            course.addClassroom(classroom);

            Student student = studentMap.computeIfAbsent(studentName, k -> new Student(studentName, studentEmail));
            student.addCourse(course);
        }
    }
    public List<Student> getStudentlist(){
        List<Student> studentsList = new ArrayList<>();
        studentsList.addAll(studentMap.values());
        return studentsList;
    }
    public List<Course> getCourseslist(){
        List<Course> courseList = new ArrayList<>();
        courseList.addAll(courseMap.values());
        return courseList;
    }
}