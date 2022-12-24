package com.itacademy.AttendanceApp.service;

import com.itacademy.AttendanceApp.entity.TimeEntry;
import com.itacademy.AttendanceApp.repository.TimeEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeEntryService {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public List<TimeEntry> getAllTimeEntry() {
        List<TimeEntry> timeEntries = timeEntryRepository.findAll();
        return timeEntries;
    }

    public TimeEntry saveTimeEntry(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }


    public TimeEntry getByUser(String username) {
        return timeEntryRepository.findAllByUser(username);
    }

    public int updateTimeEntry(TimeEntry timeEntry) {
        timeEntryRepository.save(timeEntry);
        return 1;
    }

    public String deleteRow(Integer id) {
        timeEntryRepository.deleteById(id);
        return "Success";
    }

    public TimeEntry getTimeEntryById(Integer id) {
        Optional<TimeEntry> optional = timeEntryRepository.findById(id);
        TimeEntry timeEntry = optional.get();
        return timeEntry;

    }
}




