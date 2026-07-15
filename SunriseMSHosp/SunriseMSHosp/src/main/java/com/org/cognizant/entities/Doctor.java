package com.org.cognizant.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="doctor")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name= "name" , nullable = false, length = 100)
    private String name;

    @Column(name="specialization" , nullable = false, length = 100)
    private String specialization;

    @Column(name= "experience_years", nullable = false)
    private int experienceYears;

    @Column(name="consultation_fee")
    private Double consultationFee=0.0;
}
