package com.hollersolutions.lil.landon_hotel;

import com.hollersolutions.lil.landon_hotel.data.entity.Room;
import com.hollersolutions.lil.landon_hotel.data.repository.RoomRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;


@Component
public class CLRunner implements CommandLineRunner {

    private final RoomRepository roomRepository;

    public CLRunner(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
   public void run(String... args) throws Exception {
        List<Room> rooms = this.roomRepository.findAll();
        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("P1");
        System.out.println(room);
        rooms.forEach(System.out::println);
    }


}
