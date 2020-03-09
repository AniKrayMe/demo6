package com.example.demo6.controller;

import com.example.demo6.animal.Animal;
import com.example.demo6.cage.Cage;
import com.example.demo6.service.AnimalService;
import com.example.demo6.service.CageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimalController {


    private final AnimalService animalService;
    private final CageService cageService;

    @Autowired
    public AnimalController(AnimalService animalService, CageService cageService) {
        this.animalService = animalService;
        this.cageService = cageService;
    }

    @PostMapping(value = "/animal/{id}")

    public void create(@PathVariable Long id,@RequestBody Animal animal) {
        animalService.createAnimal(animal, id);
    }

    @GetMapping(value = "/animal/{id}")
    public ResponseEntity<Animal> get(@PathVariable Long id) {
        Animal userByID = animalService.getById(id);
        return ResponseEntity.ok(userByID);
    }

    @PutMapping(value = "/animal/{id}")
    public void update(@PathVariable Long id, @RequestBody Animal animal) {
        animalService.updateAnimalById(id, animal);
    }

    @DeleteMapping(value = "/animal/{id}")
    public void delete(@PathVariable Long id) {
        animalService.deleteAnimalById(id);
    }
}
