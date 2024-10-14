package com.university;
import org.junit.jupiter.api.Test;

public class ClassesTests {

    Course course1 = new Course("Math");
    Course course2 = new Course("Prog");
    Course course3 = new Course("Biology");

    Student student1 = new Student("Juan Longo", "jlongo@gmail.com");
    Student student2 = new Student("Seba Igles", "sIgles@gmail.com");
    Student student3 = new Student("Mati Miodo", "mMiodo@gmail.com");

    CSVReader csvReader = new CSVReader("src/main/resources/input.csv");

    @Test
    public void addClassroomTest() {
        course1.addClassroom("123");
        course1.addClassroom("123");
        course1.addClassroom("321");
        course2.addClassroom("456");
        course3.addClassroom("789");
        course3.addClassroom("342");
        course3.addClassroom("567");

        assert course1.getClassrooms().contains("123");
        assert course1.getClassrooms().contains("321");
        assert course1.getClassroomsAmount() == 2;
        assert course2.getClassrooms().contains("456");
        assert course3.getClassroomsAmount() == 3;
    }
    @Test
    public void getSubjectTest(){
        assert course1.getSubject().equals("Math");
        assert course2.getSubject().equals("Prog");
        assert course3.getSubject().equals("Biology");
    }
    @Test
    public void addCourseTest() {
        student1.addCourse(course1);
        student1.addCourse(course1);
        student2.addCourse(course2);
        student3.addCourse(course2);
        student3.addCourse(course3);

        assert student1.getCourses().contains(course1);
        assert student1.getCoursesAmount() == 1;
        assert !student2.getCourses().contains(course1);
        assert student2.getCoursesAmount() == 1;
        assert student3.getCoursesAmount() == 2;
    }
    @Test
    public void getNameTest(){
        assert student1.getName().equals("Juan Longo");
        assert student2.getName().equals("Seba Igles");
        assert student3.getName().equals("Mati Miodo");
    }
    @Test
    public void getStudentListTest() {
        assert csvReader.getStudentlist().size() == 400;
    }
    @Test
    public void getCoursesListTest(){
        assert csvReader.getCourseslist().size() == 20;
    }
}
