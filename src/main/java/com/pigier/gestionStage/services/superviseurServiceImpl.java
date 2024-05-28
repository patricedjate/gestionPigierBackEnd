package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.Superviseurs;
import com.pigier.gestionStage.entities.entreprises;
import com.pigier.gestionStage.repositories.entreprisesRepository;
import com.pigier.gestionStage.repositories.superviseursRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class superviseurServiceImpl implements superviseurService {
    private final superviseursRepository repo;
    private final entreprisesRepository entrepriseRepository;

    public superviseurServiceImpl(superviseursRepository repo, entreprisesRepository entrepriseRepository) {
        this.repo = repo;
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public Superviseurs create(Superviseurs etudiant) {
        return repo.save(etudiant);
    }

    @Override
    public List<Superviseurs> liste() {
        return repo.findAll();
    }

    @Override
    public Superviseurs update(Integer id, Superviseurs etudiant) {
        return repo.findById(id).map(
                p->{
                    p.setNom(p.getNom());
                    p.setPrenom(p.getPrenom());
                    p.setEmail(p.getEmail());
                    p.setTelephone(p.getTelephone());
                    p.setEntreprise(p.getEntreprise());
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
    public void addEntrepriseToSuperviseurs(Integer superviseurid, Integer entrepriseId) {
        Superviseurs sup=repo.findById(superviseurid).orElseThrow();
        entreprises ent = entrepriseRepository.findById(entrepriseId).orElseThrow();
        sup.getEntreprise().add(ent);
    }
}
