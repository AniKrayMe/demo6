package com.example.demo6.controller;

import com.example.demo6.cage.Cage;
import com.example.demo6.service.CageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class CageController {

    private final CageService cageService;

    @Autowired
    public CageController(CageService cageService) {
        this.cageService = cageService;
    }

    @PostMapping(value = "/cage")
    public void create(@RequestBody Cage cage) {
        cageService.createCage(cage);
    }

    @GetMapping(value = "/cage/{id}")
    public ResponseEntity<Cage> get(@PathVariable Long id) {
        Cage userByID = cageService.getById(id);
        return ResponseEntity.ok(userByID);
    }

    @PutMapping(value = "/cage/{id}")
    public void update(@PathVariable Long id, @RequestBody Cage cage) {
        cageService.updateCageById(id, cage);
    }

    @DeleteMapping(value = "/cage/{id}")
    public void delete(@PathVariable Long id) {
        cageService.deleteCageById(id);
    }
}
