package com.university;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVReader {

    private String filename;
    private String line;
    private HashMap<String, Student> studentMap = new HashMap<>();
    private HashMap<String, Course> courseMap = new HashMap<>();

    public CSVReader(String filename) {
        this.filename = filename;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            line = br.readLine();
            while ((line = br.readLine())!= null) {
                String[] data = line.split(",");
                String classroom = data[0];
                String subject = data[1];
                String studentName = data[2];
                String studentEmail = data[3];
                String teacher = data[4];

                Course course = courseMap.computeIfAbsent(subject, k -> new Course(subject));
                course.addClassroom(classroom);
                Student student = studentMap.computeIfAbsent(studentName, k -> new Student(studentName, studentEmail));
                student.addCourse(course);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
