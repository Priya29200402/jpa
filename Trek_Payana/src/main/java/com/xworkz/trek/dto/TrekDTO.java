package com.xworkz.trek.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@Getter
@Setter
@ToString
public class TrekDTO {
    private Integer id;
    private String place;
    private LocalDate date;
    private Integer noOfMember;


    public TrekDTO(String place, LocalDate date, Integer noOfMember) {
        this.place = place;
        this.date = date;
        this.noOfMember = noOfMember;
    }
}
