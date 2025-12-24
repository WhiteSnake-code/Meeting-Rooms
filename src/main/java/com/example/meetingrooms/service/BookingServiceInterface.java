package com.example.meetingrooms.service;

import java.util.List;

import com.example.meetingrooms.model.Booking;

public interface BookingServiceInterface {
    Booking create(Booking booking);
    List<Booking> findAll();
    List<Booking> findByRoom(Long roomId);
}   
