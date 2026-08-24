package com.xworkz.redbus.entity;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name="booking_table")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="from_location")
    private String from;

    @Column(name="to_location")
    private String to;

    @Column(name="on_ward_date")
    private LocalDate onWardDate;
}
