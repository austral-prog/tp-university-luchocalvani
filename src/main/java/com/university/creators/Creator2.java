package com.university.creators;
import com.university.CSV.CSVReader;
import com.university.mainObjects.Course;
import com.university.mainObjects.Evaluation;
import com.university.mainObjects.Exercise;
import com.university.mainObjects.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Creator2 {
    private static HashMap<String, Student> students = new HashMap<>();
    private static HashMap<String, Evaluation> evaluations = new HashMap<>();

    public Creator2(String fileIn){
        CSVReader csv = new CSVReader(fileIn);
        csv.read(",");
        List<String[]> allData = csv.getAllData();
        for(String[] data : allData){
            String studentName = data[0];
            String subject = data[1];
            String evaluationType = data[2];
            String evaluationName = data[3];
            String exerciseName = data[4];
            String grade = data[5];

            Evaluation evaluation = evaluations.computeIfAbsent(studentName +":"+ subject +":"+ evaluationType +":"+ evaluationName, k-> new Evaluation(studentName, subject, evaluationType, evaluationName));

            Exercise exercise = new Exercise(exerciseName, grade);
            evaluation.addExercises(exercise);

            Student student = students.computeIfAbsent(studentName, k-> new Student(studentName, null));
            if (!student.getEvaluations().contains(evaluation)){
                student.addEvaluation(evaluation);
            }
        }
    }
    public List<Student> getStudentList(){
        List<Student> studentsList = new ArrayList<>();
        studentsList.addAll(students.values());
        return studentsList;
    }
}
