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
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Double price;


    public ProductEntity(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
