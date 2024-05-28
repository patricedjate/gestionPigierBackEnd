package com.pigier.gestionStage.repositories;

import com.pigier.gestionStage.entities.stages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface stageRepository extends JpaRepository<stages,Integer> {
    public stages findByTitre(String titre);
}
