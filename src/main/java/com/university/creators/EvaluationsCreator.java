package com.university.creators;
import com.university.CSV.CSVReader;
import com.university.mainObjects.evaluation.FinalPracticalWork;
import com.university.mainObjects.evaluation.OralExam;
import com.university.mainObjects.evaluation.PracticalWork;
import com.university.mainObjects.evaluation.WrittenExam;
import com.university.mainObjects.evaluation.Evaluation;
import com.university.mainObjects.evaluation.Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EvaluationsCreator {
    private static HashMap<String, Evaluation> evaluations = new HashMap<>();

    public EvaluationsCreator(String fileIn){
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

            Exercise exercise = new Exercise(exerciseName, grade);

            switch (evaluationType) {
                case "WRITTEN_EXAM" -> {
                    WrittenExam writtenExam = (WrittenExam) evaluations.computeIfAbsent(studentName + ":" + subject + ":" + evaluationType + ":" + evaluationName, k -> new WrittenExam(studentName, subject, evaluationType, evaluationName));
                    writtenExam.addExercises(exercise);
                }
                case "FINAL_PRACTICAL_WORK" -> {
                    FinalPracticalWork finalPracticalWork = (FinalPracticalWork) evaluations.computeIfAbsent(studentName + ":" + subject + ":" + evaluationType + ":" + evaluationName, k -> new FinalPracticalWork(studentName, subject, evaluationType, evaluationName));
                    finalPracticalWork.addExercises(exercise);
                }
                case "PRACTICAL_WORK" -> {
                    PracticalWork practicalWork = (PracticalWork) evaluations.computeIfAbsent(studentName + ":" + subject + ":" + evaluationType + ":" + evaluationName, k -> new PracticalWork(studentName, subject, evaluationType, evaluationName));
                    practicalWork.addExercises(exercise);
                }
                case "ORAL_EXAM" -> {
                    OralExam oralExam = (OralExam) evaluations.computeIfAbsent(studentName + ":" + subject + ":" + evaluationType + ":" + evaluationName, k -> new OralExam(studentName, subject, evaluationType, evaluationName));
                    oralExam.addExercises(exercise);
                }
            }
        }
    }
    public List<Evaluation> getEvaluationsList(){
        List<Evaluation> evaluationsList = new ArrayList<>();
        evaluationsList.addAll(evaluations.values());
        return evaluationsList;
    }
}
