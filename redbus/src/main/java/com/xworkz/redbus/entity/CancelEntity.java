package com.xworkz.redbus.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "cancel_table")

public class CancelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private Integer id;

    @Column(name="Ticket Number")
    private Integer ticketNumber;

    @Column(name="Reason")
    private String reason;
}
