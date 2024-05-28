package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.Superviseurs;

import java.util.List;

public interface superviseurService {
    Superviseurs create(Superviseurs sup);
    List<Superviseurs> liste();
    Superviseurs update(Integer id,Superviseurs sup);
    String delete(Integer id);
    void addEntrepriseToSuperviseurs(Integer superviseurid, Integer entrepriseId);
}
