package com.xworkz.hydro.service.impl;

import com.xworkz.hydro.dao.RegisterDAO;
import com.xworkz.hydro.dao.impl.RegisterDAOImpl;
import com.xworkz.hydro.dto.RegisterDTO;
import com.xworkz.hydro.entity.RegisterEntity;
import com.xworkz.hydro.service.RegisterService;

import java.util.ArrayList;
import java.util.List;

public class RegisterServiceImpl implements RegisterService {

    private RegisterDAO registerDAO=new RegisterDAOImpl();
    @Override
    public Boolean validateAndSave(RegisterDTO registerDTO) {
        Boolean save=false;

        if(registerDTO != null){
            RegisterEntity registerEntity=new RegisterEntity();
            registerEntity.setId(registerDTO.getId());
            registerEntity.setName(registerDTO.getName());
            registerEntity.setEmail(registerDTO.getEmail());
            registerEntity.setMobileNo(registerDTO.getMobileNo());
            registerEntity.setPassword(registerDTO.getPassword());
            registerEntity.setConfirmPassword(registerDTO.getConfirmPassword());

            Boolean saved=registerDAO.save(registerEntity);
            if(saved){
                save=true;
            }else{
                save=false;

            }

        }else{
            save=false;
        }
        return save;
    }

    @Override
    public Boolean validateSaveAll(List<RegisterDTO> registerDTOs) {
        Boolean saved=false;

        if(registerDTOs != null){
            List<RegisterEntity> registerEntitys=new ArrayList<>();
            for(RegisterDTO registerDTO:registerDTOs){
                RegisterEntity registerEntity=new RegisterEntity();
                registerEntity.setName(registerDTO.getName());
                registerEntity.setEmail(registerDTO.getEmail());
                registerEntity.setMobileNo(registerDTO.getMobileNo());
                registerEntity.setPassword(registerDTO.getPassword());
                registerEntity.setConfirmPassword(registerDTO.getConfirmPassword());

                registerEntitys.add(registerEntity);

                Boolean save=registerDAO.save(registerEntity);
                if(save){
                    saved=true;
                }else{
                    saved=false;
                }
            }

        }else{
            saved=false;
        }
        return saved;
    }

    @Override
    public RegisterDTO findById(Integer id) {
        System.out.println("Getting User Info By ID:"+id);
        RegisterDTO dto=null;

        if(id!=null){
            RegisterEntity entity=registerDAO.findById(id);

            if(entity!=null){
                dto=new RegisterDTO(entity.getName(),entity.getEmail(),entity.getMobileNo(),entity.getPassword(),entity.getConfirmPassword());
            }
        }else {
            dto=null;
        }

        return dto;
    }
}
