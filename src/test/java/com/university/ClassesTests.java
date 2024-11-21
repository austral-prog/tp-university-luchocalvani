package com.university;
import com.university.creators.CriteriasCreator;
import com.university.creators.EvaluationsCreator;
import com.university.creators.StudentsCoursesCreator;
import com.university.mainObjects.Course;
import com.university.mainObjects.Student;
import com.university.mainObjects.University;
import com.university.specificData.DataCreators.Solution1DataCreator;
import com.university.specificData.DataCreators.Solution2DataCreator;
import com.university.specificData.DataCreators.Solution3DataCreator;
import com.university.specificData.Sorters.EvaluationSorter;
import com.university.specificData.Sorters.StudentSorter;
import org.junit.jupiter.api.Test;

public class ClassesTests {

    University university = new University();

    Course course1 = new Course("Math");
    Course course2 = new Course("Prog");
    Course course3 = new Course("Biology");

    Student student1 = new Student("Juan Longo", "jlongo@gmail.com");
    Student student2 = new Student("Seba Igles", "sIgles@gmail.com");
    Student student3 = new Student("Mati Miodo", "mMiodo@gmail.com");

    StudentsCoursesCreator studentsCoursesCreator = new StudentsCoursesCreator("src/main/resources/input.csv");
    EvaluationsCreator evaluationsCreator = new EvaluationsCreator("src/main/resources/input_2.csv");
    CriteriasCreator criteriasCreator = new CriteriasCreator("src/main/resources/input_3.csv");
    StudentSorter ss = new StudentSorter(studentsCoursesCreator.getStudentlist());
    EvaluationSorter es = new EvaluationSorter(evaluationsCreator.getEvaluationsList());
    Solution1DataCreator sdc1 = new Solution1DataCreator(ss.getOrderedItems());
    Solution2DataCreator sdc2 = new Solution2DataCreator(es.getOrderedItems());

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
    public void getNameTest(){
        assert student1.getName().equals("Juan Longo");
        assert student2.getName().equals("Seba Igles");
        assert student3.getName().equals("Mati Miodo");
    }

    @Test
    public void StudentsCreatorTest(){
        assert studentsCoursesCreator.getStudentlist().get(1).getName().equals("Sam Green");
    }

    @Test
    public void CoursesCreatorTest(){
        assert studentsCoursesCreator.getCoursesList().get(1).getSubject().equals("Economics");
    }

    @Test
    public void EvaluationCreatorTest(){
        assert evaluationsCreator.getEvaluationsList().get(1).getSubject().equals("Geography");
        assert evaluationsCreator.getEvaluationsList().get(1).getEvaluationName().equals("TP3");
        assert evaluationsCreator.getEvaluationsList().get(1).getStudentName().equals("Hank Yellow");
        assert evaluationsCreator.getEvaluationsList().get(1).getEvaluationType().equals("PRACTICAL_WORK");
    }

    @Test
    public void CriteriaCreatorTest(){
        assert criteriasCreator.getCriteriasList().get(1).getSubject().equals("Geography");
        assert criteriasCreator.getCriteriasList().get(1).getEvaluationNames().get(1).equals("TP4");
    }

    @Test
    public void StudentsSorterTest(){
        assert ss.getOrderedItems().get(1).getName().equals("Alice Beige");
    }

    @Test
    public void EvaluationSorterTest(){
        assert es.getOrderedItems().get(1).getSubject().equals("Art");
    }

    @Test
    public void Solution1DataCreatorTest(){
        assert sdc1.getFileData().get(1)[0].equals("Alice Beige");
    }

    @Test
    public void Solution2DataCreatorTest(){
        assert sdc2.getFileData().get(1)[0].equals("Art");
    }

    @Test
    public void SetAndGetStudentsListToUniversityTest(){
        university.setStudentsList(ss.getOrderedItems());
        assert university.getStudentsList().get(1).getName().equals("Alice Beige");
    }

    @Test
    public void SetAndGetCoursesListToUniversityTest(){
        university.setCoursesList(studentsCoursesCreator.getCoursesList());
        assert university.getCoursesList().get(1).getSubject().equals("Economics");
    }

    @Test
    public void SetAndGetEvaluationsListToUniversityTest(){
        university.setEvaluationsList(es.getOrderedItems());
        assert university.getEvaluationsList().get(1).getSubject().equals("Art");
    }

    @Test
    public void SetAndGetCriteriaListToUniversityTest(){
        university.setCriteriasList(criteriasCreator.getCriteriasList());
        assert university.getCriteriasList().get(1).getSubject().equals("Geography");
    }

    @Test
    public void Solution3DataCreatorTest(){
        University uni = new University();
        uni.setCoursesList(studentsCoursesCreator.getCoursesList());
        uni.setStudentsList(ss.getOrderedItems());
        uni.setCriteriasList(criteriasCreator.getCriteriasList());
        uni.setEvaluationsList(es.getOrderedItems());
        Solution3DataCreator sdc3 = new Solution3DataCreator(uni);
        assert sdc3.getFileData().get(1)[1].equals("Alice Beige");
        assert sdc3.getFileData().get(1)[3].equals("Failed");
    }
}
