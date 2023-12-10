package com.example.carservice2.mapper.impl;

import com.example.carservice2.mapper.Mapper;
import com.example.carservice2.models.Roles;
import com.example.carservice2.models.Users;
import com.example.carservice2.repositories.RolesRepository;
import com.example.carservice2.services.dto.UsersDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<Users, UsersDTO> {

    private final ModelMapper modelMapper;

    private final RolesRepository rolesRepository;

    @Autowired
    public UserMapper(ModelMapper modelMapper, RolesRepository rolesRepository) {
        this.modelMapper = modelMapper;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public Users toModel(UsersDTO dto) {
        Users user = modelMapper.map(dto, Users.class);
        if (dto.getRole() != null) {
            Roles role = rolesRepository.findById(dto.getRole()).orElseThrow(() -> new IllegalArgumentException("invalid role id"));
            user.setRole(role);
        }
        return user;
    }

    @Override
    public UsersDTO toDTO(Users user) {
        UsersDTO dto = modelMapper.map(user, UsersDTO.class);
        if (user.getRole() != null) {
            dto.setRole(user.getRole().getId());
        }
        return dto;
    }
}
