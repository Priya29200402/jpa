package com.xworkz.Event.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name="event_table")

public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer eventId;
    @Column(name = "event_name")
    private String eventName;
    @Column(name="event_Description")
    private String eventDescription;
    @Column(name = "date")
    private LocalDate eventDate;

    public EventEntity(String eventName, LocalDate eventDate, String eventDescription) {
    }
}
