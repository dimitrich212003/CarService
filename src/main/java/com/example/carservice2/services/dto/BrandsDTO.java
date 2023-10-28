package com.example.carservice2.services.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;
public class BrandsDTO {
    private UUID id;
    private String name;
    private List<String> modelsNames;

    public BrandsDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    @NotNull
    @NotEmpty
    @Length(min = 2, message = "Brand name must be minimum two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getModelsNames() {
        return modelsNames;
    }

    public void setModelsNames(List<String> modelsNames) {
        this.modelsNames = modelsNames;
    }
}