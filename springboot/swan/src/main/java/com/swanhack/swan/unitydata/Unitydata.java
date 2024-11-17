package com.swanhack.swan.unitydata;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swanhack.swan.users.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UNITYDATA")
public class Unitydata {

    private static int nextID = 0;

    @Id
    private int id;

    @ManyToOne
    @JsonIgnore
    private User user;

    @Column(name = "attempt")
    private int attempt;

    @Column(name = "grade")
    private Character grade;

    public void setUser(User user) {
        this.user = user;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }

    public Character getGrade() {
        return grade;
    }

    public void setPlanetValues(List<PlanetValues> planetValues) {
        this.planetValues = planetValues;
    }
    public List<PlanetValues> getPlanetValues() {
        return planetValues;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Enum getActivityType() {
        return activityType;
    }

    public int getAttempt() {
        return attempt;
    }


    public enum ActivityType {
        @JsonEnumDefaultValue
        SCALE,
        DISTANCE
    }

    @Column(name = "activity_type")
    private ActivityType activityType;

    @ElementCollection
    @CollectionTable(name = "Unitydata_PlanetValues", joinColumns = @JoinColumn(name = "unitydata_id"))
    private List<PlanetValues> planetValues;
    public Unitydata() {
        this.id = nextID++;
        this.planetValues = new ArrayList<>();
    }

    public Unitydata(User user, Integer attempt, Character grade, ActivityType activityType, List<PlanetValues> planetValues) {
        this.id = nextID++;
        this.user = user;
        this.attempt = attempt;
        this.grade = grade;
        this.activityType = activityType;
        this.planetValues = planetValues;
    }



}
