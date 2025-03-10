package com.hollersolutions.lil.landon_hotel.data.repository;

import com.hollersolutions.lil.landon_hotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository <Reservation, Long> {
    Optional<Reservation> findByGuestId(int guestId);

    Optional<Reservation> getAllReservationsByResDate(Date resDate);

}
