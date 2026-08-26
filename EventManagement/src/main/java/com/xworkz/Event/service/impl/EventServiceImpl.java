package com.xworkz.Event.service.impl;

import com.xworkz.Event.dao.EventDetailDAO;
import com.xworkz.Event.dao.impl.EventDetailDAOImpl;
import com.xworkz.Event.dto.EventDetailDTO;
import com.xworkz.Event.entity.EventEntity;
import com.xworkz.Event.service.EventService;

public class EventServiceImpl implements EventService{

    @Override
    public boolean saveEvent(EventDetailDTO dto) {
        System.out.println("Invoking saveEvent");
        boolean isSaved=false;

        if(dto != null){

            EventEntity entity=new EventEntity();

            entity.setEventName(dto.getEventName());
            entity.setEventDescription(dto.getEventDescription());
            entity.setEventDate(dto.getEventDate());

            EventDetailDAO dao=new EventDetailDAOImpl();
            Boolean saved = dao.save(entity);

            if(saved){
                isSaved=true;
                System.out.println("Event saved successfully");
            }else {

                System.out.println("Event not saved successfully");
            }
        }
        return isSaved;
    }
}
