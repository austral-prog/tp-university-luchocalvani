package com.university.specificData.DataCreators;

import com.university.mainObjects.Student;
import com.university.specificData.Sorters.StudentSorter;

import java.util.ArrayList;
import java.util.List;

public class Solution1DataCreator {

    private List<String[]> fileData = new ArrayList<>();

    public Solution1DataCreator(List<Student> students) {
        StudentSorter sorter = new StudentSorter(students);
        List<Student> orderedStudents = sorter.getOrderedItems();
        for (Student student : orderedStudents) {
            String[] row = {student.getName(), String.valueOf(student.getCoursesAmount())};
            fileData.add(row);
        }
    }
    public List<String[]> getFileData() {
        return fileData;
    }
}
