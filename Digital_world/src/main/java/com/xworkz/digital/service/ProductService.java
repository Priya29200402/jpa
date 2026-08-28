package com.xworkz.digital.service;

import com.xworkz.digital.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    public String validateAndSave(List<ProductDTO> productDTOList);

    public String validateAndSave(ProductDTO productDTO);

    public ProductDTO findProductById(Integer id);
}
