package com.example.carservice2.repositories;

import com.example.carservice2.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RolesRepository extends JpaRepository<Roles, UUID> {
}
