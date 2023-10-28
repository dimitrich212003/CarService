package com.example.carservice2.services;

import com.example.carservice2.services.dto.UsersDTO;

import java.util.List;
import java.util.UUID;

public interface UsersService {
    UsersDTO createUser(UsersDTO userDto);

    UsersDTO updateUser(UUID id, UsersDTO userDto);

    void deleteUser(UUID id);

    UsersDTO getUserById(UUID id);

    List<UsersDTO> getAllUsers();
}
