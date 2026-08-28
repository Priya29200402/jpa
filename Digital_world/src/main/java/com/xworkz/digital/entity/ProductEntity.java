package com.xworkz.digital.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="product_info")

public class ProductEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;


    public ProductEntity(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
