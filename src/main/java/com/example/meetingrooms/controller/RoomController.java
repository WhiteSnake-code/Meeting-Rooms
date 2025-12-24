package com.example.meetingrooms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.meetingrooms.model.Room;
import com.example.meetingrooms.service.RoomService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room create (@RequestBody Room room){
        return service.create(room);
    }

    @GetMapping
    public List<Room> findAllRooms(){
        return service.findAll();
    }
}
