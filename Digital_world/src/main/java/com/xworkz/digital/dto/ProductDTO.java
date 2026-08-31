package com.xworkz.digital.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private Integer id;
    private String name;
    private Double price;

    public ProductDTO(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
