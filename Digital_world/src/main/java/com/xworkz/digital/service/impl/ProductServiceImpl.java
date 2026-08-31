package com.xworkz.digital.service.impl;

import com.xworkz.digital.dao.ProductDAO;
import com.xworkz.digital.dao.impl.ProductDAOImpl;
import com.xworkz.digital.dto.ProductDTO;
import com.xworkz.digital.entity.ProductEntity;
import com.xworkz.digital.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService{

    private ProductDAO  productDAO = new ProductDAOImpl();

    @Override
    public String validateAndSave(List<ProductDTO> productDTOList) {
        String isSaved=null;

        if(productDTOList != null){
            List<ProductEntity> productEntityList = productDTOList.stream()
                    .map(productDTO -> new ProductEntity(productDTO.getName(),productDTO.getPrice())).collect(Collectors.toList());

            Boolean state=productDAO.saveAll(productEntityList);

            if(state){
                isSaved="success";
            }else {
                isSaved="fail";
            }
        }else {
            isSaved="Data is empty";
        }
        return isSaved;
    }

    @Override
    public String validateAndSave(ProductDTO productDTO) {
        String isSaved=null;

        if(productDTO != null){
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productDTO.getName());
            productEntity.setPrice(productDTO.getPrice());

            Boolean saved=productDAO.save(productEntity);

            if(saved){
                isSaved="Data Saved Successfully";
            }else{
                isSaved="Data Not Saved";
            }
        }else {
            isSaved="Data is Empty";
        }
        return isSaved;
    }

    @Override
    public ProductDTO findProductByIdAndName(Integer id, String name) {

        ProductDTO dto=null;
        if(id != null){
            ProductEntity entity=productDAO.getProductEntityByIdAndName(id,name);

            if(entity!=null){
                dto=new ProductDTO(entity.getName(),entity.getPrice());
            }
        }else {
            dto=null;
        }
        return dto;
    }
}
