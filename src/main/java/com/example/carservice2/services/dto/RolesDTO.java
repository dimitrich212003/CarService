package com.example.carservice2.services.dto;

import com.example.carservice2.models.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

public class RolesDTO {
    private UUID id;
    private Roles.RoleType role;

    public RolesDTO() {

    }

    public UUID getId() {
        return id;
    }

    public Roles.RoleType getRole() {
        return role;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setRole(Roles.RoleType role) {
        this.role = role;
    }
}