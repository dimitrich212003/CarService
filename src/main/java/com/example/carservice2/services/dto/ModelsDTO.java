package com.example.carservice2.services.dto;

import com.example.carservice2.models.Models;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

public class ModelsDTO {
        private UUID id;
        private String name;
        private Models.CategoryType category;
        private String imageUrl;
        private int startYear;
        private int endYear;
        private UUID brand;


    public ModelsDTO() {

    }

    public UUID getId() {
        return id;
    }

    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Model name length must be more than two characters!")
    public String getName() {
        return name;
    }

    public Models.CategoryType getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Models.CategoryType category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }


    public UUID getBrand() {
        return brand;
    }

    public void setBrand(UUID brand) {
        this.brand = brand;
    }
}
