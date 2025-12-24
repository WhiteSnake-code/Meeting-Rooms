package com.example.meetingrooms.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.meetingrooms.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Change from findByRoomId to findByRoom_RoomId
    List<Booking> findByRoom_RoomId(Long roomId);

    @Query("""
        SELECT b FROM Booking b 
        WHERE b.room.roomId = :roomId 
        AND b.startTime < :endTime 
        AND b.endTime > :startTime
    """)
    List<Booking> findConflictingBookings(
        @Param("roomId") Long roomId, 
        @Param("startTime") LocalDateTime startTime, 
        @Param("endTime") LocalDateTime endTime
    );
}
