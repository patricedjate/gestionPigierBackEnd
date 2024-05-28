package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.stages;

import java.util.List;

public interface stageService {
    stages create(stages stage);
    List<stages> liste();
    stages update(Integer id,stages stage);
    String delete(Integer id);
}
