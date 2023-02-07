package com.itacademy.AttendanceApp.controller;

import com.itacademy.AttendanceApp.entity.TimeEntry;

import com.itacademy.AttendanceApp.entity.User;
import com.itacademy.AttendanceApp.repository.UserRepository;
import com.itacademy.AttendanceApp.service.TimeEntryService;

import jakarta.persistence.NoResultException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/time")
public class TimeEntryController {
    private final TimeEntryService timeEntryService;

    private final UserRepository userRepository;

    public TimeEntryController(TimeEntryService timeEntryService, UserRepository userRepository) {
        this.timeEntryService = timeEntryService;
        this.userRepository = userRepository;
    }

    @PostMapping("/{id}/entry")
    public ResponseEntity<Object> createTimeEntry(@PathVariable Long id, @Valid @RequestBody TimeEntry timeEntry){
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new NoResultException("user does not exist");

        timeEntry.setUser(user.get());
        TimeEntry savedTimeEntry = timeEntryService.saveTimeEntry(timeEntry);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(savedTimeEntry.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{username}/entry")
    public List<TimeEntry> getAllByUsername(@PathVariable String username){
        return getAllByUsername(username);
    }

    @GetMapping("/")
    public List<TimeEntry> getAll(){
        return timeEntryService.getAllTimeEntry();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        timeEntryService.deleteRow(id);
    }

    @PutMapping("/{username}/entry/{id}")
    public TimeEntry updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody TimeEntry timeEntry){
        timeEntryService.save(timeEntry);
        return timeEntry;
    }
}




