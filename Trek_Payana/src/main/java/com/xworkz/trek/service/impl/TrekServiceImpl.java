package com.xworkz.trek.service.impl;

import com.xworkz.trek.dao.TrekDAO;
import com.xworkz.trek.dao.impl.TrekDAOImpl;
import com.xworkz.trek.dto.TrekDTO;
import com.xworkz.trek.entity.TrekEntity;
import com.xworkz.trek.service.TrekService;

import java.util.List;
import java.util.stream.Collectors;

public class TrekServiceImpl implements TrekService {

    private TrekDAO trekDAO = new TrekDAOImpl();
    @Override
    public Boolean validateAndSaveAll(List<TrekDTO> dto) {
     Boolean isSaved = false;

     if(dto != null){
     List<TrekEntity> entityList=dto.stream()
             .map(TrekDTO -> new TrekEntity(TrekDTO.getPlace(),TrekDTO.getDate(),TrekDTO.getNoOfMember())).collect(Collectors.toList());

    Boolean save=trekDAO.saveAll(entityList);

    if(save){
       isSaved=true;
    }else {
        isSaved=false;
    }
     }else {
         isSaved=false;
     }

        return isSaved;
    }

    @Override
    public String validateAndSave(TrekDTO dto) {
        String isSaved=null;

        if(dto!=null){
            TrekEntity trekEntity = new TrekEntity();
            trekEntity.setPlace(dto.getPlace());
            trekEntity.setDate(dto.getDate());
            trekEntity.setDate(dto.getDate());

            String saved=trekDAO.save(trekEntity);

            if(saved!=null){
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
    public TrekDTO findById(Integer id) {
        TrekDTO dto=null;
        if(id != null){
            TrekEntity entity=trekDAO.getById(id);

            if(entity!=null){
                dto=new TrekDTO(entity.getPlace(),entity.getDate(),entity.getNoOfMember());
            }else {
                dto =null;
            }
        }
        return dto;
    }
}
