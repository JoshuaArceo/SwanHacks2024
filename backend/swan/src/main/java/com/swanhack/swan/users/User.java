package com.swanhack.swan.users;


import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class User {

    public enum UserType{
        @JsonEnumDefaultValue
        STUDENT,
        TEACHER
    }

    @JsonIgnore
    private byte[] passwordHash;
    @JsonIgnore
    private byte[] salt;

    private UserType userType;

    public User() {
    }

    /
    public User(String username){
        this.name = username;
        this.passwordHash = null;
        this.salt = null;
        this.userType = UserType.STUDENT;
    }

    public User(String username, byte[] passwordHash, byte[] salt){
        this.name = username;
        this.passwordHash = passwordHash;
        this.salt = salt;
        this.userType = UserType.TEACHER;
    }

    @Id
    private String name;

    public String getName() {
        return name;
    }






}
