package com.example.carservice2.services.impl;

import com.example.carservice2.services.dto.UsersDTO;
import com.example.carservice2.models.Users;
import com.example.carservice2.repositories.UsersRepository;
import com.example.carservice2.services.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UsersDTO createUser(UsersDTO userDto) {
        Users user = modelMapper.map(userDto, Users.class);
        Users createdUser = usersRepository.saveAndFlush(user);
        return modelMapper.map(createdUser, UsersDTO.class);
    }


    @Override
    public UsersDTO updateUser(UUID id, UsersDTO userDto) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setImageUrl(userDto.getImageUrl());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        Users updatedUser = usersRepository.saveAndFlush(user);
        return modelMapper.map(updatedUser, UsersDTO.class);
    }

    @Override
    public void deleteUser(UUID id) {
        usersRepository.deleteById(id);
    }

    @Override
    public UsersDTO getUserById(UUID id) {
        Users user = usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return modelMapper.map(user, UsersDTO.class);
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UsersDTO.class))
                .collect(Collectors.toList());
    }
}
