package com.pigier.gestionStage.restControllers;

import com.pigier.gestionStage.entities.etudiants;
import com.pigier.gestionStage.services.etudiantService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class etudiantsController {
    private final etudiantService service;

    public etudiantsController(etudiantService service) {
        this.service = service;
    }
    @PostMapping("/add")
    etudiants create(@RequestBody etudiants etudiant) {
        return service.create(etudiant);
    }
    @GetMapping("/liste")
    List<etudiants> getAll() {
        return service.liste();
    }
    @GetMapping("/{id}")
    etudiants getbyId(@PathVariable int id) {
        return service.listeid(id);
    }
    @GetMapping("/getEtud/{id}")
    etudiants getbyUserId(@PathVariable int id) {
        return service.etudid(id);
    }
    @PutMapping("/update/{id}")
    etudiants update(@PathVariable Integer id, @RequestBody etudiants etudiant){
        return service.update(id,etudiant);
    }
    @DeleteMapping("/del/{id}")
    String delete(@PathVariable Integer id) {
        return service.delete(id);
    }
    @PostMapping("/{etudiantId}/{stageId}")
    void addStageToEtudiant(@PathVariable Integer etudiantId, @PathVariable Integer stageId) {
        service.addStageToEtudiants(etudiantId, stageId);
    }
}
