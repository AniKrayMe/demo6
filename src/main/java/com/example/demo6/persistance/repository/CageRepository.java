package com.example.demo6.persistance.repository;

import com.example.demo6.cage.Cage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CageRepository extends JpaRepository<Cage, Long> {
}
