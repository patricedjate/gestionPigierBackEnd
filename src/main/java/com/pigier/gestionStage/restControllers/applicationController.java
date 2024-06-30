package com.pigier.gestionStage.restControllers;


import com.pigier.gestionStage.entities.applications;
import com.pigier.gestionStage.services.applicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/application")
public class applicationController {
    private final applicationService service;

    public applicationController(applicationService service) {
        this.service = service;
    }
    @PostMapping("/add")
    applications create(@RequestBody applications app) {
        return service.create(app);
    }
    @GetMapping("/liste")
    List<applications> getAll() {
        return service.liste();
    }
    @PutMapping("/update/{id}")
    applications update(@PathVariable Integer id, applications app){
        return service.update(id,app);
    }
    @DeleteMapping("/del/{id}")
    String delete(@PathVariable Integer id) {
        return service.delete(id);
    }
    @PostMapping("/{etudiantId}/{stageId}/{applicationId}/")
    void addEtudiantAndStageToStage(@PathVariable Integer etudiantId, @PathVariable Integer stageId, @PathVariable Integer applicationId) {
        service.addEtudiantAndStageToApplication(etudiantId,stageId,applicationId);
    }
}
