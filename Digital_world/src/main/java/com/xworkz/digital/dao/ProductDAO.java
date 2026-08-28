package com.xworkz.digital.dao;

import com.xworkz.digital.dto.ProductDTO;
import com.xworkz.digital.entity.ProductEntity;

import java.util.List;

public interface ProductDAO {
    Boolean save(ProductEntity entity);

    Boolean saveAll(List<ProductEntity> entityList);

    public ProductEntity getProductEntityById(Integer id);
}
