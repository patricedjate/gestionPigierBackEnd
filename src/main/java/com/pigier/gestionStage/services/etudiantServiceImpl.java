package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.etudiants;
import com.pigier.gestionStage.entities.stages;
import com.pigier.gestionStage.repositories.etudiantsRepository;
import com.pigier.gestionStage.repositories.stageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class etudiantServiceImpl implements etudiantService {
    private final etudiantsRepository repo;
    private final stageRepository stageRepo;

    public etudiantServiceImpl(etudiantsRepository repo, stageRepository stageRepo) {
        this.repo = repo;
        this.stageRepo = stageRepo;
    }

    @Override
    public etudiants create(etudiants etudiant) {
        return repo.save(etudiant);
    }

    @Override
    public List<etudiants> liste() {

        return repo.findAll();
    }

    @Override
    public etudiants update(Integer id, etudiants etudiant) {
        return repo.findById(id).map(
                p->{
                    p.setNom(p.getNom());
                    p.setPrenom(p.getPrenom());
                    p.setEmail(p.getEmail());
                    p.setDate_naissance(p.getDate_naissance());
                    p.setNiveau_etude(p.getNiveau_etude());
                    p.setTelephone(p.getTelephone());
                    p.setUniversite(p.getUniversite());
                    p.setStage(p.getStage());
                    return repo.save(p);
                }
        ).orElseThrow();
    }

    @Override
    public String delete(Integer id) {
        repo.deleteById(id);
        return "élement supprimé avec succès";
    }

    @Override
    public void addStageToEtudiants(Integer etudiantId, Integer stageId) {
        etudiants etudiant = repo.findById(etudiantId).orElseThrow();
        stages stage = stageRepo.findById(stageId).orElseThrow();
        etudiant.getStage().add(stage);
    }
}
