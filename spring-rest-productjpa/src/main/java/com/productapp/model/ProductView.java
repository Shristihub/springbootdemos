package com.productapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class ProductView {
    @Column(name="productid")
    @Id
    private Integer productId;
    private String name;
    private Double price;


}
