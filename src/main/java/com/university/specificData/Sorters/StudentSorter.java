package com.university.specificData.Sorters;

import com.university.mainObjects.Student;

import java.util.Comparator;
import java.util.List;

public class StudentSorter implements Sortable<Student>{

    private List<Student> orderedStudents;

    public StudentSorter(List<Student> students) {
        sort(students);
    }

    @Override
    public void sort(List<Student> students) {
        students.sort(Comparator.comparing(Student::getName));
        this.orderedStudents = students;
    }
    @Override
    public List<Student> getOrderedItems() {
        return orderedStudents;
    }
}
