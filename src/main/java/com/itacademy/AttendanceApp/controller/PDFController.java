package com.itacademy.AttendanceApp.controller;

import com.itacademy.AttendanceApp.entity.TimeEntry;
import com.itacademy.AttendanceApp.generate.PDFGenerator;
import com.itacademy.AttendanceApp.service.TimeEntryService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PDFController {

    @Autowired
    private TimeEntryService timeEntryService;


    @GetMapping("/pdf/timeentry")
    public void generatePdf(HttpServletResponse response)throws DocumentException, IOException{


        response.setContentType("application/pdf");
        DateFormat dateFormat=new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime=dateFormat.format(new Date());
        String headerkey="Content_Disposition";
        String headervalue="attachment; filename=pdf_"+currentDateTime +".pdf";
        response.setHeader(headerkey,headervalue);

        List<TimeEntry>timeEntryList=timeEntryService.findAllTimeEntry();

        PDFGenerator generator=new PDFGenerator(timeEntryList);

          generator.generate(response);
    }

}
