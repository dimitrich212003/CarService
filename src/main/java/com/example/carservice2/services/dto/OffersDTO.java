package com.example.carservice2.services.dto;

import com.example.carservice2.models.Models;
import com.example.carservice2.models.Offers;
import com.example.carservice2.models.Users;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

public class OffersDTO {
    private UUID id;
    private String description;
    private Offers.EngineType engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private Offers.TransmissionType transmission;
    private int year;
    private UsersDTO usersDTO;
    private UUID model;

    public OffersDTO() {

    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Offers.EngineType getEngine() {
        return engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @NotNull
    @NotEmpty
    public int getMileage() {
        return mileage;
    }

    @NotNull
    @NotEmpty
    @DecimalMin(value = "1000")
    public BigDecimal getPrice() {
        return price;
    }

    public Offers.TransmissionType getTransmission() {
        return transmission;
    }

    @NotNull
    @NotEmpty
    public int getYear() {
        return year;
    }

    @NotNull
    public UsersDTO getUsersDTO() {
        return usersDTO;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEngine(Offers.EngineType engine) {
        this.engine = engine;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setTransmission(Offers.TransmissionType transmission) {
        this.transmission = transmission;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setUsersDTO(UsersDTO usersDTO) {
        this.usersDTO = usersDTO;
    }

    public UUID getModel() {
        return model;
    }
    public void setModel(UUID model) {
        this.model = model;
    }
}
