package com.example.carservice2.services.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public class UsersDTO {
    private UUID id;
    private String role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private String imageUrl;


    public UsersDTO() {

    }


    public UUID getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @NotNull
    @NotEmpty
    @Length(min = 4, message = "Username must be minimum 4 characters!")
    public String getUsername() {
        return username;
    }

    @NotNull
    @NotEmpty
    @Length(min = 5, message = "Password must be minimum 5 characters!")
    public String getPassword() {
        return password;
    }


    @NotNull
    @NotEmpty
    @Length(min = 2, message = "First name must be minimum 2 characters!")
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Last name must be minimum 2 characters!")
    public String getLastName() {
        return lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
