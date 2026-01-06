package com.app.tasksphere.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue

    private UUID id;

    private String name;
    private Email email;
    private String password;
    private boolean active;

    //External code can’t misuse
    protected User(){};

    public User(Email email, String password, boolean active) {
        this.email = email;
        this.password = password;
        this.active = true;
    }

    public void deactivate(){
        this.active = false;
    }
}
