package com.example.demo.service;

import com.example.demo.entities.Vessel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.repo.VesselRepo;

import java.util.List;

@Repository
public class VesselServiceImpl implements VesselService{
    @Autowired
    VesselRepo vesselRepo;

    public Boolean insert(Vessel vessel) {
        System.out.println("yas");
        vesselRepo.save(vessel);
        return true;
    }

    public Vessel get(int id) {
       return vesselRepo.findById(id).get();

    }

    public Vessel find(String name) {
        List<Vessel> l = vesselRepo.findAll();
        for(int i = 0;i<l.size();i++){
            if(l.get(i).getName().equals(name)){
                return l.get(i);
            }
        }
        return null;
    }
}
