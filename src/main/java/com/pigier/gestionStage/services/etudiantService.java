package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.etudiants;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

public interface etudiantService {
    etudiants create(etudiants etudiant);
    List<etudiants> liste();
    etudiants listeid(Integer id);
    etudiants etudid(Integer id);
    etudiants update(Integer id,etudiants etudiant);
    String delete(Integer id);
    void addStageToEtudiants(Integer etudiantId, Integer stageId);
}
