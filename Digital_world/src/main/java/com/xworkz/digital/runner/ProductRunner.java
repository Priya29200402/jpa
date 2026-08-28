package com.xworkz.digital.runner;

import com.xworkz.digital.dto.ProductDTO;
import com.xworkz.digital.service.ProductService;
import com.xworkz.digital.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ProductRunner {
    public static void main(String[] args) {

        //Storing single Value
        ProductDTO dto= new ProductDTO("Laptop",45000.0);
        ProductService service=new ProductServiceImpl();
        service.validateAndSave(dto);

        //Storing Multiple Values
        List<ProductDTO> list=new ArrayList<>();
        list.add(new ProductDTO("Samsung Galaxy",82000.0));
        list.add(new ProductDTO("iPhone",90000.0));
        list.add(new ProductDTO("iPod",70000.0));

        ProductService service2=new ProductServiceImpl();
        service2.validateAndSave(list);

        //Finding dto by id
        ProductDTO dto2= service2.findProductById(1);
        System.out.println("DTO Found:"+dto2);
    }
}
