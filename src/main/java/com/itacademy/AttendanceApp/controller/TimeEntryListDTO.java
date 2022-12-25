package com.itacademy.AttendanceApp.controller;

import com.itacademy.AttendanceApp.entity.TimeEntry;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TimeEntryListDTO {
    List<TimeEntry> timeEntries;
}
