package com.university;

import com.university.CSV.CSVWriter;
import com.university.creators.Creator1;
import com.university.creators.Creator2;
import com.university.mainObjects.University;
import com.university.specificData.EvaluationSorter;
import com.university.specificData.Solution2DataCreator;
import com.university.specificData.SolutionDataCreator;
import com.university.specificData.StudentSorter;

public class App {
    public static void main(String[] args) {

        String[] header1 = {"Student_Name", "Course_Count"};
        String fileIn1 = "src/main/resources/input.csv";
        String fileOut1 = "src/main/resources/solution.csv";

        University university = new University();

        Creator1 creator1 = new Creator1(fileIn1);
        SolutionDataCreator sdt = new SolutionDataCreator(creator1.getStudentlist());
        StudentSorter ss = new StudentSorter(creator1.getStudentlist());

        university.setStudentsList(ss.getOrderedStudents());

        System.out.println(university.getStudentsList().getFirst().getName());

        CSVWriter csvWriter1 = new CSVWriter(header1, fileOut1, sdt.getFileData());
        csvWriter1.write(",");

        String[] header2 = {"Subject_Name","Evaluation_Name","Student_Name","Grade"};
        String fileIn2 = "src/main/resources/input_2.csv";
        String fileOut2 = "src/main/resources/solution2.csv";

        Creator2 creator2 = new Creator2(fileIn2);
        Solution2DataCreator sdt2 = new Solution2DataCreator(creator2.getEvaluationsList());

        CSVWriter csvWriter2 = new CSVWriter(header2, fileOut2, sdt2.getFileData());
        csvWriter2.write(",");}
}
