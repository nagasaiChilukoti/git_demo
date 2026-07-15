package com.org.cognizant.entities;

import com.org.cognizant.Enum.GenderEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="patient")
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private GenderEnum gender;

    @Column(name = "contact_number", nullable = false, length = 15)
    private String contactNumber;

}
