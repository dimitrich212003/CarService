package com.example.carservice2.services.dto;

import com.example.carservice2.models.Models;
import com.example.carservice2.models.Offers;
import com.example.carservice2.models.Users;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.UUID;

public class OffersDTO extends BaseEntityDto{
    private String description;
    private Offers.EngineType engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private Offers.TransmissionType transmission;
    private int year;
    private UUID user;
    private UUID model;

    public OffersDTO() {
//        user = UUID.fromString("123");
    }

    @NotEmpty(message = "Описание не может быть пустым!")
    @Size(min = 5, message = "Описание должно быть не меньше 5 символов!")
    public String getDescription() {
        return description;
    }

    @NotNull(message = "Выберите тип двигателя!")
    public Offers.EngineType getEngine() {
        return engine;
    }

    @NotEmpty(message = "Ссылка на изображение не может быть пустым!")
    @Size(min = 10, message = "Ссылка на изображение должна быть не меньше 5 символов!")
    public String getImageUrl() {
        return imageUrl;
    }

    @Min(value = 0, message = "Пробег не может быть меньше нуля!")
    @NotNull(message = "Заполните это поле!")
    public int getMileage() {
        return mileage;
    }

    @Min(value = 0, message = "Цена не может быть меньше нуля!")
    @NotNull(message = "Заполните это поле!")
    public BigDecimal getPrice() {
        return price;
    }

    @NotNull(message = "Выберите тип КПП!")
    public Offers.TransmissionType getTransmission() {
        return transmission;
    }

    @NotNull(message = "Выберите год выпуска машины!")
    public int getYear() {
        return year;
    }

    @NotNull(message = "Выберите модель автомобиля!")
    public UUID getModel() {
        return model;
    }

    public UUID getUser() {
        return user;
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

    public void setModel(UUID model) {
        this.model = model;
    }

    public void setUser(UUID user) {
        this.user = user;
    }
}
