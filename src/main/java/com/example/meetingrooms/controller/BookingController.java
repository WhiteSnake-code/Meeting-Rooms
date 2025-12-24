package com.example.meetingrooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.meetingrooms.model.Booking;
import com.example.meetingrooms.service.BookingService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private final BookingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking create(@RequestBody Booking booking) {
        return service.create(booking);
    }

    @GetMapping
    public List<Booking> findAll () {
        return service.findAll();
    }

    @GetMapping("/room/{roomId}")
    public List<Booking> findByRoom(@PathVariable Long roomId){
        return service.findByRoom(roomId);
    }
    
}
