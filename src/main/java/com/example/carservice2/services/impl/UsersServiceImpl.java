package com.example.carservice2.services.impl;

import com.example.carservice2.mapper.impl.UserMapper;
import com.example.carservice2.models.Roles;
import com.example.carservice2.services.RolesService;
import com.example.carservice2.services.dto.RolesDTO;
import com.example.carservice2.services.dto.UsersDTO;
import com.example.carservice2.models.Users;
import com.example.carservice2.repositories.UsersRepository;
import com.example.carservice2.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;
    private final RolesService rolesService;
    private final ModelMapper modelMapper;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, UserMapper userMapper, RolesService rolesService, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
        this.rolesService = rolesService;
        this.modelMapper = modelMapper;
    }

    @Override
    public UsersDTO createUser(UsersDTO userDto) {
        Users user = userMapper.toModel(userDto);
        user.setCreated(LocalDate.now());
        user.setIsActive(true);
        Users createdUser = usersRepository.saveAndFlush(user);
        return userMapper.toDTO(createdUser);
    }


    @Override
    public UsersDTO updateUser(UUID id, UsersDTO userDto) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setImageUrl(userDto.getImageUrl());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setModified(LocalDate.now());

        Users updatedUser = usersRepository.saveAndFlush(user);
        return userMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(UUID id) {
        usersRepository.deleteById(id);
    }

    @Override
    public UsersDTO getUserById(UUID id) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(user -> userMapper.toDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDTO findByOfferId(UUID offerId) {
        Users user = usersRepository.findByOfferId(offerId);
        return userMapper.toDTO(user);
    }

    @Override
    public UsersDTO getUsersByUsername(String username) {
        Users user = usersRepository.getUsersByUsername(username);
        return userMapper.toDTO(user);
    }
}
