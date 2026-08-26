package com.xworkz.Event.service;

import com.xworkz.Event.dto.EventDetailDTO;
import com.xworkz.Event.entity.EventEntity;

public interface EventService {
    boolean saveEvent(EventDetailDTO dto);
}
