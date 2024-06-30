package com.pigier.gestionStage.repositories;

import com.pigier.gestionStage.entities.entreprises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface entreprisesRepository extends JpaRepository<entreprises, Integer> {
    public entreprises findByNom(String nom);
    public entreprises findByUserId(int userId);
}
