package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.applications;
import com.pigier.gestionStage.entities.etudiants;
import com.pigier.gestionStage.entities.stages;
import com.pigier.gestionStage.repositories.applicationsRepository;
import com.pigier.gestionStage.repositories.etudiantsRepository;
import com.pigier.gestionStage.repositories.stageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class applicationServiceImpl implements applicationService {
    private final applicationsRepository repo;
    private final etudiantsRepository etudiantRepository;
    private final stageRepository stageRepository;

    public applicationServiceImpl(applicationsRepository repo, etudiantsRepository etudiantRepository, stageRepository stageRepository) {
        this.repo = repo;
        this.etudiantRepository = etudiantRepository;
        this.stageRepository = stageRepository;
    }

    @Override
    public applications create(applications application) {
        return repo.save(application);
    }

    @Override
    public List<applications> liste() {
        return repo.findAll();
    }

    @Override
    public applications update(Integer id, applications application) {
        return repo.findById(id).map(
                p->{
                    p.setDate_application(p.getDate_application());
                    p.setEtudiant(p.getEtudiant());
                    p.setStatut(p.getStatut());
                    p.setStage(p.getStage());
                    return repo.save(p);
                }
        ).orElseThrow();
    }

    @Override
    public String delete(Integer id) {
        repo.deleteById(id);
        return "élément supprimé avec succès";
    }

    @Override
    public void addEtudiantAndStageToApplication(Integer etudiantId, Integer stageId, Integer applicationId) {
        etudiants etud = etudiantRepository.findById(etudiantId).orElseThrow();
        stages stage = stageRepository.findById(stageId).orElseThrow();
        applications app = repo.findById(applicationId).orElseThrow();
        app.getStage().add(stage);
        app.getEtudiant().add(etud);

    }
}
