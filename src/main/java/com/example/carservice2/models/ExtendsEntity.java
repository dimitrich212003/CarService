package com.example.carservice2.models;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public abstract class ExtendsEntity extends BaseEntity{
    private LocalDate created;
    private LocalDate modified;

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getModified() {
        return modified;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }
}
