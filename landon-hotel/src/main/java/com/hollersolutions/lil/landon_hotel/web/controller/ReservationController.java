package com.hollersolutions.lil.landon_hotel.web.controller;


import com.hollersolutions.lil.landon_hotel.data.repository.ReservationRepository;
import com.hollersolutions.lil.landon_hotel.data.repository.RoomRepository;
import com.hollersolutions.lil.landon_hotel.service.RoomReservationService;
import com.hollersolutions.lil.landon_hotel.service.model.RoomReservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {


    private final RoomReservationService roomReservationService;

    public ReservationController(RoomReservationService roomReservationService) {
        //this.roomRepository = roomRepository;
        //this.reservationRepository = reservationRepository;
        this.roomReservationService = roomReservationService;
    }

    @GetMapping
    public String getReservations(Model model, @RequestParam(value="date", required=false)String strDate) {
        //First use the service to get the reservations by date

        model.addAttribute("reservations", this.roomReservationService.getRoomReservationsForDate(strDate));
        return "reservations-list";
    }

}
