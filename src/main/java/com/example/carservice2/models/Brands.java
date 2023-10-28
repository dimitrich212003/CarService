package com.example.carservice2.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Brands extends ExtendsEntity{

    private String name;
    private List<Models> models;

    protected Brands() {

    }

    public String getName() {
        return name;
    }

    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE) // по умолчанию используется LAZY загрузка(Связанные сущности не будут подгружатся сразу)
    public List<Models> getModels() {
        return models;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModels(List<Models> models) {
        this.models = models;
    }
}
