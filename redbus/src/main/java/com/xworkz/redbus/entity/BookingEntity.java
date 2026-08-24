package com.xworkz.redbus.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name="booking_table")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="from")
    private String from;

    @Column(name="to")
    private String to;

    @Column(name="on_ward_date")
    private LocalDate onWardDate;
}
