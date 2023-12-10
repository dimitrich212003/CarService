package com.example.carservice2.services;

import com.example.carservice2.models.Roles;
import com.example.carservice2.services.dto.RolesDTO;

import java.util.List;
import java.util.UUID;

public interface RolesService {
    RolesDTO createRole(RolesDTO roleDto);

    RolesDTO updateRole(UUID id, RolesDTO roleDto);

    void deleteRole(UUID id);

    RolesDTO getRoleById(UUID id);

    List<RolesDTO> getAllRoles();

    RolesDTO findByRoleType(Roles.RoleType roleType);
}
