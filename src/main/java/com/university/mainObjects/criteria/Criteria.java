package com.university.mainObjects.criteria;

import com.university.mainObjects.Student;

import java.util.List;

public abstract class Criteria {

    protected String subject;
    protected String criteriaType;
    protected String criteriaValue;
    protected List<String> evaluationNames;

    public Criteria(String subject, String criteriaType, String criteriaValue, List<String> evaluationNames) {
        this.subject = subject;
        this.criteriaType = criteriaType;
        this.criteriaValue = criteriaValue;
        this.evaluationNames = evaluationNames;
    }
    public String getSubject() {
        return subject;
    }
//    public String getCriteriaType() {
//        return criteriaType;
//    }
//    public String getCriteriaValue() {
//        return criteriaValue;
//    }
    public List<String> getEvaluationNames() {
        return evaluationNames;
    }
    public abstract String evaluate(Student student);
}
