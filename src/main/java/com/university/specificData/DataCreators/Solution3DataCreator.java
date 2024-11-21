package com.university.specificData.DataCreators;

import com.university.mainObjects.criteria.Criteria;
import com.university.mainObjects.Student;
import com.university.mainObjects.University;

import java.util.ArrayList;
import java.util.List;

public class Solution3DataCreator {

    List<String[]> fileData = new ArrayList<>();

    public Solution3DataCreator(University university){
        List<Criteria> criteriasList = university.getCriteriasList();
        List<Student> studentsList  = university.getStudentsList();
        for (Criteria criteria : criteriasList) {
            String subject = criteria.getSubject();
            List<String> evaluationNames = criteria.getEvaluationNames();
            for (Student student : studentsList) {
                String status = criteria.evaluate(student);
                String[] row = new String[]{subject, student.getName(), String.join(",", evaluationNames), status};
                fileData.add(row);
            }
        }
    }
    public List<String[]> getFileData() {
        return fileData;
    }
}
