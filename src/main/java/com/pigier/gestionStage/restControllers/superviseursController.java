package com.pigier.gestionStage.restControllers;


import com.pigier.gestionStage.entities.Superviseurs;
import com.pigier.gestionStage.services.superviseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superviseur")
public class superviseursController {
    private final superviseurService service;

    public superviseursController(superviseurService service) {
        this.service = service;
    }
    @PostMapping("/add")
    Superviseurs create(@RequestBody Superviseurs sup) {
        return service.create(sup);
    }
    @GetMapping("/liste")
    List<Superviseurs> getAll() {
        return service.liste();
    }
    @PutMapping("/update/{id}")
    Superviseurs update(@PathVariable Integer id, Superviseurs sup){
        return service.update(id,sup);
    }
    @DeleteMapping("/del/{id}")
    String delete(@PathVariable Integer id) {
        return service.delete(id);
    }
}
