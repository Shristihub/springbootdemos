package com.productapp.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity

@ToString
@NoArgsConstructor

public class Product {
    @Column(name="productid")
    @Id
    @GeneratedValue(generator = "product-seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="product-seq",sequenceName = "product_seq",initialValue = 12,allocationSize = 1)
    private Integer productId;
    private String name;
    private double price;
    private String category;
    private String brand;
//    @Column(columnDefinition = "varchar(20) default 'poppy'")
//    private String type;
//    public void setType(String type) {
//        this.type = type;
//    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//    public String getType() {
//        return type;
//    }
}
