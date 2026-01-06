package com.app.tasksphere.domain.entity;

import com.app.tasksphere.domain.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.util.Objects;
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

    @Enumerated(EnumType.STRING)
    private UserRole role;

    //External code can’t misuse
    protected User(){};

    // intent-based methods (so i can avoid null or bad inputs)
    public User(Email email, String password, boolean active, UserRole newUserRole) {
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);
        this.role = Objects.requireNonNull(newUserRole);
        this.active = true;
    }

    public void deactivate(){
        this.active = false;
    }
    public void changeRole(UserRole newUserRole){
        this.role = Objects.requireNonNull(newUserRole);
    }

}
