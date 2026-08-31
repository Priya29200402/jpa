package com.xworkz.hydro.dao;

import com.xworkz.hydro.dto.RegisterDTO;
import com.xworkz.hydro.entity.RegisterEntity;

import java.util.List;

public interface RegisterDAO {
       Boolean  save(RegisterEntity registerEntity);

       Boolean saveAll(List<RegisterEntity> registerEntitys);

       public RegisterEntity findById(Integer id);



}
