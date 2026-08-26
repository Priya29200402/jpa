package com.xworkz.Event.dao;

import com.xworkz.Event.dto.EventDetailDTO;
import com.xworkz.Event.entity.EventEntity;

public interface EventDetailDAO {
    Boolean save(EventEntity eventEntity);

}
