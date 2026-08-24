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
@Table(name = "hotel_table")
public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="City_Name")
    private String cityName;

    @Column(name="Check_In_Date")
    private LocalDate checkInDate;

    @Column(name="Check_Out_Date")
    private LocalDate checkOutDate;

    @Column(name="No_Of_Guest")
    private Integer noOfGuest;
}
