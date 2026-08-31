package com.xworkz.trek.service;

import com.xworkz.trek.dto.TrekDTO;

import java.util.List;

public interface TrekService {
    Boolean validateAndSave(List<TrekDTO> dto);
}
