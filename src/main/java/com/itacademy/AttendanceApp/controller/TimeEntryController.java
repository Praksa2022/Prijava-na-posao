package com.itacademy.AttendanceApp.controller;

import com.itacademy.AttendanceApp.entity.TimeEntry;

import com.itacademy.AttendanceApp.entity.User;
import com.itacademy.AttendanceApp.service.TimeEntryService;

import com.itacademy.AttendanceApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/time")
@RequiredArgsConstructor
public class TimeEntryController {

    private final TimeEntryService timeEntryService;

    private final UserService userService;


   // public TimeEntryController(TimeEntryService timeEntryService) {
//        this.timeEntryService = timeEntryService;
//    }

    @PostMapping("/{id}")
    public ResponseEntity<TimeEntry> create(@PathVariable("id") Long id,
                                            @RequestBody TimeEntry timeEntry) throws IOException {
        User user = userService.findById(id);
        timeEntry.setUser(user);
        TimeEntry newTimeEntry = timeEntryService.saveTimeEntry(timeEntry);
        return new ResponseEntity<>(newTimeEntry, HttpStatus.CREATED);
    }

    @GetMapping("/{username}")
    public ResponseEntity<TimeEntry> getAllByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>((timeEntryService.getByUser(username)), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<TimeEntryListDTO> getAll() {
        return new ResponseEntity<>(new TimeEntryListDTO(timeEntryService.getAllTimeEntry()), HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<TimeEntry> updateTimeEntry(@PathVariable Integer id, @RequestBody TimeEntry timeEntry){
//        return new ResponseEntity<>(timeEntryService.updateTimeEntry(id, timeEntry), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        timeEntryService.deleteRow(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }







    }



