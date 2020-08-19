package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date positionDate;
    private Date receivedDate;
    @JsonProperty("latitudeRadians")
    private double latitudeDegrees;
    @JsonProperty("longitudeRadians")
    private double longitudeDegrees;
    @JsonProperty("speedMetersPerSecond")
    private double speedKnots;
    @ManyToOne
    @JoinColumn(name="vesselid", nullable=false)
    @JsonIgnore
    private Vessel vessel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPositionDate() {
        return positionDate;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setPositionDate(Date positionDate) {
        this.positionDate = positionDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    @JsonProperty("latitudeDegrees")
    public void setLatitudeDegrees(double latitudeDegrees) {
        this.latitudeDegrees = latitudeDegrees;
    }

    @JsonProperty("longitudeDegrees")
    public void setLongitudeDegrees(double longitudeDegrees) {
        this.longitudeDegrees = longitudeDegrees;
    }

    @JsonProperty("speedKnots")
    public void setSpeedKnots(double speedKnots) {
        this.speedKnots = speedKnots;
    }
    @JsonProperty("latitudeRadians")
    public double getLatitudeDegrees() {
        return latitudeDegrees;
    }

    @JsonProperty("longitudeRadians")
    public double getLongitudeDegrees() {
        return longitudeDegrees;
    }
    @JsonProperty("speedMetersPerSecond")
    public double getSpeedKnots() {
        return speedKnots;
    }
}

