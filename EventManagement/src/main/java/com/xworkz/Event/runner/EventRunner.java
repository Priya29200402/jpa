package com.xworkz.Event.runner;

import com.xworkz.Event.dto.EventDetailDTO;
import com.xworkz.Event.service.EventService;
import com.xworkz.Event.service.impl.EventServiceImpl;
import java.time.LocalDate;

public class EventRunner{
    public static void main(String[] args){

        EventDetailDTO dto = new EventDetailDTO();

        dto.setEventName("Birthday");
        dto.setEventDescription("Need Decoration for Birthday celebration");
        dto.setEventDate(LocalDate.of(2026,02,25));

        EventService service=new EventServiceImpl();
        service.saveEvent(dto);


    }
}
