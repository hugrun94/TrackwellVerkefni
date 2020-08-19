package com.example.demo.repo;

import com.example.demo.entities.Vessel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VesselRepo extends JpaRepository<Vessel, Integer> {
}
