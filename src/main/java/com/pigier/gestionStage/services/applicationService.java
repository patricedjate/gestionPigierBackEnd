package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.applications;

import java.util.List;

public interface applicationService {
    applications create(applications application);
    List<applications> liste();
   applications update(Integer id,applications application);
    String delete(Integer id);
    void addEtudiantAndStageToApplication(Integer etudiantId, Integer stageId,Integer applicationId);
}
