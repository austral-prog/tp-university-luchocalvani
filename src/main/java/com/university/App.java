package com.university;

import com.university.CLI.CLI;
import com.university.CLI.CRUDRepositories.*;
import com.university.CSV.CSVWriter;
import com.university.creators.StudentsCoursesCreator;
import com.university.creators.EvaluationsCreator;
import com.university.creators.CriteriasCreator;
import com.university.mainObjects.Course;
import com.university.mainObjects.Student;
import com.university.mainObjects.evaluation.Evaluation;
import com.university.mainObjects.University;
import com.university.specificData.DataCreators.Solution2DataCreator;
import com.university.specificData.DataCreators.Solution3DataCreator;
import com.university.specificData.DataCreators.Solution1DataCreator;
import com.university.specificData.Sorters.EvaluationSorter;
import com.university.specificData.Sorters.StudentSorter;

public class App {
    public static void main(String[] args) {

        String[] header1 = {"Student_Name", "Course_Count"};
        String fileIn1 = "src/main/resources/input.csv";
        String fileOut1 = "src/main/resources/solution.csv";

        University university = new University();

        StudentsCoursesCreator studentsCoursesCreator = new StudentsCoursesCreator(fileIn1);
        Solution1DataCreator sdt = new Solution1DataCreator(studentsCoursesCreator.getStudentlist());
        StudentSorter ss = new StudentSorter(studentsCoursesCreator.getStudentlist());

        university.setStudentsList(ss.getOrderedItems());
        university.setCoursesList(studentsCoursesCreator.getCoursesList());

        CSVWriter csvWriter1 = new CSVWriter(header1, fileOut1, sdt.getFileData());
        csvWriter1.write(",");

        String[] header2 = {"Subject_Name","Evaluation_Name","Student_Name","Grade"};
        String fileIn2 = "src/main/resources/input_2.csv";
        String fileOut2 = "src/main/resources/solution2.csv";

        EvaluationsCreator evaluationsCreator = new EvaluationsCreator(fileIn2);
        Solution2DataCreator sdt2 = new Solution2DataCreator(evaluationsCreator.getEvaluationsList());
        EvaluationSorter es = new EvaluationSorter(evaluationsCreator.getEvaluationsList());

        university.setEvaluationsList(es.getOrderedItems());
        for (Evaluation evaluation : university.getEvaluationsList()) {
            evaluation.calculateFinalGrade();
            String studentName = evaluation.getStudentName();
            university.getStudent(studentName).addEvaluation(evaluation.getSubject(), evaluation);
        }

        CSVWriter csvWriter2 = new CSVWriter(header2, fileOut2, sdt2.getFileData());
        csvWriter2.write(",");

        String[] header3 = {"Subject_Name","Student_Name","Evaluation_Name","Status"};
        String fileIn3 = "src/main/resources/input_3.csv";
        String fileOut3 = "src/main/resources/solution3.csv";

        CriteriasCreator criteriasCreator = new CriteriasCreator(fileIn3);
        university.setCriteriasList(criteriasCreator.getCriteriasList());
        Solution3DataCreator s3dt = new Solution3DataCreator(university);

        CSVWriter csvWriter3 = new CSVWriter(header3, fileOut3, s3dt.getFileData());
        csvWriter3.write(",");
    }
}
