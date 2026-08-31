package com.xworkz.Event.service;

import com.xworkz.Event.dto.EventDetailDTO;
import com.xworkz.Event.entity.EventEntity;

import java.util.List;

public interface EventService {
    boolean saveEvent(EventDetailDTO dto);

    String validateAndSaveAll(List<EventDetailDTO> dtoList);

    EventDetailDTO findById(Integer id);
}
