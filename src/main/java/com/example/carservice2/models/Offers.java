package com.example.carservice2.models;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offers extends ExtendsEntity{
    private Models model;
    private Users user;
    private String description;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private int year;
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

    protected Offers() {

    }


//    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable=false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    public Models getModel() {
        return model;
    }
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable=false)
    public Users getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public EngineType getEngine() {
        return engine;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setYear(int year) {
        this.year = year;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }
}
