package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.evaluations;

import java.util.List;

public interface evaluationsService {
    evaluations create(evaluations evaluation);
    evaluations update(Integer id, evaluations evaluation);
    List<evaluations> liste();
    String  delete(Integer id);
    void addApplicationToEvaluation(Integer evaluationId, Integer applicationId);
}
