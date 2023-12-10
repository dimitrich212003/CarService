package com.example.carservice2.repositories;

import com.example.carservice2.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RolesRepository extends JpaRepository<Roles, UUID> {
    @Query("SELECT r FROM Roles r WHERE r.role = :roleType")
    Roles findByRoleType(@Param("roleType") Roles.RoleType roleType);
}
