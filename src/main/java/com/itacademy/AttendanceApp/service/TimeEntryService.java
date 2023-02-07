package com.itacademy.AttendanceApp.service;

import com.itacademy.AttendanceApp.entity.TimeEntry;
import com.itacademy.AttendanceApp.repository.TimeEntryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TimeEntryService {


    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public List<TimeEntry> getAllTimeEntry() {
        return timeEntryRepository.findAll();
    }

    public TimeEntry saveTimeEntry(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }


    public TimeEntry getByUser(String username) {
        return timeEntryRepository.findAllByUser(username);
    }



    public String deleteRow(Integer id) {
        timeEntryRepository.deleteById(id);
        return "Success";
    }

    public TimeEntry getById(Integer id) {
        Optional<TimeEntry> optional = timeEntryRepository.findById(id);
        TimeEntry timeEntry = optional.get();
        return timeEntry;

    }

    public List<TimeEntry> findAllTimeEntry(){
        return timeEntryRepository.findAll();
    }

    public void save(TimeEntry timeEntry){
        timeEntryRepository.save(timeEntry);
    }



}










