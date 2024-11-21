package com.university.CLI.CRUDRepositories;

import com.university.CLI.Entity;
import com.university.CLI.exceptions.DuplicateEntityException;
import com.university.mainObjects.Student;
import com.university.CLI.exceptions.EntityNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class StudentRepository implements CRUDRepository<Student> {
    private final Map<Integer, Student> students;

    public StudentRepository() {
        students = new HashMap<>();
    }

    @Override
    public void create(Student student) {
        if (students.containsKey(student.getId())) {
            throw new DuplicateEntityException("ID " + student.getId() + " already exists.");
        }
        students.put(student.getId(), student);
    }

    @Override
    public Student read(int id) {
        Student student = students.get(id);
        if (student == null) {
            throw new EntityNotFoundException("Student with ID " + id + " not found.");
        }
        return student;
    }

    @Override
    public void update(int id, Student student) {
        if (!students.containsKey(id)) {
            throw new EntityNotFoundException("Student with ID " + id + " not found.");
        }
        students.put(id, student);
    }

    @Override
    public void delete(int id) {
        if (!students.containsKey(id)) {
            throw new EntityNotFoundException("Student with ID " + id + " not found.");
        }
        students.remove(id);
    }

    @Override
    public String getIdentifier() {
        return "Student";
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}

