package com.example.demo.service;

import com.example.demo.entities.Vessel;

public interface VesselService {
    Boolean insert(Vessel vessel);
    Vessel get(int id);
    Vessel find(String name);


}
