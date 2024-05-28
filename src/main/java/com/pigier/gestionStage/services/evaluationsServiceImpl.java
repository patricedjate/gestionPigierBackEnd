package com.pigier.gestionStage.services;

import com.pigier.gestionStage.entities.applications;
import com.pigier.gestionStage.entities.evaluations;
import com.pigier.gestionStage.repositories.applicationsRepository;
import com.pigier.gestionStage.repositories.evaluationsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public class evaluationsServiceImpl implements evaluationsService {
    private final evaluationsRepository repo;
    private final applicationsRepository applicationrepo;

    public evaluationsServiceImpl(evaluationsRepository repo, applicationsRepository applicationrepo) {
        this.repo = repo;
        this.applicationrepo = applicationrepo;
    }

    @Override
    public evaluations create(evaluations evaluation) {
        return repo.save(evaluation);
    }

    @Override
    public evaluations update(Integer id, evaluations evaluation) {
        return repo.findById(id).map(
                p->{
                    p.setCommentaire(p.getCommentaire());
                    p.setDate_evaluation(p.getDate_evaluation());
                    p.setCommentaire(p.getCommentaire());
                    p.setNote(p.getNote());
                    return repo.save(p);
                }).orElseThrow();

    }

    @Override
    public List<evaluations> liste() {

        return repo.findAll();
    }

    @Override
    public String delete(Integer id) {
        repo.deleteById(id);
        return "élément supprimé avec succès";
    }

    @Override
    public void addApplicationToEvaluation(Integer evaluationId, Integer applicationId) {
        evaluations evaluation = repo.findById(evaluationId).orElseThrow();
        applications application = applicationrepo.findById(applicationId).orElseThrow();
        evaluation.getApplication().add(application);
    }
}
