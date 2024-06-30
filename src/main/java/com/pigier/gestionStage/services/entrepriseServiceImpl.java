package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.entreprises;
import com.pigier.gestionStage.entities.stages;
import com.pigier.gestionStage.repositories.entreprisesRepository;
import com.pigier.gestionStage.repositories.stageRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
@Service
@Transactional
public class entrepriseServiceImpl implements entrepriseService {
    private final entreprisesRepository repo;
    private final stageRepository stageRepo;
    private final PasswordEncoder passwordEncoder;
    public entrepriseServiceImpl(entreprisesRepository repo, stageRepository stageRepo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.stageRepo = stageRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public entreprises create(entreprises ent) {
        String password = ent.getUser().getPassword();
        ent.getUser().setPassword(passwordEncoder.encode(password));
        return repo.save(ent);
    }

    @Override
    public List<entreprises> liste() {
        return repo.findAll();
    }

    @Override
    public entreprises update(Integer id, entreprises ent) {
        return repo.findById(id).map(
            p->{
                p.setNom(p.getNom());
                p.setTelephone(p.getTelephone());
                p.setEmail(p.getEmail());
                p.setAdresse(p.getAdresse());
                p.setSecteur_activite(p.getSecteur_activite());
                return repo.save(p);
            }
        ).orElse(null);
    }

    @Override
    public entreprises getByUserId(Integer id) {
        return repo.findByUserId(id);
    }

    @Override
    public String delete(Integer id) {
        repo.deleteById(id);
        return "élément supprimé avec succès";
    }

    @Override
    public void addStageToEntreprise(Integer stageId, Integer entrepriseId) {
        entreprises ent= repo.findById(entrepriseId).orElseThrow();
        stages stage = stageRepo.findById(stageId).orElseThrow();
        ent.getStage().add(stage);

    }

}
