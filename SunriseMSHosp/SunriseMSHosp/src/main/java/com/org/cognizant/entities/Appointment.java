package com.org.cognizant.entities;

import com.org.cognizant.Enum.StatusEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "appointment")
@Data
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;

    @Column(name = "appointment_date", nullable = false)
    private Date appointmentDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status=StatusEnum.SCHEDULED;

    @Column(name = "reason", nullable = false, length = 100)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
}
