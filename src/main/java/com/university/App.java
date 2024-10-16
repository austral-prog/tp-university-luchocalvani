package com.university;

public class App {
    public static void main(String[] args) {

        String[] header1 = {"Student_Name", "Course_Count"};
        String fileIn1 = "src/main/resources/input.csv";
        String fileOut1 = "src/main/resources/solution.csv";

        CSVWritter csvWritter = new CSVWritter(header1, fileOut1, (new SolutionDataCreator(new Creator(fileIn1).getStudentlist())).getFileData());
        csvWritter.write(",");
    }
}
