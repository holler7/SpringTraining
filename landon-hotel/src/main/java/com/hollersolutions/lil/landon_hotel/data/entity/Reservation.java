package com.hollersolutions.lil.landon_hotel.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name="reservations")
@Data
@ToString
public class Reservation {

    @Id
    @Column(name="reservation_id")
    private long id;

    @Column(name="room_id")
    private int roomId;

    @Column(name="guest_id")
    private int guestId;

    @Column(name="res_date")
    private Date resDate;

}