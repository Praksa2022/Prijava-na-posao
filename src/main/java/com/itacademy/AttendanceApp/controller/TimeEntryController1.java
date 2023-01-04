package com.itacademy.AttendanceApp.controller;


import com.itacademy.AttendanceApp.entity.TimeEntry;


import com.itacademy.AttendanceApp.service.TimeEntryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(name = "/timeentry", method = RequestMethod.POST)
public class TimeEntryController1 {

    @Autowired
    private TimeEntryService timeEntryService;

    @GetMapping("/timeentry")
    public String viewEntry(Model model) {
        List<TimeEntry> timeEntryList = timeEntryService.getAllTimeEntry();
        model.addAttribute("listTimeEntry", timeEntryList);
        return "timeentry";
    }

    @GetMapping("/gettimeentrybyid")
    public String getTimeentrybyid(Model model) {
        TimeEntry timeEntry = new TimeEntry();
        model.addAttribute("ourTimeEntry", timeEntry);
        return "gettimeentrybyid";
    }

    @GetMapping("/deleterow")
    public String showdeleterow(Model model) {
        TimeEntry timeEntry = new TimeEntry();
        model.addAttribute("deleterow", timeEntry);
        return "delete_row";
    }

    @GetMapping("/showtimeentry")
    public String showNewUserForm(Model model) {
        TimeEntry timeEntry = new TimeEntry();
        model.addAttribute("ourTimeEntry", timeEntry);
        return "new_timeentry";
    }


    @GetMapping("/saveupdaterow")
    public String saveupdaterow(Model model) {
        TimeEntry timeEntry = new TimeEntry();
        model.addAttribute("saveupdaterow", timeEntry);
        return "update_row";
    }



    @RequestMapping({"/update"})
    public String updateTimeEntry1(Model model) {
        model.addAttribute("updateTimeEntry", timeEntryService);
        return "updateTimeEntry";
    }

    @RequestMapping(value = "/{getbyuser}", method = RequestMethod.GET)
    public String getbyuser(Model model) {
        TimeEntry timeEntry = new TimeEntry();
        model.addAttribute("getbyuser", timeEntry);
        return "user";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getbyuser(@ModelAttribute("ourUser") TimeEntry timeEntry) {
        timeEntryService.saveTimeEntry(timeEntry);
        return "redirect:/";
    }

    @RequestMapping(value = "/{deleterow}", method = RequestMethod.GET)
    public String deleteRow(@ModelAttribute("ourTimeEntry") TimeEntry timeEntry) {
        timeEntryService.saveTimeEntry(timeEntry);
        return "redirect:/";
    }
}
