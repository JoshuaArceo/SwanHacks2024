package com.swanhack.swan.users;


import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import jakarta.persistence.*;
import org.springframework.stereotype.Controller;

@Entity
@Table(name = "users")
public class User {

    public enum UserType{
        @JsonEnumDefaultValue
        STUDENT,
        TEACHER
    }
    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)

    private String lastName;
    @Column(name="password", nullable = false)
    private String password;

//    @JsonIgnore
//    private byte[] passwordHash;


//    @JsonIgnore
//    private byte[] salt;

    @Column(name = "user_type", nullable = false)
    private UserType userType;

    public User() {
    }

    public User(String username){
        this.username = username;
        this.password = null;
        this.userType = UserType.STUDENT;
    }

    public User(String username, String password /*, byte[] salt*/){
        this.username = username;
        this.password = password;
//        this.salt = salt;
        this.userType = UserType.TEACHER;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }








}
