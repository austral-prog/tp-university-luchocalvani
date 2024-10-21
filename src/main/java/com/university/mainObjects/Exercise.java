package com.university.mainObjects;

public class Exercise {


    private String exerciseName;
    private String grade;

    public Exercise(String exerciseName, String grade) {
        this.exerciseName = exerciseName;
        this.grade = grade;
    }

    public String getExerciseName() {
        return exerciseName;
    }
    public String getGrade() {
        return grade;
    }
}
