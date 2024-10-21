package com.university;

import com.university.CSV.CSVWriter;
import com.university.creators.Creator2;
import com.university.specificData.Solution2DataCreator;

public class App {
    public static void main(String[] args) {

//        String[] header1 = {"Student_Name", "Course_Count"};
//        String fileIn1 = "src/main/resources/input.csv";
//        String fileOut1 = "src/main/resources/solution.csv";
//
//        CSVWriter csvWriter1 = new CSVWriter(header1, fileOut1, (new SolutionDataCreator(new Creator1(fileIn1).getStudentList())).getFileData());
//        csvWritter1.write(",");

        String[] header2 = {"Subject_Name","Evaluation_Name","Student_Name","Grade"};
        String fileIn2 = "src/main/resources/input_2.csv";
        String fileOut2 = "src/main/resources/solution2.csv";

        CSVWriter csvWritter2 = new CSVWriter(header2, fileOut2, (new Solution2DataCreator(new Creator2(fileIn2).getStudentList())).getFileData());
        csvWritter2.write(",");}
}
