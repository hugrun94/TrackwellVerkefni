package com.example.demo.controller;

import com.example.demo.entities.Position;
import com.example.demo.entities.Vessel;
import com.example.demo.entities.VesselPosition;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.VesselService;
import org.springframework.web.bind.annotation.RequestBody;
import java.lang.Math;


import java.util.Date;

@RestController
@RequestMapping("/")
public class VesselController {
    @Autowired
    private VesselService vesselService;
    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/get{id}", method = RequestMethod.GET)
    @ResponseBody
    public VesselPosition get(@RequestParam(value = "id") int id) {
        Vessel v =vesselService.get(id);
        Position p = positionService.getByVesselId(id);
        VesselPosition vp = new VesselPosition();
        vp.setVessel(v);
        vp.setPosition(p);
        //Conversion
        p.setLatitudeDegrees(Math.toRadians(p.getLatitudeDegrees()));
        p.setLongitudeDegrees(Math.toRadians(p.getLongitudeDegrees()));
        p.setSpeedKnots(p.getSpeedKnots()*0.514444);
        return vp;
    }
    @RequestMapping(value = "/postVessel", method = RequestMethod.POST)
    public String post(@RequestBody VesselPosition vp){
        Position p = vp.getPosition();
        Date date = new Date();
        p.setReceivedDate(date);


        if(vesselService.find(vp.getVessel().getName()) == null){
            p.setVessel(vp.getVessel());
            vesselService.insert(vp.getVessel());
            positionService.insert(vp.getPosition());

        }else{
            Vessel oldVessel = vesselService.find(vp.getVessel().getName());
            p.setVessel(oldVessel);
            vesselService.insert(vp.getVessel());
            positionService.insert(p);
        }


        return "Success";

    }
}
