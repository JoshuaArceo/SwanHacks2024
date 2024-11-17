package com.swanhack.swan.users;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "classrooms")
public class Classroom {


    public static int nextID = 0;
    @Id
    private int id;

    private String name;

    @ManyToMany()
//    @JoinColumn(name = "classroom")
    private List<User> members;


    public List<User> getMembers() {
        return members;
    }

    public void addMember(User user) {
        this.members.add(user);
    }

    public void removeMember(User user) {
        this.members.remove(user);
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Classroom() {
        this.name = "Classroom " + nextID;
        this.members = new ArrayList<>();
        this.id = nextID++;
    }
    public Classroom(User user) {
        this.name = "Classroom " + nextID;
        this.members = new ArrayList<>();
        this.id = nextID++;
        addMember(user);
    }

    public Classroom(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.id = nextID++;
    }
}