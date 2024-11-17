package com.swanhack.swan.unitydata;

import jakarta.persistence.*;

@Embeddable
public class PlanetValues {


    private String planetName;

    @Column(name = "vector", length = 1000) // Store as a comma-separated string
    private String vector; // Serialized form of the list

    private Float percentError;


    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    // Getters and setters for percentError
    public Float getPercentError() {
        return percentError;
    }

    public void setPercentError(Float percentError) {
        this.percentError = percentError;
    }

    // Getter for vector as a List<Float>
    public String getVector() {
        return vector;
    }

    // Setter for vector as a List<Float>
    public void setVector(String vector) {
        this.vector = vector;
    }

    // Constructors
    public PlanetValues() {
        this.vector = "";
        this.planetName = "Unnamed Planet";
    }

    public PlanetValues(String planetName) {
        this.vector = "";
        this.planetName = planetName;
    }

    public PlanetValues(String planetName, String vector, Float percentError) {
        this.planetName = planetName;
        this.setVector(vector);
        this.percentError = percentError;
    }
}