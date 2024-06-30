package com.pigier.gestionStage.restControllers;

import com.pigier.gestionStage.entities.entreprises;

import com.pigier.gestionStage.services.entrepriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/entreprise")
public class entrepriseController {
    private final entrepriseService service;

    public entrepriseController(entrepriseService service) {
        this.service = service;
    }
    @PostMapping("/add")
    entreprises create(@RequestBody entreprises ent) {
        return service.create(ent);
    }
    @GetMapping("/liste")
    List<entreprises> getAll() {
        return service.liste();
    }
    @GetMapping("/getbyuserid/{id}")
    entreprises getByUserId(@PathVariable int id) {
        return service.getByUserId(id);
    }
    @PutMapping("/update/{id}")
    entreprises update(@PathVariable Integer id, entreprises  ent){
        return service.update(id,ent);
    }
    @DeleteMapping("/del/{id}")
    String delete(@PathVariable Integer id) {
        return service.delete(id);
    }
    @PostMapping("/{stageId}/{entrepriseId}")
    void add(@PathVariable Integer stageId, @PathVariable Integer entrepriseId) {
        service.addStageToEntreprise(stageId, entrepriseId);
    }
}
