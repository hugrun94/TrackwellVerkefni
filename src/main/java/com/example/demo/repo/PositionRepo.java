package com.example.demo.repo;

import com.example.demo.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepo extends JpaRepository<Position, Integer> {
}
