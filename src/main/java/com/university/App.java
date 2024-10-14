package com.university;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) {

        String[] headers = {"Student_Name", "Course_Count"};
        String fileOut = "src/main/resources/solution.CSV";
        String fileIn = "src/main/resources/input.CSV";

        CSVReader input = new CSVReader(fileIn);

        List<Student> studentsList = input.getStudentlist();
        studentsList.sort(Comparator.comparing(Student::getName));

        try {BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
            bw.write(String.join(",", headers));
            bw.newLine();
            int i = 0;
            for (Student student : studentsList) {
                i ++;
                String[] row = {student.getName(), String.valueOf(student.getCoursesAmount())};
                bw.write(String.join(",", row));
                if (studentsList.size() > i){
                    bw.newLine();
                }
            }
            bw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
