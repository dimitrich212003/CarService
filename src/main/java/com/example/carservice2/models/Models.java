package com.example.carservice2.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

import lombok.Data;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class Models extends ExtendsEntity {

    @Column(nullable = false)
    private String name;

    private String imageUrl;

    private Integer startYear;

    private Integer endYear;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "brand_id", nullable = false)
    private Brands brand;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Offers> offerList;

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
}