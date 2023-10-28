package com.example.carservice2.services.impl;

import com.example.carservice2.services.dto.RolesDTO;
import com.example.carservice2.models.Roles;
import com.example.carservice2.repositories.RolesRepository;
import com.example.carservice2.services.RolesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RolesServiceImpl(RolesRepository rolesRepository, ModelMapper modelMapper) {
        this.rolesRepository = rolesRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public RolesDTO createRole(RolesDTO roleDTO) {
        Roles userRole = modelMapper.map(roleDTO, Roles.class);
        Roles createdUserRole = rolesRepository.saveAndFlush(userRole);
        return modelMapper.map(createdUserRole, RolesDTO.class);
    }

    @Override
    public RolesDTO updateRole(UUID id, RolesDTO roleDTO) {
        Roles role = rolesRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));

        role.setRole(Roles.RoleType.valueOf(String.valueOf(roleDTO.getRole())));

        Roles updatedUserRole = rolesRepository.save(role);
        return modelMapper.map(updatedUserRole, RolesDTO.class);
    }

    @Override
    public void deleteRole(UUID id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public RolesDTO getRoleById(UUID id) {
        Roles role = rolesRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return modelMapper.map(role, RolesDTO.class);
    }

    @Override
    public List<RolesDTO> getAllRoles() {
        List<Roles> roles = rolesRepository.findAll();
        return roles.stream()
                .map(role -> modelMapper.map(role, RolesDTO.class))
                .collect(Collectors.toList());
    }
}
