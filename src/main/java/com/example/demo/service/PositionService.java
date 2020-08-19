package com.example.demo.service;

import com.example.demo.entities.Position;

public interface PositionService {
    Position getByVesselId(int id);
    Boolean insert(Position position);
}
