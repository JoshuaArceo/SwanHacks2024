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

    private String password;

//    @JsonIgnore
//    private byte[] passwordHash;


//    @JsonIgnore
//    private byte[] salt;

    private UserType userType;

    public User() {
    }

    public User(String username){
        this.name = username;
        this.password = null;
        this.userType = UserType.STUDENT;
    }

    public User(String username, String password /*, byte[] salt*/){
        this.name = username;
        this.password = password;
//        this.salt = salt;
        this.userType = UserType.TEACHER;
    }

    @Id
    private String name;

    public String getName() {
        return name;
    }






}
