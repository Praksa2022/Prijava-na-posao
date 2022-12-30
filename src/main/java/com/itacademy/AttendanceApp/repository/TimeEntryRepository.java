package com.itacademy.AttendanceApp.repository;


import com.itacademy.AttendanceApp.entity.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry,Integer>{
    TimeEntry findAllByUser(String username);


}
