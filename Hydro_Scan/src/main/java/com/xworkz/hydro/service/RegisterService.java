package com.xworkz.hydro.service;

import com.xworkz.hydro.dto.RegisterDTO;

import java.util.List;

public interface RegisterService {
    Boolean validateAndSave(RegisterDTO registerDTO);

    Boolean validateSaveAll(List<RegisterDTO> registerDTOs);

    RegisterDTO findById(Integer id);
}
