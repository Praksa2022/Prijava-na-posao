package com.itacademy.AttendanceApp.controller;

import com.itacademy.AttendanceApp.entity.TimeEntry;

import com.itacademy.AttendanceApp.service.TimeEntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/time")
public class TimeEntryController {

    @Autowired
    private final TimeEntryService timeEntryService;


    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @PostMapping("/{username}")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        return new ResponseEntity<>(timeEntryService.saveTimeEntry(timeEntry), HttpStatus.CREATED);
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



