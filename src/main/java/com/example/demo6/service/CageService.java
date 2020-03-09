package com.example.demo6.service;

import com.example.demo6.cage.Cage;
import com.example.demo6.persistance.repository.CageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CageService {

    private final CageRepository cageRepository;
    @Autowired
    public CageService(CageRepository cageRepository) {
        this.cageRepository = cageRepository;
    }
    public boolean createCage(Cage cage){
        cageRepository.save(cage);
        return true;
    }
    public Cage getById(Long id){
        return cageRepository.findById(id).get();
    }

    public boolean updateCageById(Long id, Cage cage){
        Cage toUpdate = cageRepository.findById(id).get();
        toUpdate.setSection(cage.getSection());
        cageRepository.save(toUpdate);
        deleteCageById(id);
        return true;
    }

    public boolean deleteCageById(Long id){
        cageRepository.deleteById(id);
        return true;
    }
}
