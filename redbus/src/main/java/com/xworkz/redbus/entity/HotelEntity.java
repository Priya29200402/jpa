package com.xworkz.redbus.entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "hotel_table")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;

    @Column(name="City Name")
    private String cityName;

    @Column(name="Check In Date")
    private LocalDate checkInDate;

    @Column(name="Check Out Date")
    private LocalDate checkOutDate;

    @Column(name="No Of Guest")
    private Integer noOfGuest;
}
