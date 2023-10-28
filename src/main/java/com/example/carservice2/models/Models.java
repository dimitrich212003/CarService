package com.example.carservice2.models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
public class Models extends ExtendsEntity{
    private Brands brand;
    private List<Offers> offers;
    private String name;
    private String imageUrl;
    private int startYear;
    private int endYear;
    @Enumerated(EnumType.STRING)
    private CategoryType category;
    public enum CategoryType {
        CAR(0),
        BUSS(10),
        TRUCK(20),
        MOTORCYCLE(30);

        int num;

        CategoryType(int num) {
            this.num = num;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
    }

    protected Models() {

    }

    @ManyToOne(cascade = CascadeType.REMOVE) // по умолчанию используется LAZY загрузка(Связанные сущности не будут подгружатся сразу)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE) // При удалении родительской сущности связанные дочерние сущности будут удалены на уровне базы данных postgresql
    public Brands getBrand() {
        return brand;
    }

    @OneToMany(mappedBy = "model", cascade = CascadeType.REMOVE)
    public List<Offers> getOffers() {
        return offers;
    }

    public String getName() {
        return name;
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

    public CategoryType getCategory() {
        return category;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }

    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setCategory(CategoryType category) {
        this.category = category;
    }
}
