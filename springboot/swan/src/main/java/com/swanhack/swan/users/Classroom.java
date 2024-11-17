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

    @ManyToMany()
//    @JoinColumn(name = "classroom")
    private List<User> members;


    public List<User> getMembers() {
        return members;
    }

    public void addMember(User user) {
        this.members.add(user);
    }

    public Classroom() {
        this.members = new ArrayList<>();
        this.id = nextID++;
    }
    public Classroom(User user) {
        this.members = new ArrayList<>();
        this.id = nextID++;
        addMember(user);
    }
}