package com.itacademy.AttendanceApp.controller;

import com.itacademy.AttendanceApp.entity.TimeEntry;

import com.itacademy.AttendanceApp.service.TimeEntryService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/time")
public class TimeEntryController {
    private final TimeEntryService timeEntryService;

    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @PostMapping("/{username}/entry")
    public TimeEntry createTimeEntry(@PathVariable String username, @RequestBody TimeEntry timeEntry){
//        timeEntry.setUser(username);
        timeEntry.setId(null);
        return timeEntryService.saveTimeEntry(timeEntry);
    }

    @GetMapping("/{username}/entry")
    public TimeEntry getAllByUser(@PathVariable String username){
        return timeEntryService.getByUser(username);
    }

    @GetMapping("/")
    public List<TimeEntry> getAll(){
        return timeEntryService.getAllTimeEntry();
    }

    @DeleteMapping("/{username}/entry/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String username, @PathVariable int id){
        timeEntryService.deleteRow(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{username}/entry/{id}")
    public TimeEntry updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody TimeEntry timeEntry){
        timeEntryService.saveTimeEntry(timeEntry);
        return timeEntry;
    }
}




