package com.itacademy.AttendanceApp.entity;



import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
import java.util.List;

@Entity
@Data
@Table(name = "users", schema = "attendanceappdb")
public class User implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    @Column(name = "jmbg", unique = true)
    @Size(min = 5, max = 15)
    private Integer jmbg;

    @Basic(optional = false)
    @Column(name = "username")
    @Valid
    @NotBlank
    private String username;

    @Basic(optional = false)
    @Column(name = "password")
    @Valid
    @Size(min = 5, max = 15)
    private String password;

    @Basic(optional = false)
    @Column(name = "role")
    private String role;

    @Basic(optional = false)
    @Column(name = "isActive")
    private String isActive;

    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;

    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TimeEntry> timeEntries;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

