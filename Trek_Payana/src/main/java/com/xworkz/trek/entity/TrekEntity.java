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
@NamedQuery(name = "getAllTrekDetail", query = "select t from TrekEntity t")
@NamedQuery(name="getByPlace",query = "select t from TrekEntity t where t.place = :trekPlace")
@NamedQuery(name="getByMinimumMember",query = "select t from TrekEntity t where t.noOfMember >= :minMember")
@NamedQuery(name="getByDate",query="select t from TrekEntity t where t.date= : trekDate")
@NamedQuery(name="getByNewPlace", query="select t from TrekEntity t where t.place= : trekPlace")
@NamedQuery(name = "updateNoOfMembersByPlace", query = "Update TrekEntity t Set t.noOfMember = :newCount where t.place = :trekPlace")
@NamedQuery(name="updatePlaceById", query="update TrekEntity t set t.id =:newCount where t.place=:trekPlace")
@NamedQuery(name="updateByPlace",query = "update TrekEntity t set t.id=:newPlace where t.place=:trekPlace")
@NamedQuery(name="deleteById",query="delete from TrekEntity t where t.id=: trekId")
@NamedQuery(name="deleteByPlace",query="delete from TrekEntity t where t.place=: trekPlace")

public class TrekEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="place")
    private String place;
    @Column(name="date")
    private LocalDate date;
    @Column(name="noOfMember")
    private Integer noOfMember;

    public TrekEntity(String place, LocalDate date, Integer noOfMember) {
        this.place = place;
        this.date = date;
        this.noOfMember = noOfMember;
    }
}
