package com.app.Trainbooking.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.app.Trainbooking.enumclass.SeatSection;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
@Table(name = "tb_train_user")
public class User {
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "reciept_id", nullable = false)
    private Receipt receipt;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "seat_section")
    private SeatSection seatSection;

    @Column(name = "seat_number")
    private String seatNumber;
	

}
