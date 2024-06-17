package com.pigier.gestionStage.restControllers;


import com.pigier.gestionStage.entities.stages;

import com.pigier.gestionStage.services.stageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/stage")
public class stageController {
    private final stageService service;

    public stageController(stageService service) {
        this.service = service;
    }
    @PostMapping("/add")
    stages create(@RequestBody stages stage) {
        return service.create(stage);
    }
    @GetMapping("/liste")
    List< stages> getAll() {
        return service.liste();
    }
    @PutMapping("/update/{id}")
    stages update(@PathVariable Integer id,  stages  stage){
        return service.update(id,stage);
    }
    @DeleteMapping("/del/{id}")
    String delete(@PathVariable Integer id) {
        return service.delete(id);
    }
    @GetMapping("/liste/{domaine}")
    List<stages> getAllByDomaine(@PathVariable String domaine) {
        return service.stageByDomaine(domaine);
    }

}
