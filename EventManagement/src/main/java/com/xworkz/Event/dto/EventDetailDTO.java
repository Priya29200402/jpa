package com.xworkz.Event.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventDetailDTO {
    private String eventName;
    private String eventDescription;
    private LocalDate eventDate;

    public EventDetailDTO(String eventName, LocalDate eventDate, String eventDescription) {
    }
}
