package com.example.meetingrooms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.meetingrooms.model.Room;
import com.example.meetingrooms.repository.RoomRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public Room create(Room room){
        if(roomRepository.existsByName(room.getName())){
            throw new IllegalArgumentException("There is already a room with that name.");
        }
        return roomRepository.save(room);
    }

    public List<Room> findAll(){
        return roomRepository.findAll();
    }

    public Room findById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Room not found"));
    }
}
