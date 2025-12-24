package com.example.meetingrooms.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String reservedBy;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id")
    private Room room;

    public Booking(LocalDateTime startTime, LocalDateTime endTime, String reservedBy, Room room) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.reservedBy = reservedBy;
        this.room = room;
    }
}
