package com.tw_mall.Mall.model;

import javax.persistence.*;

@Entity
@Table(name = "commodity")
public class Commodity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private String classification;
    private String brand;
    private String described;
    private int dates;
    private String place;

    public Commodity(String itemName, int price, String classification, String brand, String described, int bornDate, String bornPlace) {
        this.name = itemName;
        this.price = price;
        this.classification = classification;
        this.brand = brand;
        this.described = described;
        this.dates = bornDate;
        this.place = bornPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
    }

    public int getDates() {
        return dates;
    }

    public void setDates(int dates) {
        this.dates = dates;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Commodity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
