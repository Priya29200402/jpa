package com.xworkz.trek.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="trek_info")

public class TrekEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String place;
    private LocalDate date;
    private Integer noOfMember;

    public TrekEntity(String place, LocalDate date, Integer noOfMember) {
        this.place = place;
        this.date = date;
        this.noOfMember = noOfMember;
    }
}
