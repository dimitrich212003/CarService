package com.example.carservice2.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brands brand;

    @OneToMany(mappedBy = "model", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Offers> offers;

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

    @Override
    public String toString() {
        return "Model [id=" + id + ", name=" + name + ", brand=" + brand + "]";
    }
}