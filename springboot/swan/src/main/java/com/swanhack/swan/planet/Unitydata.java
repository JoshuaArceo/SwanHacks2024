package com.swanhack.swan.planet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swanhack.swan.users.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Unitydata {
    @ManyToOne
    @JoinColumn(name = "username")
    @JsonIgnore
    private User user;


}
