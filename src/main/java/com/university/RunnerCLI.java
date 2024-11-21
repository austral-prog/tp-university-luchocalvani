package com.university;

import com.university.CLI.CLI;
import com.university.CLI.CRUDRepositories.*;
import com.university.mainObjects.Course;
import com.university.mainObjects.Student;
import com.university.mainObjects.evaluation.Evaluation;

public class RunnerCLI {
    public static void main(String[] args) {
        CRUDRepository<Student> studentRepo = new StudentRepository();
        CRUDRepository<Course> courseRepo = new CourseRepository();
        CRUDRepository<Evaluation> evaluationRepo = new EvaluationRepository();
        CLI cli = new UniversityCLI();
        cli.runCLI(new CRUDRepository[]{studentRepo, courseRepo, evaluationRepo});
    }
}
