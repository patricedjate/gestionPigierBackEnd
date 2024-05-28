package com.pigier.gestionStage.restControllers;


import com.pigier.gestionStage.entities.evaluations;
import com.pigier.gestionStage.services.evaluationsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/evaluation")
public class evaluationsController {
    private final evaluationsService service;

    public evaluationsController(evaluationsService service) {
        this.service = service;
    }
    @PostMapping("/add")
    evaluations create(@RequestBody evaluations eva) {
        return service.create(eva);
    }
    @GetMapping("/liste")
    List<evaluations> getAll() {
        return service.liste();
    }
    @PutMapping("/update/{id}")
    evaluations update(@PathVariable Integer id, evaluations  eva){
        return service.update(id,eva);
    }
    @DeleteMapping("/del/{id}")
    String delete(@PathVariable Integer id) {
        return service.delete(id);
    }
}
