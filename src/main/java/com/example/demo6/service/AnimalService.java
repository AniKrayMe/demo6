package com.example.demo6.service;

import com.example.demo6.animal.Animal;
import com.example.demo6.cage.Cage;
import com.example.demo6.persistance.repository.AnimalRepository;
import com.example.demo6.persistance.repository.CageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final CageRepository cageRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository, CageRepository cageRepository) {
        this.animalRepository = animalRepository;
        this.cageRepository = cageRepository;
    }
    public boolean createAnimal(Animal animal, Long id){
        Cage cage = cageRepository.findById(id).get();
        animal.setCage(cage);
        animalRepository.save(animal);

        return true;
    }
    public Animal getById(Long id){
        return animalRepository.findById(id).get();
    }

    public boolean updateAnimalById(Long id, Animal animal){
        Animal toUpdate = animalRepository.findById(id).get();
        toUpdate.setAnimalTypes(animal.getAnimalTypes());
        animalRepository.save(toUpdate);
        deleteAnimalById(id);
        return true;
    }

    public boolean deleteAnimalById(Long id){
        animalRepository.deleteById(id);
        return true;
    }
}

