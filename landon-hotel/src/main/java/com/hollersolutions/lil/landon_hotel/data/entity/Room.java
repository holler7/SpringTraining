package com.hollersolutions.lil.landon_hotel.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="rooms")
@Data
@ToString
public class Room {

    @Id
    @Column(name="room_id")
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_seq")
    @SequenceGenerator(name = "room_seq", sequenceName = "rooms_seq", allocationSize = 1)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="room_number")
    private String roomNumber;

    @Column(name="bed_info")
    private String bedInfo;

    }

