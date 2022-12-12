package com.itacademy.AttendanceApp.repository;


import com.itacademy.AttendanceApp.entity.TimeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimeEntryRepository extends JpaRepository<TimeEntry,Long>{
    TimeEntry findAllByUser(String username);

}
