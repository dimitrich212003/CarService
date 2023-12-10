package com.example.carservice2.services.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;
public class BrandsDTO extends BaseEntityDto{
    private String name;

    public BrandsDTO() {
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
}