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
    public Boolean validateAndSave(List<TrekDTO> dto) {
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
}
