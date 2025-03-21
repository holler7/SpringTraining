package com.hollersolutions.lil.landon_hotel.service;

import com.hollersolutions.lil.landon_hotel.data.entity.Guest;
import com.hollersolutions.lil.landon_hotel.data.entity.Reservation;
import com.hollersolutions.lil.landon_hotel.data.entity.Room;
import com.hollersolutions.lil.landon_hotel.data.repository.GuestRepository;
import com.hollersolutions.lil.landon_hotel.data.repository.ReservationRepository;
import com.hollersolutions.lil.landon_hotel.data.repository.RoomRepository;
import com.hollersolutions.lil.landon_hotel.service.model.RoomReservation;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RoomReservationService {
    private final GuestRepository guestRepository;
    private final RoomRepository  roomRepository;
    private final ReservationRepository reservationRepository;

    public RoomReservationService(GuestRepository guestRepository, RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.guestRepository = guestRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public List<RoomReservation> getRoomReservationsForDate(String reservationDate) {

        Date date = null;
        if (StringUtils.isNotEmpty(reservationDate))
        {
            date = Date.valueOf(reservationDate);
        } else {
            date = new Date(new java.util.Date().getTime());
        }

        Map<Long, RoomReservation> roomReservations = new HashMap<>();
        List<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName() + "- Vacant");
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservations.put(room.getId(), roomReservation);
        });

        List<Reservation> reservations = this.reservationRepository.getAllReservationsByResDate(date);
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservations.get(reservation.getRoomId());
            roomReservation.setReservationId(reservation.getId());
            roomReservation.setReservationDate(reservation.getResDate().toString());
            if (reservation.getId() != 0) {
                Optional<Room> room = this.roomRepository.findById(roomReservation.getRoomId());
                roomReservation.setRoomName(room.get().getName());
            }
            Optional<Guest> guest = this.guestRepository.findById(reservation.getGuestId());
            roomReservation.setGuestId(guest.get().getId());
            roomReservation.setFirstName(guest.get().getFirstName());
            roomReservation.setLastName(guest.get().getLastName());
        });

        return roomReservations.values().stream().toList();

    }
}
