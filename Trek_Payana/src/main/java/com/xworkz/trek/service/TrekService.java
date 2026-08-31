package com.xworkz.trek.service;

import com.xworkz.trek.dto.TrekDTO;

import java.util.List;

public interface TrekService {
    Boolean validateAndSaveAll(List<TrekDTO> dto);

    String validateAndSave(TrekDTO dto);

    TrekDTO findById(Integer id);


}
