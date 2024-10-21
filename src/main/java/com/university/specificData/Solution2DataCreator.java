package com.university.specificData;

import com.university.mainObjects.Evaluation;
import com.university.mainObjects.Exercise;
import com.university.mainObjects.Student;

import java.util.ArrayList;
import java.util.List;

public class Solution2DataCreator {

    List<String[]> fileData = new ArrayList<>();

    public Solution2DataCreator(List<Student> students){
        for (Student student : students){
            String name = student.getName();
            List<Evaluation> evaluations = student.getEvaluations();
            for (Evaluation evaluation : evaluations){
                String subject = evaluation.getSubject();
                String evaluationName = evaluation.getEvaluationName();
                List<Exercise> exercises = evaluation.getExercises();
                int gradeSum = 0;
                int i = 0;
                for (Exercise exercise : exercises){
                    gradeSum += Integer.parseInt(exercise.getGrade());
                    i++;
                }
                String totalGrade = String.valueOf(gradeSum/i);
                fileData.add(new String[] {name, evaluationName, subject, totalGrade});
            }
        }
    }
    public List<String[]> getFileData(){
        return fileData;
    }
}
