package com.itacademy.AttendanceApp.entity;


import jakarta.persistence.*;
import lombok.Data;




import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@Table(name = "timeentry", schema = "attendanceapp")

public class TimeEntry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clocks_in")
    private String clocksIn;

    @Column(name = "clocks_out")
    private String clocksOut;

    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return id.equals(timeEntry.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    }




