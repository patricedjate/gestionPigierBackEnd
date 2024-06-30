package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.etudiants;
import com.pigier.gestionStage.entities.stages;
import com.pigier.gestionStage.repositories.etudiantsRepository;
import com.pigier.gestionStage.repositories.stageRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class etudiantServiceImpl implements etudiantService {
    private final etudiantsRepository repo;
    private final stageRepository stageRepo;
    private final PasswordEncoder passwordEncoder;

    public etudiantServiceImpl(etudiantsRepository repo, stageRepository stageRepo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.stageRepo = stageRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public etudiants create(etudiants etudiant) {
        String password = etudiant.getUser().getPassword();
        etudiant.getUser().setPassword(passwordEncoder.encode(password));
        return repo.save(etudiant);
    }

    @Override
    public List<etudiants> liste() {

        return repo.findAll();
    }

    @Override
    public etudiants listeid(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    @Override
    public etudiants etudid(Integer id) {
        return repo.findByUserId(id);
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
                    p.setDomaine(p.getDomaine());
                    p.setUser(p.getUser());
                    return repo.save(p);
                }
        ).orElseThrow(()->new RuntimeException("Aucun élément trouvé"));

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
