package com.university.CLI.CRUDRepositories;

import com.university.CLI.Entity;
import com.university.mainObjects.evaluation.Evaluation;
import com.university.CLI.exceptions.EntityNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class EvaluationRepository implements CRUDRepository<Evaluation> {
    private final Map<Integer, Evaluation> evaluations = new HashMap<>();

    @Override
    public void create(Evaluation evaluation) {
        if (evaluations.containsKey(evaluation.getId())) {
            throw new IllegalArgumentException("Evaluation ID " + evaluation.getId() + " already exists.");
        }
        evaluations.put(evaluation.getId(), evaluation);
    }

    @Override
    public Evaluation read(int id) {
        Evaluation evaluation = evaluations.get(id);
        if (evaluation == null) {
            throw new EntityNotFoundException("Evaluation with ID " + id + " not found.");
        }
        return evaluation;
    }

    @Override
    public void update(int id, Evaluation evaluation) {
        if (!evaluations.containsKey(id)) {
            throw new EntityNotFoundException("Evaluation with ID " + id + " not found.");
        }
        evaluations.put(id, evaluation);
    }

    @Override
    public void delete(int id) {
        if (!evaluations.containsKey(id)) {
            throw new EntityNotFoundException("Evaluation with ID " + id + " not found.");
        }
        evaluations.remove(id);
    }

    @Override
    public String getIdentifier() {
        return "Evaluation";
    }

    @Override
    public Class<Evaluation> getEntityClass() {
        return Evaluation.class;
    }
}
