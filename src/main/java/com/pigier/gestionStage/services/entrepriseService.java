package com.pigier.gestionStage.services;



import com.pigier.gestionStage.entities.entreprises;

import java.util.List;

public interface entrepriseService {
    entreprises create(entreprises ent);
    List<entreprises> liste();
    entreprises update(Integer id, entreprises ent);
    entreprises getByUserId(Integer id);
    String delete(Integer id);
    void addStageToEntreprise(Integer stageId, Integer entrepriseId);

}
