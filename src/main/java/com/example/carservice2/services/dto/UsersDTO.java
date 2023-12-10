package com.example.carservice2.services.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public class UsersDTO extends BaseEntityDto{
    private UUID role;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isActive;
    private String imageUrl;

    public UsersDTO() {

    }

    @NotEmpty(message = "Имя пользователя не может быть пустым!")
    @Size(min = 4, message = "Имя пользователя должно быть минимум 4 символа!")
    public String getUsername() {
        return username;
    }

    @NotEmpty(message = "Пароль не может быть пустым!")
    @Size(min = 5, message = "Пароль должен быть минимум 5 символов!")
    public String getPassword() {
        return password;
    }

    @NotEmpty(message = "Имя не может быть пустым!")
    @Size(min = 2, message = "Имя должно быть минимум 2 символа!")
    public String getFirstName() {
        return firstName;
    }

    @NotEmpty(message = "Фамилия не может быть пустой!")
    @Size(min = 2, message = "Фамилия должна быть минимум 2 символа!")
    public String getLastName() {
        return lastName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    @NotEmpty(message = "Ссылка на изображение не может быть пустой!")
    @Size(min = 10, message = "Ссылка на изображение должна быть минимум 10 символов!")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UUID getRole() {
        return role;
    }

    public void setRole(UUID role) {
        this.role = role;
    }
}
