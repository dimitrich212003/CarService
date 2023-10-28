package com.example.carservice2.models;

import jakarta.persistence.*;

@Entity
public class Roles extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private RoleType role;
    public enum RoleType {
        USER(0),
        ADMIN(10);

        int num;

        RoleType(int num) {
            this.num = num;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
    }

    protected Roles() {

    }
    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}
