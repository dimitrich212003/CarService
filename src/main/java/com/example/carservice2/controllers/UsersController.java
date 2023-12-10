//package com.example.carservice2.controllers;
//
//import com.example.carservice2.services.UsersService;
//import com.example.carservice2.services.dto.UsersDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//public class UsersController {
//    private UsersService usersService;
//
//    @Autowired
//    public void setUsersRepository(UsersService usersService) {
//        this.usersService = usersService;
//    }
//
//    @GetMapping("/users")
//    public List<UsersDTO> getAllUsers() {
//        return usersService.getAllUsers();
//    }
//
//    @PostMapping("/users")
//    public ResponseEntity<UsersDTO> createUser(@RequestBody UsersDTO usersDTO) {
//        UsersDTO createUser = usersService.createUser(usersDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
//    }
//
//    @GetMapping("/users/{id}")
//    public UsersDTO getUserById(@PathVariable UUID id) {
//        return usersService.getUserById(id);
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUserByID(@PathVariable UUID id) {
//        usersService.deleteUser(id);
//    }
//
//    @PutMapping("/users/update/{id}")
//    public UsersDTO updateUser(@PathVariable UUID id, @RequestBody UsersDTO usersDTO) {
//        return usersService.updateUser(id, usersDTO);
//    }
//}
