package com.pigier.gestionStage.repositories;

import com.pigier.gestionStage.entities.etudiants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface etudiantsRepository extends JpaRepository<etudiants, Integer> {
    public etudiants findBynom(String nom);
}
