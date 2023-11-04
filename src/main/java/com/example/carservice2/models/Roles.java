package com.example.carservice2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Roles extends BaseEntity {

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Users> users;
}
