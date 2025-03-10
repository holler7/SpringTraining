package com.hollersolutions.lil.landon_hotel.data.repository;

import com.hollersolutions.lil.landon_hotel.data.entity.Guest;
import com.hollersolutions.lil.landon_hotel.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    Optional<Guest> findByLastNameIgnoreCase(String lastName);
}
