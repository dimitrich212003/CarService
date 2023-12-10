package com.example.carservice2.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class Offers extends ExtendsEntity {

    @Enumerated(EnumType.STRING)
    private TransmissionType transmission;
    public enum TransmissionType {
        MANUAL(0),
        AUTOMATIC(10);

        int num;

        TransmissionType(int num) {
            this.num = num;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
    }

    @Enumerated(EnumType.STRING)
    private EngineType engine;
    public enum EngineType {
        GASOLINE(0),
        DIESEL(10),
        ELECTRIC(20),
        HYBRID(30);

        int num;

        EngineType(int num) {
            this.num = num;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
    }

    private String imageUrl;

    private String description;

    private Integer mileage;

    private BigDecimal price;

    private Integer year;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Models model;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Users seller;
}
