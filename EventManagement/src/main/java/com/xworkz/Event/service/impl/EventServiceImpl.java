package com.xworkz.Event.service.impl;

import com.xworkz.Event.dao.EventDetailDAO;
import com.xworkz.Event.dao.impl.EventDetailDAOImpl;
import com.xworkz.Event.dto.EventDetailDTO;
import com.xworkz.Event.entity.EventEntity;
import com.xworkz.Event.service.EventService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventServiceImpl implements EventService{
    EventDetailDAO eventDetailDAO = new EventDetailDAOImpl();

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

    @Override
    public String validateAndSaveAll(List<EventDetailDTO> dtoList) {
        String result=null;

        if(dtoList!=null){
            List<EventEntity> entities=dtoList.stream()
                    .map(eventDetailDTO -> new EventEntity(eventDetailDTO.getEventName(),eventDetailDTO.getEventDate(),eventDetailDTO.getEventDescription())).collect(Collectors.toList());
            String saved=eventDetailDAO.saveAll(entities);

            if(saved!=null){
                result = "Event saved successfully";
            }else {
                result = "Event not saved successfully";
            }
        }else {
            result = "Event details is empty";
        }
        return result;
    }

    @Override
    public EventDetailDTO findById(Integer id) {
        EventDetailDTO dto=null;

        if(id!=null){
            EventEntity entity=eventDetailDAO.findById(id);

            if(entity!=null){
                dto=new EventDetailDTO(entity.getEventName(),entity.getEventDate(),entity.getEventDescription());
            }else {
                dto=null;
            }
        }
        return dto;
    }
}
