package com.xworkz.redbus.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "feedback_table")
public class FeedbackEntity {

    @Column(name="rating")
    private Integer rating;

    @Column(name="comment")
    private String comment;
}
