package com.example.meetingrooms.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.meetingrooms.model.Booking;
import com.example.meetingrooms.model.Room;
import com.example.meetingrooms.repository.BookingRepository;
import com.example.meetingrooms.repository.RoomRepository;

@Service
public class BookingService {
     private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public BookingService(BookingRepository bookingRepository,
                              RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    public Booking create(Booking booking) {
        LocalDateTime start = booking.getStartTime();
        LocalDateTime end = booking.getEndTime();

        if (start == null || end == null || !end.isAfter(start)) {
            throw new IllegalArgumentException("Invalid date range");
        }

        Long roomId = booking.getRoom().getRoomId();
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        booking.setRoom(room);

        boolean hasConflicts = !bookingRepository
                .findConflictingBookings(roomId, start, end)
                .isEmpty();

        if (hasConflicts) {
            throw new IllegalStateException("The room is already booked for that time");
        }

        return bookingRepository.save(booking);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public List<Booking> findByRoom(Long roomId) {
        return bookingRepository.findByRoom_RoomId(roomId);
    }
}
