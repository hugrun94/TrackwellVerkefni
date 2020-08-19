package com.example.demo.service;

import com.example.demo.entities.Position;
import com.example.demo.entities.Vessel;
import com.example.demo.repo.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepo positionRepo;
    public Position getByVesselId(int id) {
        List<Position> l = positionRepo.findAll();
        for(int i = 0;i<l.size();i++){
            if(l.get(i).getVessel().getId() == id){
                return l.get(i);
            }
        }
        return null;
    }

    public Boolean insert(Position position) {
        positionRepo.save(position);
        return true;
    }
}
