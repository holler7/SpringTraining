package com.hollersolutions.lil.landon_hotel;

import com.hollersolutions.lil.landon_hotel.data.entity.Reservation;
import com.hollersolutions.lil.landon_hotel.data.entity.Room;
import com.hollersolutions.lil.landon_hotel.data.repository.RoomRepository;
import com.hollersolutions.lil.landon_hotel.data.repository.ReservationRepository;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;


@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;

    public CLRunner(RoomRepository roomRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
   public void run(String... args) throws Exception {
        List<Room> rooms = this.roomRepository.findAll();
        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("P1");
        System.out.println(room);
        rooms.forEach(System.out::println);

        Optional<Reservation> reservation = this.reservationRepository.findByGuestId(1);

        System.out.println(reservation);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        reservation = this.reservationRepository.getAllReservationsByResDate(formatter.parse("2023-08-28"));

        System.out.println(reservation);
    }


}
