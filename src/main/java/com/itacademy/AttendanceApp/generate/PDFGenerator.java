package com.itacademy.AttendanceApp.generate;

import com.itacademy.AttendanceApp.entity.TimeEntry;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Stream;

public class PDFGenerator {

    private List<TimeEntry>timeEntryList;

    public PDFGenerator(List<TimeEntry>timeEntryList){
        this.timeEntryList=timeEntryList;
    }


    public void generate(HttpServletResponse response) throws DocumentException, IOException{

        Document document=new Document(PageSize.A4);

        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();

        Font fontTitle= FontFactory.getFont(FontFactory.HELVETICA);
         fontTitle.setSize(20);


         Paragraph paragraph=new Paragraph("List of TimeEntry",fontTitle);
         paragraph.setAlignment(Paragraph.ALIGN_CENTER);

         document.add(paragraph);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new int[]{3,3,3});

        PdfPCell cell=new PdfPCell();
       cell.setBackgroundColor(CMYKColor.MAGENTA);
        cell.setPadding(5);

        Font font=FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(CMYKColor.WHITE);

        cell.setPhrase(new Phrase("ID",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Clocks_in"));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Clocks_out"));
        table.addCell(cell);

        for (TimeEntry timeEntry:timeEntryList){
            table.addCell(String.valueOf(timeEntry.getId()));
            table.addCell(String.valueOf(timeEntry.getClocksOut()));
             table.addCell(String.valueOf(timeEntry.getClocksIn()));

        }
        document.add(table);


        document.close();

    }


    public void setTimeEntryList(List<TimeEntry> timeEntryList) {
        this.timeEntryList = timeEntryList;
    }
}




