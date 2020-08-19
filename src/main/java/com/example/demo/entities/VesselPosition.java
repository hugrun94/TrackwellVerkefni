package com.example.demo.entities;

public class VesselPosition {
    private Vessel vessel;
    private Position position;

    public Vessel getVessel() {
        return vessel;
    }

    public Position getPosition() {
        return position;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
