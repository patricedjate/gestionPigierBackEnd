package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.stages;
import com.pigier.gestionStage.repositories.stageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class stageServiceImpl implements stageService {
    private final stageRepository repo;

    public stageServiceImpl(stageRepository repo) {
        this.repo = repo;
    }

    @Override
    public stages create(stages stage) {
        return repo.save(stage);
    }

    @Override
    public List<stages> liste() {
        return repo.findAll();
    }

    @Override
    public stages update(Integer id, stages stage) {
        return repo.findById(id).map(
                p->{
                    p.setDate_debut(p.getDate_debut());
                    p.setDate_fin(p.getDate_fin());
                    p.setTitre(p.getTitre());
                    p.setDescription(p.getDescription());
                    p.setDomaine(p.getDomaine());
                    p.setLieu(p.getLieu());
                    return repo.save(p);
                }
        ).orElseThrow();
    }

    @Override
    public stages detail(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public String delete(Integer id) {
        repo.deleteById(id);
        return "élément supprimé avec succès";
    }

    @Override
    public List<stages> stageByDomaine(String domaine) {
        return repo.findByDomaine(domaine);
    }
}
