package com.xworkz.Event.dao;

import com.xworkz.Event.dto.EventDetailDTO;
import com.xworkz.Event.entity.EventEntity;

import java.util.List;

public interface EventDetailDAO {
    Boolean save(EventEntity eventEntity);

    String saveAll(List<EventEntity> eventEntityList);

    public EventEntity findById(Integer id);

}
